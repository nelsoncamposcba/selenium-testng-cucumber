package cucumber.testng.selenium.clase_2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement txtUserName;

    @FindBy(xpath = "//input[@data-test='password']")
    private WebElement txtUserPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    private WebElement errorMessage;




    public void enterUserName(String userName){
        sendKeys(txtUserName, userName);
    }

    public void enterUserPassword(String password){
        sendKeys(txtUserPassword, password);
    }

    public void clickLogin(){
        click(btnLogin);
    }

    public void initLogin(String userName, String password){
        enterUserName(userName);
        enterUserPassword(password);
        clickLogin();
    }

    public boolean isDisplayedErrorMessage(){
        return isDisplayed(errorMessage);
    }
}
