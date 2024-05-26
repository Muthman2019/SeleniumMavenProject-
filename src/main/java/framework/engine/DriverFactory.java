package framework.engine;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {
    static WebDriver driver;
    public static WebDriver initDriver(String browserType, int implicitWait, boolean isMaximized, boolean headless){
      if (browserType.equalsIgnoreCase("chrome")){
            ChromeOptions chromeOptions = null;
            if (headless) {
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                driver = new ChromeDriver(chromeOptions);
            }else {
                driver = new ChromeDriver();
            }
      }  else if (browserType == "firefox") {
               FirefoxOptions ffoptions =null;
            if (headless){
                ffoptions = new FirefoxOptions();
                ffoptions.addArguments("-headless");
                driver = new FirefoxDriver(ffoptions);
            }else {
                driver =new FirefoxDriver();
            }
        } else if (browserType == "edge") {
            EdgeOptions edgeOptions = null;
            if (headless){
                edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--headless=new");
            }
            driver = new EdgeDriver(edgeOptions);
        } else {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        if (isMaximized){
            driver.manage().window().maximize();
        }
        return driver;
    }
    //overloading the method to be used as default option:
    public static WebDriver initDriver() {
        return initDriver(
                System.getProperty("browserType"),
                Integer.parseInt(System.getProperty("waits")),
                Boolean.valueOf(System.getProperty("maximizeWindow")),
                Boolean.valueOf(System.getProperty("headlessExecution"))
        );
    }
}
