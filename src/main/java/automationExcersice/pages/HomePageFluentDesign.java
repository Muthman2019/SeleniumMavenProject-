package automationExcersice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePageFluentDesign {
    private final WebDriver driver;
    public HomePageFluentDesign(WebDriver driver) {
        this.driver = driver;
    }
    String websiteURL = "https://automationexercise.com/";

    /////////////// Locators ///////////////
    private final By AutomationText_span = By.xpath("(//span)[1]");
    /////////////// Actions ///////////////
    public HomePageFluentDesign navigateToAutomationExerciseUrl(){
        driver.navigate().to(websiteURL);
        return this;
    }
    public HomePageFluentDesign assertThatTextContainAutomationWord(String ExpectedDataResult){
        String AutomationTextResult = driver.findElement(AutomationText_span).getText();
        Assert.assertTrue(AutomationTextResult.contains(ExpectedDataResult));
        return this;
    }
}
