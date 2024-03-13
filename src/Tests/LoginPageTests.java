package Tests;

import Pages.InventoryPage.InventoryPage;
import Pages.Login.LoginPage;
import Utils.Log;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{
    private String validUserName = "standard_user";
    private String validPassword = "secret_sauce";
    private String invalidPassword = "invalidPassword";
    private String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @Test(priority = 1)
    public void TestSuccessfulLogin() {
        Log.info("Start Test Case: TestSuccessfulLogin");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, validPassword);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.VerifyCurrentUrl(inventoryPage.inventoryPageUrl);
    }

    @Test(priority = 2)
    public void TestFailedLogin() {
        Log.info("Start Test Case: TestFailedLogin");
        LoginPage loginPage =  new LoginPage(driver);
        loginPage.Login(validUserName, invalidPassword);
        loginPage.ErrorMessageDisplayed();
        loginPage.VerifyErrorMessageText(expectedErrorMessage);
    }
}
