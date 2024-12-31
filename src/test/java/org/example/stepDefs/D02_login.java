package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_homePage_login;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class D02_login {

    P02_homePage_login login = new P02_homePage_login();

    @Given("user clicks login button in header")
    public void userClicksLoginButton() {
        login.loginPage.click();
    }


    @When("user enters username {string}")
    public void userFillsInUsername(String username) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login.loginUsername.sendKeys(username);
    }

    @And("user enters password {string}")
    public void userFillsInPassword(String password) throws InterruptedException {
        Thread.sleep(3000);
        login.loginPassword.sendKeys(password);
    }

    @And("user clicks on login button")
    public void userClicksOnLoginButton() throws InterruptedException {

        Thread.sleep(3000);
        login.loginBtn.click();
    }

    @Then("account opens successfully")
    public void accountOpensSuccessfullyAndUserShouldBeAbleToUseTheirAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(login.logOutBtn));

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(login.logOutBtn.isDisplayed());
    }

    @When("user enters incorrect username {string}")
    public void userEntersIncorrectUsername(String wrongUsername) {
        login.loginUsername.sendKeys(wrongUsername);
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String error1) throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        boolean result = alertText.contains(error1);

        SoftAssert soft = new SoftAssert();
        soft.assertTrue(result);

        alert.accept();
    }
}
