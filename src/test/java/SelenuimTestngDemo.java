import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class SelenuimTestngDemo {

    WebDriver driver;
    String GoogleHomePageUrl = "https://www.google.com/ncr";
    @Test
    public void testSearch1() {
        driver.navigate().to(GoogleHomePageUrl);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Giza systems", Keys.ENTER);
        String firstSearchResultText = driver.findElement(By.xpath("(//h3)[1]")).getText();
        Assert.assertTrue(firstSearchResultText.contains("Giza"));
    }
    @Test
    public void testSearch2() {
        driver.navigate().to(GoogleHomePageUrl);
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium WebDriver", Keys.ENTER);
        String firstSearchResultText = driver.findElement(By.xpath("(//h3)[1]")).getText();
        Assert.assertTrue(firstSearchResultText.contains("Web"));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }




}
