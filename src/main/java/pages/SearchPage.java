package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input [@class = 'qtyInput']")
    private WebElement quantityField;

    @FindBy(xpath = "//div [@class = 'u-cb err']")
    private WebElement incorrectQuantity;

    @FindBy(xpath = "//h3 [text()  = 'NEW Sony PlayStation 5 PS5 Console Disc Version ✅ IN HAND \uD83D\uDCE6 SHIPS FREE']")
    private WebElement namePlayStation;

    @FindBy(xpath = "MICROSOFT XBOX SERIES X ✅ BRAND NEW ✅ NEXT DAY DELIVERY \uD83D\uDE9A TRUSTED SELLER\uD83D\uDD25")
    private WebElement nameXBOX;


}
