package Pages.InventoryPage;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartBackPack;

}
