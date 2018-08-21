package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public static WebDriver openBrowser(String browserType) {

        if (browserType.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "C:\\QA_Challenge\\Software\\IEDriverServer.exe");
            return new InternetExplorerDriver();
        } else if (browserType.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\QA_Challenge\\Software\\geckodriver.exe");
            return new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", "C:\\QA_Challenge\\Software\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
