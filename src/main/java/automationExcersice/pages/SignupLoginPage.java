package automationExcersice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupLoginPage {
    private final WebDriver driver;
    public SignupLoginPage(WebDriver driver) {
        this.driver = driver;
    }
    String SignupLoginUrl = "https://automationexercise.com/signup";


    ////////Locators////////
    private final By NewUserSignUpTitle_h2 = By.xpath("(//h2)[3]");
    private final By SignUpName_input = By.xpath("//input [@type='text']");
    private final By SignUpEmail_input =By.xpath("(//input [@type='email'])[2]");
    private final By SignUpBtn_button= By.xpath("//button [@data-qa ='signup-button']");

    //////// Actions ////////
    public void navigateToSignupLoginPage(){
       driver.navigate().to(SignupLoginUrl);
    }
    public void submitSignUpInputs(String Username, String Email){
        driver.findElement(SignUpName_input).sendKeys(Username);
        driver.findElement(SignUpEmail_input).sendKeys(Email);
    }
    public void clickOnSignUpBtn (){
        driver.findElement(SignUpBtn_button).click();
    }


    //////// Validations ////////
    public void verifyThatNewUserSignUpIsVisible(){
        String NewUserSignUpText =driver.findElement(NewUserSignUpTitle_h2).getText();
        Assert.assertEquals(NewUserSignUpText, "New User Signup!");
    }
}
