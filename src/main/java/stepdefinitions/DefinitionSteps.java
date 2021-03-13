package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    private final static String REMOVE_MASSAGE = "was removed from your cart.";
    private final static String LOWER_NUMBER = "Please enter a lower number";
    private final static String INPUT_MASSAGE = "Oops, that's not a match.";
    private final static String INCORRECT_INPUT = "asdfgsdfgxcvb";
    private final static String ZERO = "0";
    private final static String QUANTITY_XBOX = "1";
    private final static String QUANTITY_BICYCLES = "3";

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
        assertTrue(homePage.getCurrentUrl().contains(INCORRECT_INPUT));

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
        assertEquals(LOWER_NUMBER, searchPage.getQuantityField());

    }

    @And("Click to continue button without parameters")
    public void clickToContinueButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage.clickSignInButton();
        assertEquals(INPUT_MASSAGE, signInPage.getIncorrectInputMessage());
    }


    @And("CLick sing in")
    public void clickSingIn() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickSignInButtonOnHomePage();
    }

    @And("Click on name XBOX")
    public void clickOnName() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickNameXBOX();

    }

    @And("Click click add to cart")
    public void clickClickAddToCart() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage = pageFactoryManager.getCartPage();
        cartPage.clickAddToCartButton();
    }

    @And("Click go to checkout")
    public void clickGoToCheckout() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickCheckOutButton();
    }

    @And("Click continue like as guest")
    public void clickContinueLikeAsGuest() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getContinueAsGuestButton());
        cartPage.clickContinueAsGuestButton();
    }

    @And("Choose black")
    public void chooseBlack() {
        searchPage.clickSelectXBOX();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchPage.getSelectXBOXBlack());
        searchPage.clickSelectXBOXBlack();
        assertEquals(ZERO, searchPage.getSelectXBOXValue());
    }

    @And("Click remove")
    public void clickRemove() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        cartPage.clickRemoveButton();
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getRemoveMessageVisible());
        assertEquals(REMOVE_MASSAGE, cartPage.getRemoveMessage());
    }

    @And("User go to {string} on this page")
    public void userGoToGoogleOnThisPage(final String url) {
        homePage.openHomePage(url);
    }

    @And("User reopen {string}")
    public void userReopenHomePage(final String url) {
        homePage.openHomePage(url);
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("Check cart")
    public void checkCart() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCartCounterVisible());
        assertEquals(QUANTITY_XBOX, cartPage.getCartCounter());

    }

    @Then("Check cart counter")
    public void checkCartCounter() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, cartPage.getCartCounterVisible());
        assertEquals(QUANTITY_BICYCLES, cartPage.getCartCounter());

    }

    @And("Click on name bicycle")
    public void clickOnNameBicycle() {
        searchPage = pageFactoryManager.getSearchPage();
        searchPage.clickNameBicycle();
    }

    @And("Add correct value of {string}")
    public void addCorrectValueOfQuantity(final String quantity) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchPage.enterQuantity(quantity);
    }


    @After
    public void tearDown() {
        pageFactoryManager.tearDown();
    }
}
