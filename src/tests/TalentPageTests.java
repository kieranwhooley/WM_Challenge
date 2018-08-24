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
import pages.TalentPageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TalentPageTests {

    WebDriver driver;
    String webURL = ""; //Enter URL for site to be tested here
    String validLoginEmail = ""; //Enter valid email address to login here
    String validLoginPassword = ""; //Enter valid password to login here
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
    public void testSearchResultsContainSearchTerm() {
        boolean searchTermPresent;
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword);
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        talentPage.clickFindTalentLink();
        talentPage.submitSearchItem(searchItem1);
        //int numberOfRecords = talentPage.getNumberOfSearchResults();
        //System.out.println("Number of records returned: " + numberOfRecords);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //List<WebElement> listOfSearchResults = driver.findElements(By.className("profile-card--details"));
        //int size = listOfSearchResults.size();
        //System.out.println(size);
        for (int i = 1; i <= talentPage.getNumberOfSearchResults(); i++) {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebElement currentElement = driver.findElement(By.xpath("//*[@id=\"search_results\"]/div[" + i + "]/div[3]/h2/a"));
            String profileCardName = currentElement.getText();
            //System.out.println("Item: " + i + " " + profileCardName);
            if (profileCardName.toLowerCase().contains("test")){
                searchTermPresent = true;
                Assert.assertTrue(searchTermPresent);
            } else {
                System.out.println("Item number " + i + " does not contain " + "\"" + searchItem1 + "\" in Profile title" );
            }
        }
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
