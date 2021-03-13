package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class HelpPage extends BasePage{
    public HelpPage(WebDriver driver) {
        super(driver);
    }


    //https://www.ebay.com/help/home

    //https://www.ebay.com/help/buying/returns-refunds/return-item-refund?id=4041&st=12&pos=1&query=Return%20an%20item%20for%20a%20refund&intent=refund%20an%20item

    //https://www.ebay.com/help/postage-tracking




    @FindBy(xpath = "//input [@placeholder = 'Search eBay Help...' ]")
    private WebElement searchField;

    @FindBy(xpath = "//span [@class = 'main_title' ] [text() =  'Return an item for a refund']")
    private WebElement refundHelpButton;

    @FindBy(xpath = "//span [@class = 't2']  [text() = 'Shipping & Tracking']")
    private WebElement trackingHelpButton;

    //a[text()='Shipping for Sellers']

    //div[text()='Setting up your shipping options']

    public void enterTextToSearchField(final String keyword) {
         searchField.clear();
         searchField.sendKeys(keyword,ENTER);
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

    public WebElement getTrackingHelpButton() {
        return trackingHelpButton;
    }


}
