package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import pages.ResetPasswordPageFactory;
import pages.TalentPageFactory;

public class LoginPageTests {

    WebDriver driver;
    //WebDriverWait wait;
    String webURL = "https://dev.workmarket.com/login";
    String validLoginEmail = "";
    String validLoginPassword = "";
    String invalidEmail = "test@mail.com";

    @Test
    public void testLoginWithValidCredentialsIsSuccessful() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword );
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        String findTalentText = talentPage.getFindTalentLinkText();
        Assert.assertEquals(findTalentText, "Find Talent");

    }

    @Test
    public void testLoginWithInvalidCredentialsDisplaysErrorMessage() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(invalidEmail, validLoginPassword );
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid user name or password.");

    }

    @Test
    public void testForgotPasswordLinkOpensNewPage() {
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickResetPasswordLink();
        ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory(driver);
        String resetPasswordPageText = resetPasswordPage.getResetPasswordTitle();
        Assert.assertEquals(resetPasswordPageText, "Reset Your Password");

    }

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
