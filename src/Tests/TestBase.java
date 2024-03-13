package Tests;

import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class TestBase {
    public WebDriver driver;
    private String geckoLocation = "drivers/geckodriver.exe";

    @BeforeMethod
    public void Setup() throws Exception {
        Log.info("--- Open Firefox ---");
        System.setProperty("webdriver.gecko.driver", geckoLocation);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void Teardown() throws Exception {
        Log.info("--- Close Firefox ---");
        driver.quit();
    }
}