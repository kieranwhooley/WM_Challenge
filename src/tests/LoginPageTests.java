package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageFactory;

public class LoginPageTests {

    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void testLogin() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login("qa+candidatetest@workmarket.com", "candidate123");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Initializing driver and opening browser");
        driver = utilities.DriverFactory.openBrowser("Chrome");
        driver.get("https://dev.workmarket.com/login");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Tests complete");
        driver.quit();
    }
}
