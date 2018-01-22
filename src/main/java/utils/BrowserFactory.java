package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by shweta on 21/01/2018.
 */
public class BrowserFactory {

     static WebDriver driver;
    public static void openBrowser()  {
        String url  = AutomationConstant.URL;
        String browser = AutomationConstant.BROWSER_TYPE;

        if (browser.matches("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/browser/geckodriver.exe");//open browser
            driver = new FirefoxDriver();
        } else if (browser.matches("chrome")) {
            try {
                System.setProperty("webdriver.chrome.driver", "src/main/browser/chromedriver.exe");//open browser
                driver = new ChromeDriver();
            } catch (Exception e) {
                System.out.println("FAILURE: Browser did not load: ");
            }

        } else if (browser.matches("safari")) {
            driver = new SafariDriver();
        }
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stopBrowser() {
        driver.quit();
    }


}
