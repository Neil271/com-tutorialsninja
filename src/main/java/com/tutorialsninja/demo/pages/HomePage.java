package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopMenu;

    @CacheLookup
    @FindBy(xpath = "//h2")
    WebElement menuTabText;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopAndNotebookMenu;

    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentMenu;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-link dropdown-toggle']")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(css = "button[name='GBP']")
    WebElement poundCurrency;


    /**
     * This method will click on selected Menu tab
     */
    public void selectMenu(String link) {
        clickOnElement(By.linkText(link));
    }

    /**
     * This method will do mouse hover and click on teh desktop menu
     */
    public void mouseHoverAndClickOnDesktop() {
        CustomListeners.test.log(Status.PASS, "do mouse hover and click on teh desktop menu");
        Reporter.log("do mouse hover and click on teh desktop menu" + desktopMenu.toString());
        mouseHoverToElementAndClick(desktopMenu);
    }

    /**
     * This method will get desktop text from desktop text
     */
    public void verifyMenuTabText(String expected, String msg) {
        CustomListeners.test.log(Status.PASS, "get desktop text from desktop text");
        Reporter.log("get desktop text from desktop text" + menuTabText.toString());
        verifyText(getTextFromElement(menuTabText), expected, msg);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnLaptopAndNoteBook() {
        CustomListeners.test.log(Status.PASS, "do mouse hover and click on teh LaptopAndNoteBook menu");
        Reporter.log("do mouse hover and click on teh LaptopAndNoteBook menu" + laptopAndNotebookMenu.toString());
        mouseHoverToElementAndClick(laptopAndNotebookMenu);
    }

    /**
     * This method will do mouse hover and click on teh LaptopAndNoteBook menu
     */
    public void mouseHoverAndClickOnComponents() {
        CustomListeners.test.log(Status.PASS, "do mouse hover and click on teh LaptopAndNoteBook menu");
        Reporter.log("do mouse hover and click on teh LaptopAndNoteBook menu" + componentMenu.toString());
        mouseHoverToElementAndClick(componentMenu);
    }

    /**
     * This method will do mouse hover and click on the Currency Tab
     */
    public void mouseHoverAndClickOnCurrency() {
        CustomListeners.test.log(Status.PASS, "do mouse hover and click on the Currency Tab");
        Reporter.log("do mouse hover and click on the Currency Tab" + currencyTab.toString());
        mouseHoverToElementAndClick(currencyTab);
    }

    /**
     * This method will do mouse hover and click on the pound currency
     */
    public void mouseHoverAndClickOnPoundCurrency() {
        CustomListeners.test.log(Status.PASS, "do mouse hover and click on the pound currency");
        Reporter.log("do mouse hover and click on the pound currency" + poundCurrency.toString());
        mouseHoverToElementAndClick(poundCurrency);
    }


}
