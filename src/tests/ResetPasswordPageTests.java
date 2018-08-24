package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import pages.ResetPasswordPageFactory;

public class ResetPasswordPageTests {

    WebDriver driver;
    String webURL = "";
    String validLoginEmail = "";
    String validLoginPassword = "";
    String invalidEmail = "test@mail.com";
    String newPassword = "";

    @Test
    public void testEmailFormatErrorMessage() {
        //Test to ensure error message is displayed when invalid email format is entered for new email address
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickResetPasswordLink();
        ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory(driver);
        resetPasswordPage.clickResetPasswordButton();
        String errorMessage = resetPasswordPage.getEmailFormatErrorMessage();
        Assert.assertEquals(errorMessage, "Email does not match the required format.");

    }

    @Test
    public void testLinkToLoginPage() {
        //Test to ensure the link to the Login page from the Reset Password page works
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickResetPasswordLink();
        ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory(driver);
        resetPasswordPage.clickLoginPageLink();
        String loginButtonText = loginPage.getLoginButtonText();
        Assert.assertEquals(loginButtonText, "LOGIN");

    }

   /*@Test
    public void testPasswordResetWithValidEmail() {
        //Test to submit a new password (I did not run this to avoid accidentally updated the email used)
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickResetPasswordLink();
        ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory(driver);
        resetPasswordPage.submitNewPassword(newPassword);
        resetPasswordPage.clickResetPasswordButton();
    }*/

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing driver and opening browser");
        driver = utilities.DriverFactory.openBrowser("Chrome");
        driver.get(webURL);
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests complete");
        driver.quit();
    }
}
