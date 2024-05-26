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
public class SelenuimTestngDemoLinearDesign {
    private WebDriver driver;
    //////////////////// Element Locator//////////////////
    //Locator variable name convention : meaningfulName_tagName
    private final By googleSearch_textarea = By.xpath("//textarea[@name='q']");
    private final By firstSearchResultText_h3 = (By.xpath("(//h3)[1]"));
    String googleHomepageUrl = "https://www.google.com/ncr";

    @Test
    public void testSearch1() {
        googleSearch("Giza Systems");
        assertOnFirstSearchResult("Giza");
    }
    @Test
    public void testSearch2() {
        googleSearch("Selenium WebDriver");
        assertOnFirstSearchResult("Web");

    }
    //////////////////// Configurations //////////////////
    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        navigateToGoogleSearchHomepage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    //////////////////// Actions // Business steps //////////////////
    public void googleSearch(String searchData){
        driver.findElement(googleSearch_textarea).sendKeys(searchData, Keys.ENTER);
    }
    public void assertOnFirstSearchResult(String expectedResult){
        String firstSearchResultText = driver.findElement(firstSearchResultText_h3).getText();
        Assert.assertTrue(firstSearchResultText.contains(expectedResult));
    }

    public void navigateToGoogleSearchHomepage(){
        driver.navigate().to(googleHomepageUrl);
    }
}
