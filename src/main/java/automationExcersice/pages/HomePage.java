package automationExcersice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {
    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    String websiteURL = "https://automationexercise.com/";

    /////////////// Locators ///////////////
    private final By AutomationText_span = By.xpath("(//span)[1]");
    /////////////// Actions ///////////////
    public void navigateToAutomationExerciseUrl(){
        driver.navigate().to(websiteURL);
    }
    public void assertThatTextContainAutomationWord(String ExpectedDataResult){
        String AutomationTextResult = driver.findElement(AutomationText_span).getText();
        Assert.assertTrue(AutomationTextResult.contains(ExpectedDataResult));
    }
}
