package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[@class='faux-link']  [@data-test-id='cart-remove-item']")
    private WebElement removeButton;

    @FindBy(xpath = "//button[@class='call-to-action btn btn--large btn--primary']  ")
    private WebElement checkOutButton;

    @FindBy(xpath = "//button[@class='btn btn--secondary btn--large btn--fluid']  ")
    private WebElement continueAsGuestButton;

    @FindBy(xpath = "//a [@role ='button'] [@id='isCartBtn_btn']")
    private WebElement addToCart;



    @FindBy(xpath = "//span [text() = ' was removed from your cart.']")
    private WebElement removeMessage;



    @FindBy(xpath = "//i[@id = 'gh-cart-n'] ")
    private WebElement cartCounter;



    public WebElement getCartCounterVisible() {
        return cartCounter;
    }

    public String getCartCounter() {
        return cartCounter.getText();
    }

//a [@role ='button'] [@id='isCartBtn_btn']

    //h1[@class='page-title']  Checkout

    public String getRemoveMessage() {
        return removeMessage.getText();
    }

    public WebElement getRemoveMessageVisible() {
        return removeMessage;
    }

    public void clickAddToCartButton() {
        addToCart.click();
    }

    public WebElement getContinueAsGuestButton() {
        return continueAsGuestButton;
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void clickCheckOutButton() {
        checkOutButton.click();
    }

    public void clickContinueAsGuestButton() {
        continueAsGuestButton.click();
    }

}
