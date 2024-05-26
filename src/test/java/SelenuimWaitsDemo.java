import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SelenuimWaitsDemo {
    @Test
    public void testWaits(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading");
        //driver.findElement(By.xpath("//a[contains(@href,'1')]")).click();
        //or "Not Recommended selector-partial link text":
        driver.findElement(By.partialLinkText("Example 1")).click();
        driver.findElement(By.cssSelector("div #start > button")).click();
        //implicit wait (will fail because of element exists on DOM but hidden):
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Explicit wait (the correct wait strategy):
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div #finish > h4")));
        String HelloWorldText= driver.findElement(By.cssSelector("div #finish > h4")).getText();
        Assert.assertEquals(HelloWorldText,"Hello World!");
    }
}
