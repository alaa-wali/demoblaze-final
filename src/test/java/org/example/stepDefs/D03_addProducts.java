package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_addProducts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;


public class D03_addProducts {

    public static int index;
    public Double totalPriceSum;
    P03_addProducts products = new P03_addProducts();

    @Given("user clicks on Laptops in categories list")
        public void clickOnLaptops(){

        products.laptops.click();

        //explicit wait to ensure laptop products have been loaded before choosing
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(products.checkpointProd));
        }

    @When("user chooses product {int}")
    public void userChoosesProduct(int index) {

        D03_addProducts.index = index;
        products.ProductsList.get(index-1).click();
        //(index-1) is because list starts with 0
    }


    @And("user clicks on add to cart")
    public void userClicksOnAddToCart() {
        products.addToCart.click();
    }

    @Then("product is successfully added to cart")
    public void productIsSuccessfullyAddedToCart() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        boolean result = alertText.toLowerCase().contains("product added");

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(result);

        alert.accept();
    }

    @Given("user goes to home page")
    public void userGoesToHomePage() {
        products.homeBtn.click();
    }


    @Given("user clicks on cart button in header")
    public void userClicksOnCartButtonInHeader() {
        products.cartBtn.click();
    }


    @Then("user finds both products displayed in the cart with respective titles and prices")
    public void userFindsBothProductsDisplayed() {
        double totalPriceSum = 0;
        while (index>=1) {
            String titleXpath = "//tbody/tr[" + (index) + "]/td[2]";
            String priceXpath = "//tbody/tr[" + (index) + "]/td[3]";

            WebElement titles = driver.findElement(By.xpath(titleXpath));
            WebElement prices = driver.findElement(By.xpath(priceXpath));

            SoftAssert soft = new SoftAssert();
            soft.assertTrue(titles.isDisplayed());
            soft.assertTrue(prices.isDisplayed());
            soft.assertAll();

            String productPrice = prices.getText();
            totalPriceSum += Double.parseDouble(productPrice);
            this.totalPriceSum=totalPriceSum;
            index--;
        }
        System.out.println("Total Products Price Sum is " + totalPriceSum);
    }

    @And("total amount is calculated correctly")
    public void totalAmountIsCalculatedCorrectly() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(products.totalBox));

        double totalCart = Double.parseDouble(products.totalBox.getText());

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(totalPriceSum,totalCart);

        System.out.println("Total in Cart is " + totalCart);
    }

    @When("user clicks on place order button")
    public void userClicksOnPlaceOrderButton() {
        products.placeOrder.click();
    }

    @Then("total amount is calculated correctly on the place order page")
    public void totalAmountIsCalculatedCorrectlyOnThePlaceOrderPage() throws InterruptedException {

        Thread.sleep(6000);

        double totalPlaceOrder = Double.parseDouble(products.totalPlaceOrder.getText().replaceAll("[^\\d.]", ""));
        //used replaceAll("[^\\d.]", "") to remove the text and symbols and only leave the numbers

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(totalPlaceOrder,totalPriceSum);
        soft.assertAll();

        System.out.println("Total in Place Order Page is " + totalPlaceOrder);

    }

    @When("user fills out name {string}, country {string}, city {string}, credit card number {string}, month {string} and year {string}")
    public void userFillsOutNameCountryCityCreditCardNumberMonthAndYear(String name, String country, String city, String creditCardNum, String month, String year) {

        products.name.sendKeys(name);
        products.country.sendKeys(country);
        products.city.sendKeys(city);
        products.card.sendKeys(creditCardNum);
        products.month.sendKeys(month);
        products.year.sendKeys(year);
    }

    @And("user clicks on purchase button")
    public void userClicksOnPurchaseButton() {
        products.purchaseBtn.click();

    }

    @Then("order is placed successfully and a success message is displayed")
    public void orderIsPlacedSuccessfullyAndASuccessMessageIsDisplayed() {
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(products.successMsg.getText(), "Thank you for your purchase!");
        soft.assertAll();

    }

    @Then("product is added in cart twice")
    public void productIsAddedInCartTwice() {
        String title1Xpath = "//tbody/tr[1]/td[2]";
        String title2Xpath = "//tbody/tr[2]/td[2]";

        String title1 = driver.findElement(By.xpath(title1Xpath)).getText();
        String title2 = driver.findElement(By.xpath(title2Xpath)).getText();

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(title1, title2);
        soft.assertAll();

    }
}
