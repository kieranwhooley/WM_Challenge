package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalentPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wm-main-nav\"]/div/div[1]/div/div/div[2]/div[2]/a/div/div/div")
    WebElement findTalentLink;

    @FindBy(id ="input-text")
    WebElement searchInputField;

    public void clickFindTalentLink() {
        findTalentLink.click();
    }

    public String getFindTalentLinkText() {
        return findTalentLink.getText();
    }

    public int getNumberOfSearchResults() {
        List<WebElement> listOfSearchResults = driver.findElements(By.className("profile-card--details"));
        return listOfSearchResults.size();
    }

    public void submitSearchItem(String itemToSearchFor) {
        searchInputField.sendKeys(itemToSearchFor);
        searchInputField.sendKeys(Keys.RETURN);
    }

    public TalentPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this   );
    }

}
