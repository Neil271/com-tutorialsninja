package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class CommonElementPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Account Logout']")
    WebElement logoutMessageElement;

    @CacheLookup
    @FindBy(linkText = "Continue")
    WebElement continueButton;

   /* @CacheLookup
    @FindBy(xpath = "//li[@class='dropdown open']//li/a")
    WebElement selectMyAccountOption;
*/
   By selectMyAccountOption = By.xpath("//li[@class='dropdown open']//li/a");

    /**
     * This method will click on my account link.
     */
    public void clickOnMyAccountLink() {
        CustomListeners.test.log(Status.PASS, "click on my account link");
        Reporter.log("click on my account link" + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }
    /**
     * This method will click on continue button
     */
    public void clickOnContinueButton() {
        CustomListeners.test.log(Status.PASS, "click on continue button");
        Reporter.log("click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }
    /**
     * This method will get the logout message
     */
    public void getLogoutText(String expected,String msg) {
        CustomListeners.test.log(Status.PASS, "get the logout message");
        Reporter.log("get the logout message" + logoutMessageElement.toString());
        verifyText(getTextFromElement(logoutMessageElement),expected,msg);
    }

    /**
     * This method will select option from my account link
     */
    public void selectMyAccountOption(String option) {
        CustomListeners.test.log(Status.PASS, "select option from my account link");
        Reporter.log("select option from my account link" + selectMyAccountOption.toString());
        List<WebElement> options = findElements(selectMyAccountOption);
        for (WebElement e : options) {
            if (e.getText().equalsIgnoreCase(option)) {
                e.click();
                break;
            }
        }
    }
}
