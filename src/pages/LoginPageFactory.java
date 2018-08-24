package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {

    WebDriver driver;

    @FindBy (id = "login-email")
    WebElement loginEmailField;

    @FindBy (id = "login-password")
    WebElement loginPasswordField;

    @FindBy (id = "login_page_button")
    WebElement loginButton;

    @FindBy (xpath = "//*[@id=\"page_form\"]/div[2]/label/span[4]")
    WebElement rememberMeCheckbox;

    @FindBy (id = "reset-password")
    WebElement resetPasswordLink;

    @FindBy (xpath = "//*[@id=\"outer-container\"]/div/a/img")
    WebElement linkToWorkMarketHomepage;

    @FindBy (className = "alert-error")
    WebElement errorMessage;

    public void enterEmail(String email) {
        loginEmailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        loginPasswordField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickRememberMeCheckbox() {
        rememberMeCheckbox.click();
    }

    public void clickResetPasswordLink() {
        resetPasswordLink.click();
    }

    public void clickLinkToWorkMarketHomepage() {
        linkToWorkMarketHomepage.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this   );
    }
}
