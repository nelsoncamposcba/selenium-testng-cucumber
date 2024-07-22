package cucumber.testng.selenium.clase_3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    protected String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void clear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
    }

    protected void selectByVisibleText(WebElement element, String text) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(WebElement element, String value) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByValue(value);
    }

    protected void selectByIndex(WebElement element, int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
        select.selectByIndex(index);
    }

    protected String getAttribute(WebElement element, String attribute) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getAttribute(attribute);
    }

    protected boolean isDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected boolean isEnabled(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
    }

    protected boolean isSelected(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isSelected();
    }

    protected void submit(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element)).submit();
    }


}
