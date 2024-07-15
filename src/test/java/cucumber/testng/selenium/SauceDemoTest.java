package cucumber.testng.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
    }





    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
