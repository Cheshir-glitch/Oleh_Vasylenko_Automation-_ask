package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import pages.HomePage;

import java.net.MalformedURLException;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    private static final long DEFAULT_TIMEOUT = 60;

    HomePage homePage;
    PageFactoryManager pageFactoryManager;

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
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


    @Before
    public void testsSetUp() throws MalformedURLException {
        pageFactoryManager = new PageFactoryManager();
        pageFactoryManager.setUp();
    }

    @After
    public void tearDown() {
        pageFactoryManager.tearDown();
    }

    @And("Wait for result")
    public void waitForResult() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.getCurrentUrl().contains("asdfgsdfgxcvb"));

    }
}
