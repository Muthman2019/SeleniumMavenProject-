package google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleSearchResultPageFluentDesign {
    private WebDriver driver;
/////////Locators
private final By firstSearchResultText_h3 = (By.xpath("(//h3)[1]"));

    public GoogleSearchResultPageFluentDesign(WebDriver driver) {
        this.driver = driver;
    }


///////Actions

////////Validations
/*
public void assertOnFirstSearchResult(String expectedResult){
    String firstSearchResultText = driver.findElement(firstSearchResultText_h3).getText();
    Assert.assertTrue(firstSearchResultText.contains(expectedResult));
*/
   public GoogleSearchResultPageFluentDesign assertOnPageTitle( String expectedTitle){
       String actualTitle = driver.getTitle();
       Assert.assertTrue(actualTitle.contains(expectedTitle));
       return this;
   }
    public GoogleSearchResultPageFluentDesign assertOnFirstSearchResult(String expectedResult){
        String firstSearchResultText = driver.findElement(firstSearchResultText_h3).getText();
        Assert.assertTrue(firstSearchResultText.contains(expectedResult));
        return this;
    }

}
