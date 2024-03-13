package Pages.Login;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String loginPageUrl = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    private WebElement userNameInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    public void Login(String userName, String password) {
        driver.get(loginPageUrl);
        driver.navigate().refresh();
        userNameInput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void ErrorMessageDisplayed() {
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed on the page.");
        VerifyCurrentUrl(loginPageUrl);
    }

    public void VerifyErrorMessageText(String expectedErrorMessage) {
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text does not match.");
    }
}
