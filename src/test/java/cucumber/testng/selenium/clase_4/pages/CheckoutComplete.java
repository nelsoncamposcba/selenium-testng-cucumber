package cucumber.testng.selenium.clase_4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutComplete extends BasePage{
    public CheckoutComplete(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "complete-text")
    private WebElement completeText;
    @FindBy(className = "complete-header")
    private WebElement completeHeader;


    public String getCompleteText() {
        return getText(completeText);
    }

    public String getCompleteHeaderText() {
        return getText(completeHeader);
    }
}
