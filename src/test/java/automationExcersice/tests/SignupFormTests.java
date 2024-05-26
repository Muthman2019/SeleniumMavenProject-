package automationExcersice.tests;

import automationExcersice.pages.SignupFormPage;
import automationExcersice.pages.SignupLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static java.util.UUID.randomUUID;

public class SignupFormTests {
    private SignupLoginPage signupLoginPage;
    private SignupFormPage signupFormPage;
    private WebDriver driver;

@Test
public void createAccountAfterSignup(){
    signupLoginPage.navigateToSignupLoginPage();
    signupLoginPage.submitSignUpInputs(String.valueOf(randomUUID())
    ,randomUUID()+"@mola.com");
    signupLoginPage.clickOnSignUpBtn();
    signupFormPage.verifyThatEnterAccountInfoIsVisible();
    signupFormPage.fillAccountPassword("!Qaz@Wsx#Edc");
    signupFormPage.selectDateOfBirt();
    signupFormPage.selectCheckboxOfNewsletter();
    signupFormPage.selectCheckboxOfOffers();
    signupFormPage.fillCreateAccountDetails("folla",
            "yasmine","dsfd","asas",
            "doda","234","3234567");
    signupFormPage.clickCreateAccountBtn();
    signupFormPage.verifyThatAccountCreatedTextIsVisible();
    }
@BeforeMethod
public void beforeMethod(){
    driver = new ChromeDriver();
    signupLoginPage = new SignupLoginPage(driver);
    signupFormPage = new SignupFormPage(driver);
    driver.manage().window().maximize();
}
@AfterMethod
    public void afterMethod(){
    driver.quit();
}




}

