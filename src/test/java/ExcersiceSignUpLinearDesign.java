import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcersiceSignUpLinearDesign {
    private WebDriver driver;
@Test
    public void homePage(){
    navigateToAutomationExerciseUrl("https://automationexercise.com/");
    assertThatTextContainAutomationWord("Automation");
    }
@Test(dependsOnMethods = "homePage")
    public void registerPage(){
    //4. Click on 'Signup / Login' button
    clickOnSignUpButtonFromHomePage ();
    //5. Verify 'New User Signup!' is visible
    verifyThatNewUserSignUpIsVisible();
}
@Test(dependsOnMethods = "registerPage")
    public void submitRegisterNameAndEmail(){
//6. Enter name and email address
    submitSignUpInputs("61b8794a-6666-4e4a-b9df-c1e7bb48e2df","61b8794a-7777-4e4a-b9df-c1e7bb48e2df@giza3.com");
//7. Click 'Signup' button
    clickOnSignUpBtn();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    verifyThatEnterAccountInfoIsVisible("ENTER");
}
@Test(dependsOnMethods = "submitRegisterNameAndEmail")
public void createAccount(){
    fillAccountPassword("456");
    selectDateOfBirt();
    selectCheckboxOfNewsletter();
    selectCheckboxOfOffers();
    fillCreateAccountDetails("first Name", "last Name","Address one Street", "Cairo","Cairo",
            "11278","324981892309");
    clickCreateAccountBtn();
    verifyThatAccountCreatedTextIsVisible("ACCOUNT");
}
/////////////////////ELEMENT LOCATORS//////////////////
private final By AutomationText_span = By.xpath("(//span)[1]");
private final By SignUpButton_a = By.xpath("(//a)[5]");
private final By NewUserSignUpTitle_h2 = By.xpath("(//h2)[3]");
private final By SignUpName_input = By.xpath("//input [@type='text']");
private final By SignUpEmail_input =By.xpath("(//input [@type='email'])[2]");
private final By SignUpBtn_button= By.xpath("//button [@data-qa ='signup-button']");
private final By EnterAccountInfoText_b = By.xpath("(//b)[1]");
private final By PasswordField_input = By.id("password");
private final By DateOfBirthDay_option = By.xpath("//*[@id=\"days\"]/option[4]");
private final By DateOfBirthMonth_option = By.xpath("//*[@id=\"months\"]/option[3]");
private final By DateOfBirthYear_option = By.xpath("//*[@id=\"years\"]/option[32]");
private final By NewsletterCheckbox_label = By.xpath("// label [@for = 'newsletter']");
private final By SpecialOffersCheckbox_label = By.xpath("// label [@for = 'optin']");
private final By FirstName_input = By.id("first_name");
private final By LastName_input = By.id("last_name");
private final By Address1_input = By.id("address1");
private final By Country_option = By.xpath("//*[@id=\"country\"]/option[4]");
private final By State_input = By.id("state");
private final By City_input = By.id("city");
private final By ZipCode_input = By.id("zipcode");
private final By MobileNumber_input = By.id("mobile_number");
private final By CreateAccountBtn_button =By.xpath("//button[@data-qa = 'create-account']");
private final By AccountCreatedText_b = By.xpath("//b");

/////////////////////CONFIGURATION/////////////////////
@BeforeClass
public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
@AfterClass
public void closeBrowser(){
    driver.quit();
}
/////////////////////ACTIONS / BUSINESS STEPS/////////////////////
   public void navigateToAutomationExerciseUrl(String websiteURL){
       driver.navigate().to(websiteURL);
   }
    public void assertThatTextContainAutomationWord(String ExpectedDataResult){
        String AutomationTextResult = driver.findElement(AutomationText_span).getText();
        Assert.assertTrue(AutomationTextResult.contains(ExpectedDataResult));
    }
    public void clickOnSignUpButtonFromHomePage (){
    driver.findElement(SignUpButton_a).click();
    }
    public void verifyThatNewUserSignUpIsVisible(){
        String NewUserSignUpText =driver.findElement(NewUserSignUpTitle_h2).getText();
        Assert.assertEquals(NewUserSignUpText, "New User Signup!");
    }
    public void submitSignUpInputs(String Username, String Email){
        driver.findElement(SignUpName_input).sendKeys(Username);
        driver.findElement(SignUpEmail_input).sendKeys(Email);
    }
    public void clickOnSignUpBtn (){
    driver.findElement(SignUpBtn_button).click();
    }
    public void verifyThatEnterAccountInfoIsVisible(String ExpectedTextResult){
        String EnterAccountInfoText =driver.findElement(EnterAccountInfoText_b).getText();
        Assert.assertTrue(EnterAccountInfoText.contains(ExpectedTextResult));
    }
    public void fillAccountPassword(String Password){
        driver.findElement(PasswordField_input).sendKeys(Password);
    }
    public void selectDateOfBirt(){
    ///Need to refactor for better selector strategy (to make the data dynamic)
        driver.findElement(DateOfBirthDay_option).click();
        driver.findElement(DateOfBirthMonth_option).click();
        driver.findElement(DateOfBirthYear_option).click();
    }
    public void selectCheckboxOfNewsletter(){
        driver.findElement(NewsletterCheckbox_label).click();
    }
    public void selectCheckboxOfOffers(){
        driver.findElement(SpecialOffersCheckbox_label).click();
    }
    public void fillCreateAccountDetails(String FirstName, String LastName, String AddressOne,
                                         String State, String City, String ZipCode, String MobileNumber){
        driver.findElement(FirstName_input).sendKeys(FirstName);
        driver.findElement(LastName_input).sendKeys(LastName);
        driver.findElement(Address1_input).sendKeys(AddressOne);
        driver.findElement(Country_option).click();
        driver.findElement(State_input).sendKeys(State);
        driver.findElement(City_input).sendKeys(City);
        driver.findElement(ZipCode_input).sendKeys(ZipCode);
        driver.findElement(MobileNumber_input).sendKeys(MobileNumber);
    }
    public void clickCreateAccountBtn(){
        driver.findElement(CreateAccountBtn_button).click();
    }
    public void verifyThatAccountCreatedTextIsVisible(String ExpectedTextResult){
        String AccountCreatedText=driver.findElement(AccountCreatedText_b).getText();
        Assert.assertTrue(AccountCreatedText.contains(ExpectedTextResult));
    }
}

