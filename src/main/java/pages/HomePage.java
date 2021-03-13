package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//header")
    private WebElement header;

    @FindBy(xpath = "//footer")
    private WebElement footer;


    @FindBy(xpath = "//a [@class='gf-if-a']//p [text() = 'Ireland' ]")
    private WebElement languageIrelandButton;

    @FindBy(xpath = "//a [@aria-controls='gf-f']")
    private WebElement languageSwitchButton;

    @FindBy(xpath = "//input [@class='gh-tb ui-autocomplete-input']")
    private WebElement searchField;

    @FindBy(xpath = "//input [@class='btn btn-prim gh-spr']")
    private WebElement searchButton;

    @FindBy(xpath = "//li[@class='gh-eb-li rt']")
    private WebElement cartButton;


    public void enterTextToSearchField(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickLanguageSwitchButton() {
        languageSwitchButton.click();
    }

    public void clickLanguageIrelandButton() {
        languageIrelandButton.click();

    }

    public WebElement getLanguageIrelandButton() {
        return languageIrelandButton;
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


}
