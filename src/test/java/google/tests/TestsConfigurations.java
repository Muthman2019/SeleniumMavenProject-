package google.tests;
import framework.engine.DriverFactory;
import framework.engine.JsonFileManager;
import framework.engine.PropertiesReader;
import google.pages.GoogleHomePage;
import google.pages.GoogleSearchResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
public class TestsConfigurations {
     WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        PropertiesReader.loadProperties();
        //testData = new JsonFileManager("src/test/resources/TestData_Google.json");
    }
    @BeforeMethod
    public void beforeMethod(){
        driver = DriverFactory.initDriver();
        /*driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));*/

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
