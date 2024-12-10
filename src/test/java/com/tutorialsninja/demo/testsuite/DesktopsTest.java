package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.ProductPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

import java.util.Collections;
import java.util.List;

public class DesktopsTest extends TestBase {

    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();

    }

    @Test(groups = {"sanity"})
    public void verifyProductArrangeInAlphaBaticalOrder() {

        //1.1 Mouse hover on Desktops Tab. and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 Click on “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //get all product name before doing any action in the desktop page
        List<String> productsNameBefore = desktopPage.getListOfProductsName();
        Collections.sort(productsNameBefore, Collections.reverseOrder());
        System.out.println(productsNameBefore);

        //1.3 Select Sort By position "Name: Z to A"
        desktopPage.selectSortByFilter("Name (Z - A)");

        //1.4 Verify the Product will be arranged in Descending order.
        List<String> productsNameAfter = desktopPage.getListOfProductsName();
        verifyText(productsNameAfter, productsNameBefore, "Product is not display in descending order");

    }

    @Test(groups = {"smoke"}, dataProvider = "productAddedToShoppingCartSuccessfully", dataProviderClass = TestData.class)
    public void verifyProductAddedToShoppingCartSuccessFully(String product, String qty,
                                                             String successMessage, String productName, String model, String total) throws InterruptedException {
        //2.1 Mouse hover on the Currency Dropdown and click
        homePage.mouseHoverAndClickOnCurrency();

        //2.2 Mouse hover on the £Pound Sterling and click
        homePage.mouseHoverAndClickOnPoundCurrency();

        //2.3 Mouse hover on the Desktops Tab.
        homePage.mouseHoverAndClickOnDesktop();

        //2.4 Click on the “Show AllDesktops”
        homePage.selectMenu("Show AllDesktops");

        //2.5 Select the Sort By position "Name: A to Z"
        desktopPage.selectSortByFilter("Name (A - Z)");

        //2.6 Select product “HP LP3065”
        if (product.equals("HP LP3065")) {
            desktopPage.clickOnHPLP3065Product();
        } else if (product.equals("iphone")) {
            desktopPage.clickOniPhoneProduct();
        } else {
            desktopPage.clickOnPalmTreoProProduct();
        }

        //2.7.Enter Qty "1” using Select class.
        productPage.productQty(qty);

        //2.8 Click on the “Add to Cart” button
        productPage.clickOnTheAddToCart();

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        productPage.getShoppingCartMessage(successMessage, "Shopping cart message is not displayed");

        //2.10 Click on the link “shopping cart” displayed in a success message
        productPage.clickOnTheShoppingCartLink();

        //2.11 Verify the text "Shopping Cart"
        shoppingCartPage.getShoppingCartText("Shopping Cart", "Shopping cart text is not displayed");

        //2.12 Verify the Product name "HP LP3065"
        shoppingCartPage.getProductName(productName, "Product name is not displayed");

        //2.13 Verify the Model "Product21"
        shoppingCartPage.getProductModel(model, "Product model is not displayed");

        //2.14 Verify the Total "£74.73"
        shoppingCartPage.getPrice(total, "Product model is not displayed");
    }

}
