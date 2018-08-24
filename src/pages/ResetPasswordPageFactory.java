package pages;

import com.gargoylesoftware.htmlunit.javascript.host.canvas.ext.WEBGL_compressed_texture_s3tc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPageFactory {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement resetPasswordEmailField;

    @FindBy(id = "reset-submit")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//*[@id=\"reset-form\"]/div[2]/div/h4")
    WebElement resetPasswordTitle;

    @FindBy(xpath = "//*[@id=\"reset-messages\"]/div/ul/li")
    WebElement resetEmailFormatErrorMessage;

    @FindBy(linkText = "Login")
    WebElement loginPageLink;

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void submitNewPassword(String newPassword) {
        resetPasswordEmailField.sendKeys(newPassword);
    }

    public String getEmailFormatErrorMessage() {
        return resetEmailFormatErrorMessage.getText();
    }

    public String getResetPasswordTitle() {
        return resetPasswordTitle.getText();
    }

    public void clickLoginPageLink() {
        loginPageLink.click();
    }

    public ResetPasswordPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this   );
    }
}
