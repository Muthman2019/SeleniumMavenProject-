import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ExcersiceSignUp {
    WebDriver driver;
@Test
//1. Launch browser
    public void homePage(){
//2. Navigate to url 'http://automationexercise.com'
    driver.navigate().to("http://automationexercise.com");
//3. Verify that home page is visible successfully
    //3.1 locate the "automation exercise element" and get the text then save in var
    String AutomationText= driver.findElement(By.xpath("(//span)[1]")).getText();
    //3.2 Assert that the text contains "Automation" word:
    Assert.assertTrue(AutomationText.contains("Automation"));
    }
@Test(dependsOnMethods = "homePage")
    public void registerPage(){
    //4. Click on 'Signup / Login' button
    driver.findElement(By.xpath("(//a)[5]")).click();
    //5. Verify 'New User Signup!' is visible
    String NewUserSignUpText =driver.findElement(By.xpath("(//h2)[3]")).getText();
    Assert.assertEquals(NewUserSignUpText, "New User Signup!");
}
@Test(dependsOnMethods = "registerPage")
public void submitRegisterNameAndEmail(){
//6. Enter name and email address
    driver.findElement(By.xpath("//input [@type='text']")).sendKeys("IloveGizaTwo");
    driver.findElement(By.xpath("(//input [@type='email'])[2]")).sendKeys("giza2@giza2.com");
//7. Click 'Signup' button
    driver.findElement(By.xpath("//button [@data-qa ='signup-button']")).click();
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
    String EnterAccountInfoText =driver.findElement(By.xpath("(//b)[1]")).getText();
    Assert.assertTrue(EnterAccountInfoText.contains("ENTER"));
}
@Test(dependsOnMethods = "submitRegisterNameAndEmail")
public void createAccount(){
    //9. Fill details: Title, Name, Email, Password, Date of birth
    driver.findElement(By.id("password")).sendKeys("456");
    driver.findElement(By.xpath("//*[@id=\"days\"]/option[4]")).click();
    driver.findElement(By.xpath("//*[@id=\"months\"]/option[3]")).click();
    driver.findElement(By.xpath("//*[@id=\"years\"]/option[32]")).click();
//10. Select checkbox 'Sign up for our newsletter!'
    driver.findElement(By.xpath("// label [@for = 'newsletter']")).click();
//11. Select checkbox 'Receive special offers from our partners!'
    driver.findElement(By.xpath("// label [@for = 'optin']")).click();
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    driver.findElement(By.id("first_name")).sendKeys("First Name");
    driver.findElement(By.id("last_name")).sendKeys("Last Name");
    driver.findElement(By.id("address1")).sendKeys("AdressOnetwo");
    driver.findElement(By.xpath("//*[@id=\"country\"]/option[4]")).click();
    driver.findElement(By.id("state")).sendKeys("state");
    driver.findElement(By.id("city")).sendKeys("City");
    driver.findElement(By.id("zipcode")).sendKeys("zipcode");
    driver.findElement(By.id("mobile_number")).sendKeys("93857432890");
//13. Click 'Create Account button'
    driver.findElement(By.xpath("//button[@data-qa = 'create-account']")).click();
//14. Verify that 'ACCOUNT CREATED!' is visible
    String AccountCreatedText=driver.findElement(By.xpath("//b")).getText();
    Assert.assertTrue(AccountCreatedText.contains("ACCOUNT"));
}

@BeforeClass
public void setUp(){
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}

@AfterClass
public void closeBrowser(){
    driver.quit();
}


}
