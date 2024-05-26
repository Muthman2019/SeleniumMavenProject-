package automationExcersice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupFormPage {
    private WebDriver driver;

    public SignupFormPage(WebDriver driver) {
        this.driver = driver;
    }

    /////Locators//////
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
/////////////////////Actions////////////////////
public void verifyThatEnterAccountInfoIsVisible(){
    String EnterAccountInfoText =driver.findElement(EnterAccountInfoText_b).getText();
    Assert.assertTrue(EnterAccountInfoText.contains("ENTER ACCOUNT INFORMATION"));
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
    public void verifyThatAccountCreatedTextIsVisible(){
        String AccountCreatedText=driver.findElement(AccountCreatedText_b).getText();
        Assert.assertTrue(AccountCreatedText.contains("ACCOUNT"));
    }
}
