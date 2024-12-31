package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.example.stepDefs.Hooks.driver;

public class P01_homePage_signUp {

public P01_homePage_signUp() {
    PageFactory.initElements(driver, this);
}

@FindBy(id = "signin2")
    public WebElement signUpPage;

@FindBy(id = "sign-username")
    public WebElement signUpUsername;

@FindBy(id = "sign-password")
    public WebElement signUpPassword;

@FindBy(css = "button[onclick=\"register()\"]")
    public WebElement signUpBtn;

}
