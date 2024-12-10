package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksTest extends TestBase {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkOutPage = new CheckOutPage();
    }

    @Test(groups = {"sanity"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //get list of product price before doing any action in this page.
        List<String> productPriceBefore = laptopsAndNotebooksPage.getListOfProductPrice();
        Collections.sort(productPriceBefore, Collections.reverseOrder());
        System.out.println(productPriceBefore);

        //1.3 Select the Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //1.4 Verify the Product price will be arranged in High to Low orders.
        List<String> productPriceAfter = laptopsAndNotebooksPage.getListOfProductPrice();
        System.out.println(productPriceAfter);
        verifyText(productPriceAfter,productPriceBefore,"Price are not in High to low");
    }

    @Test(groups = {"smoke"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //change currency
        homePage.mouseHoverAndClickOnCurrency();
        homePage.mouseHoverAndClickOnPoundCurrency();

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortProductByPrice("Price (High > Low)");

        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.clickOnMacBook();

        //2.5 Verify the text “MacBook”
        productPage.getProductNameFromProductPage("MacBook", "MacBook text is not displayed");

        //2.6 Click on ‘Add To Cart’ button
        productPage.clickOnTheAddToCart();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        productPage.getShoppingCartMessage("Success: You have added MacBook to your shopping cart!", "Shopping Cart Message is not displayed");

        //2.8 Click on link “shopping cart” display into success message
        Thread.sleep(3000);
        productPage.clickOnTheShoppingCartLink();

        //2.9 Verify the text "Shopping Cart"
        shoppingCartPage.getProductName("Shopping Cart", "Shopping cart message is not displayed");

        //2.10 Verify the Product name "MacBook"
        //shoppingCartPage.getProductName("MacBook", "The product name macbook is not displayed");
        String actualMacBookName = shoppingCartPage.getProductNames();
        String expectedMacBookName = "MacBook";
        verifyText(actualMacBookName, expectedMacBookName, "The product name macbook is not displayed");

        //2.11 Change Quantity "2"
        shoppingCartPage.changeQtyOfProduct("2");

        //2.12 Click on “Update” Tab
        shoppingCartPage.clickOnUpdateButton();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        shoppingCartPage.getUpdatedCartMessage("Success: You have modified your shopping cart!", "Updated Shopping cart message is not displayed");

        //2.14 Verify the Total £737.45
        shoppingCartPage.getPrice("£737.45", "Price is not displayed");

        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOut();

        //System.out.println(checkOutPage.getProductNotAvailableMessage());
        if (checkOutPage.getProductNotAvailableMessage().equals("Products marked with *** are not available in the desired quantity or not in stock!")) {
            System.out.println(actualMacBookName + " is not available in the desired quantity or not in stock!.");
        } else {
            //2.16 Verify the text “Checkout”
            checkOutPage.getTextOfCheckOut("Checkout", "CheckOut text is not displayed");

            //2.17 Verify the Text “New Customer”
            String actualNewCustomerText = checkOutPage.getNewCustomerText();

            //2.18 Click on “Guest Checkout” radio button
            checkOutPage.clickOnGuestRadioButton();

            //2.19 Click on “Continue” tab
            checkOutPage.clickOnContinue();

            //2.20 Fill the mandatory fields
            checkOutPage.enterFirstName("Payal");
            checkOutPage.enterLastName("Patel");
            checkOutPage.enterEmailAddress("Ppatel12@gmail.com");
            checkOutPage.enterTelephone("2323232323");
            checkOutPage.enterAddress("232d Dream street");
            checkOutPage.enterCityName("London");
            checkOutPage.enterPostCode("HA5 0QQ");
            checkOutPage.selectCountry("United Kingdom");
            checkOutPage.selectRegion("Bedfordshire");

            //2.21 Click on “Continue” Button
            checkOutPage.clickOnContinueButtonForGuest();
            checkOutPage.clickOnContinueButtonForDelivery();

            checkOutPage.enterCommentInTextBox("This is comment");
            //2.23 Check the Terms & Conditions check box
            checkOutPage.clickOnTerms();
            //2.24 Click on the “Continue” button
            checkOutPage.clickOnContinueButtonForPayment();
            //2.25 Verify the message “Warning: Payment method required!”
        }
    }
}
