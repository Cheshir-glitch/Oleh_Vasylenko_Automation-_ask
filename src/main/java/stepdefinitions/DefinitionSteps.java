package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import pages.*;

import java.net.MalformedURLException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    HomePage homePage;
    SearchPage searchPage;
    HelpPage helpPage;
    SignInPage signInPage;
    CartPage cartPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() throws MalformedURLException {
        pageFactoryManager = new PageFactoryManager();
        pageFactoryManager.setUp();


    }


    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @Given("User opens sing {string} page")
    public void userOpensSingSignInPagePage(final String page) {
    signInPage = pageFactoryManager.getSignInPage();
    signInPage.openSingInPage(page);
    }

    @And("User click language button")
    public void clickLanguageSwitchButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickLanguageSwitchButton();
    }


    @And("User click Ireland button")
    public void clickLanguageIrelandButton() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getLanguageIrelandButton());
        homePage.clickLanguageIrelandButton();
    }

    @And("User checks that current url contains {string} language")
    public void clickLanguageIrelandButton(final String irelandPage) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertEquals(irelandPage, homePage.getCurrentUrl());
    }


    @And("User enter to search field {string} and click search")
    public void userEnterToSearchFieldKeywordAndClickSearch(final String keyword) {
        homePage.enterTextToSearchField(keyword);
        homePage.clickSearchButton();
    }


    @And("Wait for result")
    public void waitForResult() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.getCurrentUrl().contains("asdfgsdfgxcvb"));

    }

    @And("Click on name")
    public void clickOnNamePlayStation() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickNamePlayStation();

    }

    @And("Add incorrect value of {string}")
    public void addIncorrectValueOfQuantity(final String quantity) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.enterQuantity(quantity);
        assertEquals("Please enter a lower number", searchPage.getQuantityField());

    }

    @And("Click to continue button without parameters")
    public void clickToContinueButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickSignInButton();
        assertEquals("Oops, that's not a match.", signInPage.getIncorrectInputMessage());
    }


    @After
    public void tearDown() {
        pageFactoryManager.tearDown();
    }


    @And("CLick sing in")
    public void clickSingIn() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickSignInButtonOnHomePage();
    }
}
