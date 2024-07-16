package cucumber.testng.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        //ERROR: FALTABA LA SIGUIENTE LINEA DE CÓDIGO
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartLink;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement title;

    public boolean isDisplayedShoppingCartLink() {
        return shoppingCartLink.isDisplayed();
    }

    public String getTitle() {
        return title.getText();
    }

}
