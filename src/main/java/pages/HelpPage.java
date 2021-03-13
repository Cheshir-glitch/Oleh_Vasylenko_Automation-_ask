package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HelpPage extends BasePage {
    public HelpPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input [@placeholder = 'Search eBay Help...' ]")
    private WebElement searchField;

    @FindBy(xpath = "//span [@class = 'main_title' ] [text() =  'Return an item for a refund']")
    private WebElement refundHelpButton;

    @FindBy(xpath = "//span [@class = 't2']  [text() = 'Shipping & Tracking']")
    private WebElement trackingHelpButton;


    @FindBy(xpath = "//a[text()='Shipping for Sellers']")
    private WebElement trackingHelpButtonForSellers;

    @FindBy(xpath = " //div[text()='Setting up your shipping options']")
    private WebElement shippingOptionsButton;


    public void clickTrackingHelpButtonForSellers() {
        trackingHelpButtonForSellers.click();
    }

    public void clickShippingOptionsButton() {
        shippingOptionsButton.click();
    }

    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword, ENTER);
    }

    public void clickRefundHelpButton() {
        refundHelpButton.click();
    }

    public void clickTrackingHelpButton() {
        trackingHelpButton.click();
    }

    public WebElement getRefundHelpButton() {
        return refundHelpButton;
    }


    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
