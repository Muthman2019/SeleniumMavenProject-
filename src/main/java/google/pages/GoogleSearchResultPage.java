package google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GoogleSearchResultPage {
    private WebDriver driver;
/////////Locators
private final By firstSearchResultText_h3 = (By.xpath("(//h3)[1]"));

    public GoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }


///////Actions

////////Validations
public void assertOnFirstSearchResult(String expectedResult){
    String firstSearchResultText = driver.findElement(firstSearchResultText_h3).getText();
    Assert.assertTrue(firstSearchResultText.contains(expectedResult));
}
}
