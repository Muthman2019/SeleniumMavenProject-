package google.tests;

import google.pages.GoogleHomePage;
import google.pages.GoogleSearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

////Here we will refactor the class in a linear way ////
public class SelenuimTestngDemoPOM {
    private WebDriver driver;
    private GoogleHomePage googleHomePage;
    private GoogleSearchResultPage googleSearchResultPage;
    //////////////////// Element Locator//////////////////

    @Test
    public void testSearch1() {
        googleHomePage.googleSearch("Giza Systems");
        googleSearchResultPage.assertOnFirstSearchResult("Giza");
    }
    @Test
    public void testSearch2() {
        googleHomePage.googleSearch("Selenium WebDriver");
        googleSearchResultPage.assertOnFirstSearchResult("Web");

    }
    //////////////////// Configurations //////////////////
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        googleHomePage = new GoogleHomePage(driver);
        googleSearchResultPage = new GoogleSearchResultPage(driver);
        driver.manage().window().maximize();
        googleHomePage.navigateToGoogleSearchHomepage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }


}
