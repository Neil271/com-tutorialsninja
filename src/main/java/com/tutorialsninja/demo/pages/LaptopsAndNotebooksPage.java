package com.tutorialsninja.demo.pages;

import com.aventstack.extentreports.Status;
import com.tutorialsninja.demo.customlisteners.CustomListeners;
import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement selectSort;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='MacBook']")
    WebElement macBookProduct;

    By listOfProductName = By.xpath("//div[@id='content']//div//div[1]//div[2]//div[1]//p[2]");

    /**
     * This method will sort the list of product
     */
    public void sortProductByPrice(String option) {
        CustomListeners.test.log(Status.PASS, "sort the list of product");
        Reporter.log("sort the list of product" + selectSort.toString());
        selectByVisibleTextFromDropDown(selectSort, option);
    }
    /**
     * This method will click on macBook product
     */
    public void clickOnMacBook() {
        CustomListeners.test.log(Status.PASS, "click on macBook product");
        Reporter.log("click on macBook product" + macBookProduct.toString());
        clickOnElement(macBookProduct);
    }
    /**
     * This method will get name of all products
     */
    public List<String> getListOfProductPrice() {
        CustomListeners.test.log(Status.PASS, "get name of all products");
        Reporter.log("get name of all products" + listOfProductName.toString());
        List<WebElement> priceList = findElements(listOfProductName);

        List<String> priceListBefore = new ArrayList<>();
        for (WebElement e : priceList) {
            String price = e.getText().split("\n")[0].replace("$", "").trim();
            priceListBefore.add(price);
        }
        return priceListBefore;
    }

}
