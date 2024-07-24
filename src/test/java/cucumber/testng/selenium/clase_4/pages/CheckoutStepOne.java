package cucumber.testng.selenium.clase_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOne extends BasePage{
    public CheckoutStepOne(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement btnContinue;

    public void completedInformation(String firstName, String lastName, String postalCode){
        sendKeys(this.firstName, firstName);
        sendKeys(this.lastName, lastName);
        sendKeys(this.postalCode, postalCode);
    }

    public void goToCheckoutPage(){
        click(this.btnContinue);
    }
}
