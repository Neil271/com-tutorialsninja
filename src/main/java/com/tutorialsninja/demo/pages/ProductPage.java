package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(css = "div[id='content'] h1")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']//button[@type='button']")
    WebElement deliveryDatePicker;

    @CacheLookup
    @FindBy(css = "div[class='datepicker-days'] th[class='picker-switch']")
    WebElement monthYear;

    @CacheLookup
    @FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next'][contains(text(),'›')]")
    WebElement clickNextButton;

    @CacheLookup
    @FindBy(xpath = "//tbody/tr/td[@class='day']")
    WebElement dateList;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement productQty;

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement shoppingCartMessage;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement shoppingCartLink;


    /**
     * This method will get the product name
     */
    public void getProductNameFromProductPage(String expected, String msg) {
        CustomListeners.test.log(Status.PASS, "get the product name");
        Reporter.log("get the product name" + productName.toString());
        verifyText(getTextFromElement(productName), expected, msg);
    }
    /**
     * This method will select the date from the dropdown
     * */


    /**
     * This method will change the qty of the product
     */
    public void productQty(String qty) {
        CustomListeners.test.log(Status.PASS, "change the qty of the product");
        Reporter.log("change the qty of the product" + productQty.toString());
        sendTextToElement(productQty, qty);
    }

    /**
     * This method will click on the add to cart button
     */
    public void clickOnTheAddToCart() {
        CustomListeners.test.log(Status.PASS, "click on the add to cart button");
        Reporter.log("click on the add to cart button" + addToCart.toString());
        clickOnElement(addToCart);
    }

    /**
     * This method will get the shopping cart message
     */
    public void getShoppingCartMessage(String expected, String msg) throws InterruptedException {
        // Thread.sleep(3000);
        CustomListeners.test.log(Status.PASS, "get the shopping cart message");
        Reporter.log("get the shopping cart message" + shoppingCartMessage.toString());
        verifyText(getTextFromElement(shoppingCartMessage).split("\n")[0], expected, msg);
    }

    /**
     * This method will click on the shopping cart link
     */
    public void clickOnTheShoppingCartLink() {
        CustomListeners.test.log(Status.PASS, "click on the shopping cart link");
        Reporter.log("click on the shopping cart link" + shoppingCartLink.toString());
        //waitUntilVisibilityOfElementLocated(shoppingCartLink,4);
        clickOnElement(shoppingCartLink);
    }
}
