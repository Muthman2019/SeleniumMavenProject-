package automationExcersice.tests;

import automationExcersice.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;


    @Test
    public void navigateToHomePage(){
    homePage.navigateToAutomationExerciseUrl();
    homePage.assertThatTextContainAutomationWord("Automation");
}
@BeforeMethod
public void beforeMethod() {
    driver = new ChromeDriver();
    homePage = new HomePage(driver);
    driver.manage().window().maximize();

    }
@AfterMethod
public void afterTest(){
        driver.quit();
}
}
