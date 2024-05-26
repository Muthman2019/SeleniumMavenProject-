package automationExcersice.tests;

import automationExcersice.pages.HomePage;
import automationExcersice.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignupTests {
    private WebDriver driver;
    private SignupLoginPage signupLoginPage;

@Test
public void signUpUsingValidCredentials(){
    signupLoginPage.navigateToSignupLoginPage();
    signupLoginPage.verifyThatNewUserSignUpIsVisible();
    signupLoginPage.submitSignUpInputs(
            "8812d059-1aea-4Xb0-a925-c4514c48c710",
            "8812d059-1aea-4Xb0-a925-c4514c48c710@giza.com");
    signupLoginPage.clickOnSignUpBtn();

}
@BeforeMethod
public void setUp(){
    driver= new ChromeDriver();
    signupLoginPage = new SignupLoginPage(driver);
    driver.manage().window().maximize();
}
@AfterMethod
public void tearDown(){
driver.quit();
}
}
