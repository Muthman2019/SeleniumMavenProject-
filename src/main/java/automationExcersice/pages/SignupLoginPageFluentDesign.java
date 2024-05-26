package automationExcersice.pages;

import framework.engine.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupLoginPageFluentDesign {
    private final WebDriver driver;
    public SignupLoginPageFluentDesign(WebDriver driver) {
        this.driver = driver;
    }
    String SignupLoginUrl = "https://automationexercise.com/signup";


    ////////Locators////////
    private final By NewUserSignUpTitle_h2 = By.xpath("(//h2)[3]");
    private final By SignUpName_input = By.xpath("//input [@type='text']");
    private final By SignUpEmail_input =By.xpath("(//input [@type='email'])[2]");
    private final By SignUpBtn_button= By.xpath("//button [@data-qa ='signup-button']");

    //////// Actions ////////
    public SignupLoginPageFluentDesign navigateToSignupLoginPage(){
       driver.navigate().to(SignupLoginUrl);
       return this;
    }
    public SignupLoginPageFluentDesign submitSignUpInputs(String Username, String Email){
        driver.findElement(SignUpName_input).sendKeys(Username);
        driver.findElement(SignUpEmail_input).sendKeys(Email);
        return this;
    }
    public SignupLoginPageFluentDesign clickOnSignUpBtn (){
        //driver.findElement(SignUpBtn_button).click();
        ElementActions.click(driver,SignUpBtn_button);
        return this;
    }


    //////// Validations ////////
    public SignupLoginPageFluentDesign verifyThatNewUserSignUpIsVisible(String SignUpValidationText){
        String NewUserSignUpText =driver.findElement(NewUserSignUpTitle_h2).getText();
        Assert.assertEquals(NewUserSignUpText, SignUpValidationText);
        return this;
    }
}
