package utilities;


import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utilities.ConfigReader.getProperty;
import static java.time.Duration.ofSeconds;

public class Driver {
    static WebDriver driver;
    static WebDriverWait wait;
    static Duration duration = ofSeconds(15);

    public static WebDriver getDriver() {

        ChromeOptions chromeOptions;

        if (driver == null) {

            switch (getProperty("browser")) {
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    chromeOptions.setImplicitWaitTimeout(duration);
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setImplicitWaitTimeout(duration);
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setImplicitWaitTimeout(duration);
                    driver = new FirefoxDriver(firefoxOptions);
                default:
                    chromeOptions = new ChromeOptions();
                    chromeOptions.setImplicitWaitTimeout(duration);
                    driver = new ChromeDriver(chromeOptions.addArguments("--headless=new"));
                    break;
            }
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(duration);
        }
        return driver;
    } //

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }//

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }//
}
