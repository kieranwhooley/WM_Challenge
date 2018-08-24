package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    String webURL = "";
    String validLoginEmail = "";
    String validLoginPassword = "";
    String invalidEmail = "test@mail.com";


    @Test
    public void testLoginWithValidCredentialsIsSuccessful() {
        //Test to ensure login is successful with valid credentials
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword );
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        String findTalentText = talentPage.getFindTalentLinkText();
        Assert.assertEquals(findTalentText, "Find Talent");

    }

    @Test
    public void testLoginWithInvalidCredentialsDisplaysErrorMessage() {
        //Test to ensure error message is displayed when invalid login credentials are used
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(invalidEmail, validLoginPassword );
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage, "Invalid user name or password.");

    }

    @Test
    public void testForgotPasswordLinkOpensNewPage() {
        //Test to ensure the link to the Reset Your Password page from the Login page works
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickResetPasswordLink();
        ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory(driver);
        String resetPasswordPageText = resetPasswordPage.getResetPasswordTitle();
        Assert.assertEquals(resetPasswordPageText, "Reset Your Password");

    }

    @Test
    public void testThatCheckboxIsChecked() {
        //Test to make sure Remember Me checkbox is ticked when clicked
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickRememberMeCheckbox();
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//*[@id=\"page_form\"]/div[2]/label"));
        String checkedClass = rememberMeCheckbox.getAttribute("class");
        System.out.println(checkedClass);
        Assert.assertTrue(checkedClass.contains("is-checked"));
    }

    @Test
    public void testThatCheckboxIsUnchecked() {
        //Test to ensure Remember Me checkbox is unticked when clicked twice
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.clickRememberMeCheckbox();
        loginPage.clickRememberMeCheckbox();
        WebElement rememberMeCheckbox = driver.findElement(By.xpath("//*[@id=\"page_form\"]/div[2]/label"));
        String checkedClass = rememberMeCheckbox.getAttribute("class");
        System.out.println(checkedClass);
        Assert.assertTrue(!checkedClass.contains("is-checked"));

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
