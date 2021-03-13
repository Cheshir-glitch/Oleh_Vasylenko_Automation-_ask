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

    //h1[@class='page-title']  Checkout


}
