package org.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;


public class P03_addProducts {
    public P03_addProducts() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[onclick=\"byCat('notebook')\"]")
    public WebElement laptops;

    @FindBy(css = "a[href=\"prod.html?idp_=11\"][class=\"hrefch\"]")
    public WebElement checkpointProd;

    @FindBy(css = "a[class=\"btn btn-success btn-lg\"]")
    public WebElement addToCart;

    @FindBy(css = "a[class=\"nav-link\"][href=\"index.html\"]")
    public WebElement homeBtn;

    @FindBy(css = "a[href=\"cart.html\"]")
    public WebElement cartBtn;

    @FindBy(css = "a[href*=\"prod.html?idp_=\"][class=\"hrefch\"]")
    public List<WebElement> ProductsList;

    @FindBy(id = "totalp")
    public WebElement totalBox;

    @FindBy(css = "button[data-toggle=\"modal\"]")
    public WebElement placeOrder;

    @FindBy(id = "totalm")
    public WebElement totalPlaceOrder;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(css = "button[onclick=\"purchaseOrder()\"]")
    public WebElement purchaseBtn;

    @FindBy (xpath = "//div[@class=\"sweet-alert  showSweetAlert visible\"]/h2")
    public WebElement successMsg;
}
