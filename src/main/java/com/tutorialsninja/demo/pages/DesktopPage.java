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

public class DesktopPage extends Utility {

   /* @CacheLookup
    @FindBy(xpath = "//div[@id='content']//div//div[1]//div[2]//div[1]//h4" )
    WebElement productNames;*/

    By productNames=By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//h4");

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement selectFilter;

    @CacheLookup
    @FindBy(linkText = "HP LP3065")
    WebElement hpDesktop;

    @CacheLookup
    @FindBy(linkText = "iPhone")
    WebElement iPhone;

    @CacheLookup
    @FindBy(linkText = "Palm Treo Pro")
    WebElement palmTreoPro;

    /**
     * This method will return list of product names
     */
    public List<String> getListOfProductsName() {
        CustomListeners.test.log(Status.PASS, "list of product names");
        Reporter.log("list of product names" + productNames.toString());
        return getListOfTextFromElement(productNames);
    }
    /**
     * This Method will sort the data in selected filter
     */
    public void selectSortByFilter(String option) {
        CustomListeners.test.log(Status.PASS, "sort the data in selected filter");
        Reporter.log("sort the data in selected filter" + selectFilter.toString());
        selectByVisibleTextFromDropDown(selectFilter, option);
    }
    /**
     * This method will click on the HP LP3065
     * */
    public void clickOnHPLP3065Product(){
        CustomListeners.test.log(Status.PASS, "click on the HP LP3065");
        Reporter.log("click on the HP LP3065" + hpDesktop.toString());
        clickOnElement(hpDesktop);
    }
    /**
     * This method will click on the iPhone
     * */
    public void clickOniPhoneProduct(){
        CustomListeners.test.log(Status.PASS, "click on the iPhone");
        Reporter.log("click on the iPhone" + iPhone.toString());
        clickOnElement(iPhone);
    }
    /**
     * This method will click on the iPhone
     * */
    public void clickOnPalmTreoProProduct(){
        CustomListeners.test.log(Status.PASS, "click on the iPhone");
        Reporter.log("click on the iPhone" + palmTreoPro.toString());
        clickOnElement(palmTreoPro);
    }



}
