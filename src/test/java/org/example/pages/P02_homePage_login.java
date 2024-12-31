package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.example.stepDefs.Hooks.driver;


public class P02_homePage_login {
    public P02_homePage_login(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login2")
    public WebElement loginPage;

    @FindBy(id = "loginusername")
    public WebElement loginUsername;

    @FindBy(id = "loginpassword")
    public WebElement loginPassword;

    @FindBy(css = "button[onclick=\"logIn()\"]")
    public WebElement loginBtn;

    @FindBy(css = "a[id=\"logout2\"]")
    public WebElement logOutBtn;


}
