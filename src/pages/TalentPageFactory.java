package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalentPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"wm-main-nav\"]/div/div[1]/div/div/div[2]/div[2]/a/div/div/div")
    WebElement findTalentLink;

    public void clickFindTalentLink() {
        findTalentLink.click();
    }

    public String getFindTalentLinkText() {
        return findTalentLink.getText();
    }

    public TalentPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this   );
    }
}
