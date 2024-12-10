package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Returning Customer']")
    WebElement loginText;

    /**
     * This method will get the Login text
     */
    public String getLoginText() {
        CustomListeners.test.log(Status.PASS, " get the Login text");
        Reporter.log(" get the Login text" + loginText.toString());
        return getTextFromElement(loginText);
    }

    /**
     * This method will enter email Address
     */
    public void enterEmail(String emailAdd) {
        CustomListeners.test.log(Status.PASS, "enter email Address");
        Reporter.log("enter email Address" + email.toString());
        sendTextToElement(email,emailAdd);
    }
    /**
     * This method will enter password
     */
    public void enterPassword(String pass){
        CustomListeners.test.log(Status.PASS, "enter password");
        Reporter.log("enter password" + password.toString());
        sendTextToElement(password,pass);
    }
    /**
     * This method will click on login button
     */
    public void clickOnLoginButton(){
        CustomListeners.test.log(Status.PASS, "click on login button");
        Reporter.log("click on login button" + loginButton.toString());
        clickOnElement(loginButton);
    }
}
