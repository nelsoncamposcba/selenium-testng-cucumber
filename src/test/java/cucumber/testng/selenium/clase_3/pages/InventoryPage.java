package cucumber.testng.selenium.clase_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    private List<WebElement> inventoryItems;


    public boolean isDisplayedShoppingCartLink() {
        return isDisplayed(shoppingCartLink);
    }

    public String getTitle() {
        return getText(title);
    }

    public List<String> getInventoryItems() {
        List<String> items = new ArrayList<String>();
        for (WebElement item : inventoryItems) {
            items.add(item.getText());
        }

        return items;
    }

    public boolean existProduct(String productName){
        for (WebElement item : inventoryItems) {
            if(item.getText().equals(productName)){
                return true;
            }
        }

        return false;
    }
}
