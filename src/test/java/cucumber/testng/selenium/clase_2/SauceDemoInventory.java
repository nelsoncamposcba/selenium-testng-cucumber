package cucumber.testng.selenium.clase_2;

import cucumber.testng.selenium.clase_2.pages.InventoryPage;
import cucumber.testng.selenium.clase_2.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SauceDemoInventory {

    WebDriver driver = null;

    @BeforeClass
    public void setup(){
        //Descarga y configura el webdriver
        WebDriverManager.chromedriver().setup();

        //Creamos la instancia del webdriver
        driver = new ChromeDriver();
    }

    @Test
    public void searchProduct(){
        //Ir a la pagina
        driver.get("https://www.saucedemo.com");

        //Creamos una instancia de la clase que contiene los elementos
        LoginPage loginPage = new LoginPage(driver);

        //Acciones del test
        loginPage.enterUserName("standard_user");
        loginPage.enterUserPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.existProduct("Sauce Labs Onesie"), "El producto Sauce Labs Onesie no existe en listado");
    }

    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }

}
