package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_homePage_signUp;
import org.openqa.selenium.Alert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;


public class D01_signUp {

    P01_homePage_signUp home = new P01_homePage_signUp();



    @Given("user clicks sign up button in header")
    public void userOpenSignUpPage(){
        home.signUpPage.click();
    }

    @When("user fills in username {string}")
    public void userFillsInUsername(String username) {
        home.signUpUsername.sendKeys(username);
    }

    @And("user fills in password {string}")
    public void userFillsInPassword(String password) {
        home.signUpPassword.sendKeys(password);
    }


    @And("user clicks on sign up button")
    public void userClicksOnSignUpButton() {
        home.signUpBtn.click();
    }

    @Then("success message should be displayed")
    public void successMessageShouldBeDisplayed() throws InterruptedException {

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        boolean result = alertText.contains("Sign up successful.");

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(result);

        alert.accept();

    }


    @Then("error message is displayed")
    public void errorMessageIsDisplayed() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        boolean result = alertText.contains("This user already exist.");

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(result);

        alert.accept();
    }
}
