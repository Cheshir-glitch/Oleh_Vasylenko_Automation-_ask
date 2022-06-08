package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

public class SignInPage extends BasePage {


    public SignInPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//li [@class = 'gh-t ']  //a[text()  = 'Sign in']")
    private WebElement signInButtonOnHomePage;

    @FindBy(xpath = "//button [@name  = 'signin-continue-btn']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[ @name = 'userid']")
    private WebElement emailField;

    @FindBy(xpath = "//input[ @name = 'pass']")
    private WebElement passswordField;

    @FindBy(xpath = "//p [ @id= 'signin-error-msg']")
    private WebElement incorrectInputMessage;


    public void clickSignInButtonOnHomePage() {
        signInButtonOnHomePage.click();
    }

    public WebElement getSignInButtonOnHomePage() {
        return signInButtonOnHomePage;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void enterToEmailField(final String email) {
        emailField.clear();
        emailField.sendKeys(email, ENTER);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public void enterToPassswordField(final String password) {
        passswordField.clear();
        passswordField.sendKeys(password, ENTER);
    }

    public WebElement getPassswordField() {
        return passswordField;
    }

    public String getIncorrectInputMessage() {
        return incorrectInputMessage.getText();
    }


    public void openSingInPage(final String page) {
        driver.get(page);
    }
}
