package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement registerText;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement telephone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement cPassword;

    @CacheLookup
    @FindBy(css = "input[value='1'][name='newsletter']")
    WebElement yesRadio;

    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyCheckBox;

    @CacheLookup
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement registerSuccessMessageElement;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueSuccess;


    /**
     * This method will get the Register text
     */
    public void getRegisterText(String expected, String msg) {
        CustomListeners.test.log(Status.PASS, "get the Register text");
        Reporter.log("get the Register text" + registerText.toString());
        verifyText(getTextFromElement(registerText), expected, msg);
    }

    /**
     * This method will get the Register successful text
     */
    public void getRegisterSuccessfulText(String expected, String msg) {
        CustomListeners.test.log(Status.PASS, " get the Register successful text");
        Reporter.log(" get the Register successful text" + registerSuccessMessageElement.toString());
        verifyText(getTextFromElement(registerSuccessMessageElement), expected, msg);
    }

    /**
     * This method will enter firstname
     */
    public void enterFirstName(String fName) {
        CustomListeners.test.log(Status.PASS, "enter firstname");
        Reporter.log("enter firstname" + firstName.toString());
        sendTextToElement(firstName, fName);
    }

    /**
     * This method will enter firstname
     */
    public void enterLastName(String lName) {
        CustomListeners.test.log(Status.PASS, "enter firstname");
        Reporter.log("enter firstname" + lastName.toString());
        sendTextToElement(lastName, lName);
    }

    /**
     * This method will enter email
     */
    public void enterEmail(String emailAddress) {
        CustomListeners.test.log(Status.PASS, "enter email");
        Reporter.log("enter email" + email.toString());
        sendTextToElement(email, emailAddress);
    }

    /**
     * This method will enter telephone
     */
    public void enterTelephone(String phone) {
        CustomListeners.test.log(Status.PASS, "enter telephone");
        Reporter.log("enter telephone" + telephone.toString());
        sendTextToElement(telephone, phone);
    }

    /**
     * This method will enter password
     */
    public void enterPassword(String passwordText) {
        CustomListeners.test.log(Status.PASS, "enter password");
        Reporter.log("enter password" + password.toString());
        sendTextToElement(password, passwordText);
    }

    /**
     * This method will enter confirmPassword
     */
    public void enterConfirmPassword(String passwordText) {
        CustomListeners.test.log(Status.PASS, "enter confirmPassword");
        Reporter.log("enter confirmPassword" + cPassword.toString());
        sendTextToElement(cPassword, passwordText);
    }

    /**
     * This method will click on the Yes radio button
     */
    public void clickOnTheYesRadioButton() {
        CustomListeners.test.log(Status.PASS, "click on the Yes radio button");
        Reporter.log("click on the Yes radio button" + yesRadio.toString());
        clickOnElement(yesRadio);
    }

    /**
     * This method will click on privacy checkbox
     */
    public void clickOnThePrivacyCheckbox() {
        CustomListeners.test.log(Status.PASS, "click on privacy checkbox");
        Reporter.log("click on privacy checkbox" + privacyCheckBox.toString());
        clickOnElement(privacyCheckBox);
    }

    /**
     * This method will click on the continue button
     */
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS, "click on the continue button");
        Reporter.log("click on the continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }

    /**
     * This method will click on the continue successful button
     */
    public void clickOnContinueButtonAfterSuccessfulAccountCreated() {
        CustomListeners.test.log(Status.PASS, "click on the continue successful button");
        Reporter.log("click on the continue successful button" + continueSuccess.toString());
        clickOnElement(continueSuccess);
    }
}
