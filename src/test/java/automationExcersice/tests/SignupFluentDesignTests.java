package automationExcersice.tests;

import automationExcersice.pages.SignupLoginPage;
import automationExcersice.pages.SignupLoginPageFluentDesign;
import framework.engine.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.UUID;

public class SignupFluentDesignTests {
    private WebDriver driver;

@Test
public void signUpUsingValidCredentials(){
    new SignupLoginPageFluentDesign(driver).navigateToSignupLoginPage()
    .verifyThatNewUserSignUpIsVisible("New User Signup!")
    .submitSignUpInputs(
            String.valueOf(UUID.randomUUID()),
            UUID.randomUUID()+"@giza.com")
    .clickOnSignUpBtn();

}
@BeforeMethod
public void beforeMethod(){
   driver = DriverFactory.initDriver();
}
@AfterMethod
public void afterMethod(){
driver.quit();
}
}
