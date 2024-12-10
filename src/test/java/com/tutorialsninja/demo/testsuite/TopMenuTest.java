package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends TestBase {

    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage=new HomePage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHoverAndClickOnDesktop();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        homePage.selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        homePage.verifyMenuTabText("Desktops","Desktop text not displayed");

    }

    @Test(groups = {"smoke"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {

        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mouseHoverAndClickOnLaptopAndNoteBook();

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        homePage.verifyMenuTabText("Laptops & Notebooks","Laptops & Notebooks not displayed");

    }

    @Test(groups = {"regression"})
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {

        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHoverAndClickOnComponents();

        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        homePage.verifyMenuTabText("Components","Components not displayed");
    }
}
