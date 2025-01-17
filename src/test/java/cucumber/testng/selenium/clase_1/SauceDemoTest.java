package cucumber.testng.selenium.clase_1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoTest {

    WebDriver driver = null;

    @BeforeClass
    public void setup(){
        //Descarga y configura el webdriver
        WebDriverManager.chromedriver().setup();

        //Creamos la instancia del webdriver
        driver = new ChromeDriver();
    }

    @Test
    public void testLogin(){
        //Ir a la pagina
        driver.get("https://www.saucedemo.com");

        //Elementos web necesarios para el test
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtUserPassword = driver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Acciones del test
        txtUserName.sendKeys("standard_user");
        txtUserPassword.sendKeys("secret_sauce");
        btnLogin.click();

        Assert.assertTrue(driver.findElement(By.className("shopping_cart_link")).isDisplayed(), "El carrito no esta visible");
        Assert.assertEquals(driver.findElement(By.className("title")).getText(), "Products", "El titulo no tiene el texto correcto");
    }

    @Test
    public void testFailLogin(){
        //Ir a la pagina
        driver.get("https://www.saucedemo.com");

        //Elementos web necesarios para el test
        WebElement txtUserName = driver.findElement(By.id("user-name"));
        WebElement txtUserPassword = driver.findElement(By.xpath("//input[@data-test='password']"));
        WebElement btnLogin = driver.findElement(By.id("login-button"));

        //Acciones del test
        txtUserName.sendKeys("locked_out_user");
        txtUserPassword.sendKeys("secret_sauce");
        btnLogin.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='error-message-container error']")).isDisplayed(), "El mensaje de error no esta visible");
    }


    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
