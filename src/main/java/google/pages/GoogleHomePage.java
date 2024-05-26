package google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    private WebDriver driver;
    //Locator variable name convention : meaningfulName_tagName
    String googleHomepageUrl = "https://www.google.com/ncr";
    ///////////Locators
    private final By googleSearch_textarea = By.xpath("//textarea[@name='q']");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    ///////////Actions
    public void navigateToGoogleSearchHomepage(){
        driver.navigate().to(googleHomepageUrl);
    }
    public void googleSearch(String searchData){
        driver.findElement(googleSearch_textarea).sendKeys(searchData, Keys.ENTER);
    }
}
