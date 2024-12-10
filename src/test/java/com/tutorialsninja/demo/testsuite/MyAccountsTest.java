package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.*;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsTest extends TestBase {
    HomePage homePage;
    DesktopPage desktopPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    CommonElementPage commonElementPage;
    RegisterPage registerPage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        desktopPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        commonElementPage = new CommonElementPage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on the My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //1.2 Call the method “selectMyAccountOptions()” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //1.3 Verify the text “Register Account”.
        registerPage.getRegisterText("Register Account", "Register Account text is not displayed");

    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Login”
        //2.3 Verify the text “Returning Customer”.
    }

    @Test(groups = {"regression"})
    public void verifyThatUserRegisterAccountSuccessfully() {

        //3.1 Click on My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        commonElementPage.selectMyAccountOption("Register");

        //3.3 Enter First Name
        registerPage.enterFirstName("Payal");

        registerPage.enterLastName("Patel");

        //3.5 Enter the Email
        registerPage.enterEmail("payal6789@gmail.com");

        //3.6 Enter the Telephone
        registerPage.enterTelephone("232323223");

        //3.7 Enter the Password
        registerPage.enterPassword("Payal@123");

        //3.8 Enter the Password Confirm
        registerPage.enterConfirmPassword("Payal@123");

        //3.9 Select Subscribe Yes radio button
        registerPage.clickOnTheYesRadioButton();

        //3.10 Click on the Privacy Policy check box
        registerPage.clickOnThePrivacyCheckbox();

        //3.11 Click on the Continue button
        registerPage.clickOnContinueButton();

        //3.12 Verify the message “Your Account Has Been Created!”
        registerPage.getRegisterSuccessfulText("Your Account Has Been Created!", "The message your account has been created is not displayed");

        //3.13 Click on Continue button
        registerPage.clickOnContinueButtonAfterSuccessfulAccountCreated();

        commonElementPage.clickOnMyAccountLink();

        //3.15 Call the method “selectMyAccountOptions()” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //3.16 Verify the text “Account Logout”
        commonElementPage.getLogoutText("Account Logout", "The logout message is not displayed");

        //3.17 Click on Continue button
        commonElementPage.clickOnContinueButton();
    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        commonElementPage.selectMyAccountOption("Login");

        //4.3 Enter Email address
        loginPage.enterEmail("payal6789@gmail.com");

        //4.4 Enter Last Name

        //4.5 Enter Password
        loginPage.enterPassword("Payal@123");

        //4.6 Click on Login button
        loginPage.clickOnLoginButton();

        //4.7 Verify text “My Account”
        myAccountPage.getMyAccountText("My Account","My account text is not displayed");

        //4.8 Click on My Account Link.
        commonElementPage.clickOnMyAccountLink();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //4.10 Verify the text “Account Logout”
        commonElementPage.selectMyAccountOption("Logout");

        //4.11 Click on Continue button
        commonElementPage.clickOnContinueButton();
    }
}
