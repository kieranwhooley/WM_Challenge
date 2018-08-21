package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPageFactory {

    WebDriver driver;

    @FindBy(id = "email")
    WebElement resetPasswordEmailField;

    @FindBy(className = "mdl-button__ripple-container")
    WebElement resetPasswordButton;

    @FindBy(xpath = "//*[@id=\"reset-form\"]/div[2]/div/h4")
    WebElement resetPasswordTitle;

    public void clickResetPasswordButton() {
        resetPasswordButton.click();
    }

    public void submitNewPassword(String newPassword) {
        resetPasswordEmailField.sendKeys(newPassword);
    }

    public String getResetPasswordTitle() {
        return resetPasswordTitle.getText();
    }

    public ResetPasswordPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this   );
    }
}
