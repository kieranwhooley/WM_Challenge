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
    public void getListOfSearchResults() {
        LoginPageFactory loginPage = new LoginPageFactory(driver);
        loginPage.login(validLoginEmail, validLoginPassword);
        TalentPageFactory talentPage = new TalentPageFactory(driver);
        talentPage.clickFindTalentLink();
        talentPage.submitSearchItem(searchItem1);
        //int numberOfRecords = talentPage.getNumberOfSearchResults();
        //System.out.println("Number of records returned: " + numberOfRecords);
        List<WebElement> listOfSearchResults = driver.findElements(By.className("profile-card--details"));
        //int size = listOfSearchResults.size();
        //System.out.println(size);
        //String first = listOfSearchResults.get(0);
        //*[@id="search_results"]/div[1]/div[3]/h2/a
        //*[@id="search_results"]/div[2]/div[3]/h2/a
        for (int i = 1; i < talentPage.getNumberOfSearchResults(); i++) {
            //ADD A WAIT
            WebElement currentElement = driver.findElement(By.xpath("//*[@id=\"search_results\"]/div[" + i + "]/div[3]/h2/a"));
            String profileCardName = currentElement.getText();
            System.out.println("Item: " + i + " " + profileCardName);
            //Assert.assertTrue(profileCardName.toLowerCase().contains("test"));
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
