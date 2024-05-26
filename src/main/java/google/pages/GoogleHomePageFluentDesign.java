package google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePageFluentDesign {

    private WebDriver driver;
    //Locator variable name convention : meaningfulName_tagName
    String googleHomepageUrl = "https://www.google.com/ncr";
    ///////////Locators
    private final By googleSearch_textarea = By.xpath("//textarea[@name='q']");

    public GoogleHomePageFluentDesign(WebDriver driver) {
        this.driver = driver;
    }

/*    public GoogleHomePageFluentDesign(WebDriver driver) {
        this.driver = driver;
    }*/

    ///////////Actions

    public  GoogleHomePageFluentDesign navigateToGoogleSearchHomePage(String url){
        driver.navigate().to(url);
        return this;
    }
    public GoogleHomePageFluentDesign googleSearch(String searchData){
        driver.findElement(googleSearch_textarea).sendKeys(searchData, Keys.ENTER);
        return this;
    }
}
