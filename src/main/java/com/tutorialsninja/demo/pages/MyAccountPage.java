package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountText;

    /**
     * This method will get the myAccount text
     */
    public void getMyAccountText(String expected, String msg) {
        CustomListeners.test.log(Status.PASS, "get the myAccount text");
        Reporter.log("get the myAccount text" + myAccountText.toString());
        verifyText(getTextFromElement(myAccountText), expected, msg);
    }
}
