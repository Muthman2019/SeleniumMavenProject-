package automationExcersice.tests;

import automationExcersice.pages.HomePage;
import automationExcersice.pages.HomePageFluentDesign;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageFluentDesignTests {
    private WebDriver driver;


    @Test
    public void navigateToHomePage(){
    new HomePageFluentDesign(driver).navigateToAutomationExerciseUrl()
    .assertThatTextContainAutomationWord("Automation");
}
@BeforeMethod
public void beforeMethod() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();

    }
@AfterMethod
public void afterTest(){
        driver.quit();
}
}
