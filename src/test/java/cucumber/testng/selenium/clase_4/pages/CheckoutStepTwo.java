package cucumber.testng.selenium.clase_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwo extends BasePage {

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy(className = "cart_list")
    private WebElement cartList;


    public CheckoutStepTwo(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedCartList(){
        return isDisplayed(cartList);
    }

    public void finish(){
        finish.click();
    }
}
