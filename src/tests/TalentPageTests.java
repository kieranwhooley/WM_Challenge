package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import pages.TalentPageFactory;

public class TalentPageTests {

    WebDriver driver;
    String webURL = "";
    String validLoginEmail = "";
    String validLoginPassword = "";
    String searchItem1 = "test";

    @Test
    public void testFindTalentSearch() {
        //Test to ensure that Talent search works and the search term used is displayed as a keyword
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword);
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        talentPage.clickFindTalentLink();
        talentPage.submitSearchItem(searchItem1);
        WebElement keywordUsed = driver.findElement(By.xpath("//*[@id=\"outer-container\"]/div/div[2]/div[4]/div/div/div[1]/div[2]/div/div[1]/div"));
        String keywordUsedText = keywordUsed.getAttribute("data-value");
        Assert.assertEquals(keywordUsedText, "Keyword: test");
    }

    @Test
    public void testNumberOfSearchResults() {
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword);
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        talentPage.clickFindTalentLink();
        talentPage.submitSearchItem(searchItem1);
        int numberOfRecords = talentPage.getNumberOfSearchResults();
        System.out.println("Number of records returned: " + numberOfRecords);
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
