package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckOutPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Checkout']")
    WebElement checkOutText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement notAvailableMessage;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@value='guest']")
    WebElement guestRadioButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement telephoneNumber;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-guest']")
    WebElement continueButtonGuest;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement continueButtonDelivery;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueButtonPayment;

    @CacheLookup
    @FindBy(xpath = "//div[@id='collapse-payment-method']//textarea[@name='comment']")
    WebElement textBox;


    @CacheLookup
    @FindBy(xpath = "//input[@name='agree']")
    WebElement agree;


    /**
     * This method will get error message (if product is not available)
     * */
    public String getProductNotAvailableMessage(){
        CustomListeners.test.log(Status.PASS, "Error message (if product is not available)");
        Reporter.log("Error message (if product is not available)" + notAvailableMessage.toString());
        return getTextFromElement(notAvailableMessage).split("\n")[0];
    }
    /**
     * This method will get the text from check out page
     */
    public void getTextOfCheckOut(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "text from check out page");
        Reporter.log("text from check out page" + checkOutText.toString());
         verifyText(getTextFromElement(checkOutText),expected,msg);
    }
    /**
     * This method will get the new customer text
     */
    public String getNewCustomerText() {
        CustomListeners.test.log(Status.PASS, "new customer text");
        Reporter.log("new customer text" + newCustomer.toString());
        return getTextFromElement(newCustomer);
    }
    /**
     * This method will click onGuest radio button
     */
    public void clickOnGuestRadioButton() {
        CustomListeners.test.log(Status.PASS, "click onGuest radio button");
        Reporter.log("click onGuest radio button" + guestRadioButton.toString());
        clickOnElement(guestRadioButton);
    }
    /**
     * This method will click on continue button
     */
    public void clickOnContinue() {
        CustomListeners.test.log(Status.PASS, "click on continue button");
        Reporter.log("click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }
    /**
     * This method will enter name
     * */
    public void enterFirstName(String fName){
        CustomListeners.test.log(Status.PASS, "Enter name");
        Reporter.log("Enter name" + firstName.toString());
        sendTextToElement(firstName,fName);
    }
    /**
     * This method will enter last name
     * */
    public void enterLastName(String lName){
        CustomListeners.test.log(Status.PASS, "Enter last name");
        Reporter.log("Enter last name" + lastName.toString());
        sendTextToElement(lastName,lName);
    }

    /**
     * This method will enter email
     * */
    public void enterEmailAddress(String email){
        CustomListeners.test.log(Status.PASS, "Enter email");
        Reporter.log("Enter email" + emailAddress.toString());
        sendTextToElement(emailAddress,email);
    }

    /**
     * This method will enter telephone
     * */
    public void enterTelephone(String phone){
        CustomListeners.test.log(Status.PASS, "Enter telephone");
        Reporter.log("Enter telephone" + telephoneNumber.toString());
        sendTextToElement(telephoneNumber,phone);
    }

    /**
     * This method will enter address
     * */
    public void enterAddress(String add){
        CustomListeners.test.log(Status.PASS, "Enter address");
        Reporter.log("Enter address" + address.toString());
        sendTextToElement(address,add);
    }

    /**
     * This method will enter city
     * */
    public void enterCityName(String cty){
        CustomListeners.test.log(Status.PASS, "Enter city");
        Reporter.log("Enter city" + city.toString());
        sendTextToElement(city,cty);
    }

    /**
     * This method will enter Post code
     * */
    public void enterPostCode(String pCode){
        CustomListeners.test.log(Status.PASS, "Enter Post code");
        Reporter.log("Enter Post code" + postCode.toString());
        sendTextToElement(postCode,pCode);
    }

    /**
     * This method will select country
     * */
    public void selectCountry(String cnty){
        CustomListeners.test.log(Status.PASS, "select country");
        Reporter.log("select country" + country.toString());
        selectByVisibleTextFromDropDown(country,cnty);
    }
    /**
     * This method will select region
     * */
    public void selectRegion(String rgn){
        CustomListeners.test.log(Status.PASS, "select region");
        Reporter.log("select region" + region.toString());
        selectByVisibleTextFromDropDown(region,rgn);
    }
    /**
     *This method will click on continue button
     * */
    public void clickOnContinueButtonForGuest(){
        CustomListeners.test.log(Status.PASS, "click on continue button");
        Reporter.log("click on continue button" + continueButtonGuest.toString());
        clickOnElement(continueButtonGuest);
    }

    public void clickOnContinueButtonForDelivery(){
        CustomListeners.test.log(Status.PASS, "click On Continue Button For Delivery");
        Reporter.log("click On Continue Button For Delivery" + continueButtonDelivery.toString());
        clickOnElement(continueButtonDelivery);
    }
    /**
     * This method will enter data in text field
     * */
    public void enterCommentInTextBox(String message){
        CustomListeners.test.log(Status.PASS, "Enter data in text field");
        Reporter.log("Enter data in text field" + textBox.toString());
        sendTextToElement(textBox,message);
    }

    /**
     * This method will accept terms
     * */
    public void clickOnTerms(){
        CustomListeners.test.log(Status.PASS, "click On Terms");
        Reporter.log("click On Terms" + agree.toString());
        clickOnElement(agree);
    }

    public void clickOnContinueButtonForPayment(){
        CustomListeners.test.log(Status.PASS, "click On Continue Button For Payment");
        Reporter.log("click On Continue Button For Payment" + continueButtonPayment.toString());
        clickOnElement(continueButtonPayment);
    }

}
