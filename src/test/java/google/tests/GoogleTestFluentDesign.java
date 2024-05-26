package google.tests;

import framework.engine.JsonFileManager;
import google.pages.GoogleHomePage;
import google.pages.GoogleHomePageFluentDesign;
import google.pages.GoogleSearchResultPageFluentDesign;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTestFluentDesign extends TestsConfigurations {
JsonFileManager testData;
    @Test
    public void homePageScenario(){
        testData = new JsonFileManager("src/test/resources/TestData_Google.json");
    new GoogleHomePageFluentDesign(driver)
            .navigateToGoogleSearchHomePage("https://www.google.com/ncr")
            .googleSearch(testData.getTestData("googleSearchInput"));
    new GoogleSearchResultPageFluentDesign(driver)
            .assertOnPageTitle(testData.getTestData("googleSearchExpectedTitle"))
            .assertOnFirstSearchResult(testData.getTestData("googleSearchExpectedResults"));


    }
  /* @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }*/
//@BeforeClass
//    public void beforeClass(){
//    testData = new JsonFileManager("src/test/resources/TestData_Google.json");
//
//}

}
