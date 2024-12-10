package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {

    @CacheLookup
    @FindBy(xpath ="//h1[contains(text(),'Shopping Cart')]" )
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath ="//body[1]/div[2]/div[2]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]" )
    WebElement productName;

    By deliveryDate = By.cssSelector("body > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > form:nth-child(2) > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(2) > small:nth-child(3)");

    @CacheLookup
    @FindBy(xpath ="//td[normalize-space()='Product 21']" )
    WebElement modelName;

    @CacheLookup
    @FindBy(xpath ="//tbody//tr//td[6]" )
    WebElement productPrice;

    @CacheLookup
    @FindBy(css ="input[value='1']" )
    WebElement productQty;

    @CacheLookup
    @FindBy(xpath ="//button[@type='submit']" )
    WebElement updateButton;

    @CacheLookup
    @FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']" )
    WebElement updateMessage;

    @CacheLookup
    @FindBy(xpath ="//a[@class='btn btn-primary']" )
    WebElement checkOutButton;

    /**
     * This Method will get the shopping cart text
     */
    public void getShoppingCartText(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the shopping cart text");
        Reporter.log("get the shopping cart text" + shoppingCartText.toString());
        verifyText(getTextFromElement(shoppingCartText),expected,msg);
    }
    /**
     * This Method will get the product name from the cart
     */
    public void getProductName(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the product name from the cart");
        Reporter.log("get the product name from the cart" + productName.toString());
        verifyText(getTextFromElement(productName),expected,msg);
    }
    /**
     * This Method will get the product name from the cart
     */
    public String getProductNames() {
        CustomListeners.test.log(Status.PASS, "get the product name from the cart");
        Reporter.log("get the product name from the cart" + productName.toString());
        return getTextFromElement(productName);
    }
    /**
     * This method will get the product delivery date
     */
    /*public String[] getDeliveryDate() {
        CustomListeners.test.log(Status.PASS, "get the Register text");
        Reporter.log("get the Register text" + registerText.toString());
        return getTextFromElement(deliveryDate).split(":");
    }*/

   /* public void getDeliveryDate(String expected, String msg){
        verifyText(getTextFromElement(deliveryDate).split(":"),expected,msg);
    }*/
    /**
     * This method will get the product model
     */
    public void getProductModel(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the product model");
        Reporter.log("get the product model" + modelName.toString());
         verifyText(getTextFromElement(modelName),expected,msg);
    }
    /**
     * This method will get the price
     */
    public void getPrice(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the price");
        Reporter.log("get the price" + productPrice.toString());
        verifyText(getTextFromElement(productPrice),expected,msg);
    }
    /**
     * This method will update the qty
     */
    public void changeQtyOfProduct(String qty) {
        CustomListeners.test.log(Status.PASS, "will update the qty");
        Reporter.log("will update the qty" + productQty.toString());
        sendTextToElement(productQty, qty);
    }

    /**
     * click on the update cart button
     */
    public void clickOnUpdateButton() {
        CustomListeners.test.log(Status.PASS, "update cart button");
        Reporter.log("update cart button" + updateButton.toString());
        clickOnElement(updateButton);
    }

    /**
     * This method will get the updated cart message
     */
    public void getUpdatedCartMessage(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the updated cart message");
        Reporter.log("get the updated cart message" + updateMessage.toString());
         verifyText(getTextFromElement(updateMessage).split("\n")[0],expected,msg);
    }

    /**
     * This method will click on the checkout button
     */
    public void clickOnCheckOut() {
        CustomListeners.test.log(Status.PASS, "click on the checkout button");
        Reporter.log("click on the checkout button" + checkOutButton.toString());
        clickOnElement(checkOutButton);
    }

}
