package cucumber.testng.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
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
        txtUserName.isDisplayed();
        txtUserName.isEnabled();
        txtUserName.sendKeys(userName);
    }

    public void enterUserPassword(String password){
        txtUserPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void initLogin(String userName, String password){
        enterUserName(userName);
        enterUserPassword(password);
        clickLogin();
    }

    public boolean isDisplayedErrorMessage(){
        return errorMessage.isDisplayed();
    }
}
