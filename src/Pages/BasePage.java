package Pages;

import Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void VerifyCurrentUrl(String expectedUri) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUri, currentUrl, "Current Url is incorrect");
    }
}