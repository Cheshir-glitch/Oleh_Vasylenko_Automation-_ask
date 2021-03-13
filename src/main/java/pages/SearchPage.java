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
    private WebElement quantityIncorrect;

    @FindBy(xpath = "//h3 [text()  = 'NEW Sony PlayStation 5 PS5 Console Disc Version ✅ IN HAND \uD83D\uDCE6 SHIPS FREE']")
    private WebElement namePlayStation;

    @FindBy(xpath = "//h3 [text() = 'BRAND NEW SEALED Microsoft Xbox Series X and S FREE 2 day Shipping']")
    private WebElement nameXBOX;


    @FindBy(xpath = "//h3 [text() = 'Mountain Bike/Bicycle NEW SPEED® Men/Women Fat Tire 26\"MTB Frame Full Suspension']")
    private WebElement nameBicycle;


    @FindBy(xpath = "//select [@class='msku-sel ']")
    private WebElement selectXBOX;

    @FindBy(xpath = "//option [text()='Series X Black']")
    private WebElement selectXBOXBlack;

    public void clickNameBicycle() {
        nameBicycle.click();
    }

    public void clickSelectXBOX() {
        selectXBOX.click();
    }


    public String getSelectXBOXValue() {
        return selectXBOX.getAttribute("selectedindex");
    }

    public void clickSelectXBOXBlack() {
        selectXBOXBlack.click();
    }

    public WebElement getSelectXBOXBlack() {
        return selectXBOXBlack;
    }


    public String getQuantityField() {

        return quantityIncorrect.getText();
    }

    public void enterQuantity(final String quantity) {
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void clickNamePlayStation() {
        namePlayStation.click();
    }

    public void clickNameXBOX() {
        nameXBOX.click();
    }

    public WebElement getNamePlayStation() {
        return namePlayStation;
    }

    public WebElement getNameXBOX() {
        return nameXBOX;
    }

}
