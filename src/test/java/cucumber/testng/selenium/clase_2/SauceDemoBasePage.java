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

public class SauceDemoBasePage {

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

        //Creamos una instancia de la clase que contiene los elementos
        LoginPage loginPage = new LoginPage(driver);

        //Acciones del test
        loginPage.enterUserName("standard_user");
        loginPage.enterUserPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isDisplayedShoppingCartLink(), "El carrito no esta visible");
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "El titulo no tiene el texto correcto");
    }

    @Test
    public void testFailLogin() {
        //Ir a la pagina
        driver.get("https://www.saucedemo.com");

        //Creamos una instancia de la clase que contiene los elementos
        LoginPage loginPage = new LoginPage(driver);

        loginPage.initLogin("locked_out_user", "secret_sauce");

        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "El mensaje de error no esta visible");
    }

    @Test
    public void testLoginPerformanceGlitch(){
        //Ir a la pagina
        driver.get("https://www.saucedemo.com");

        //Creamos una instancia de la clase que contiene los elementos
        LoginPage loginPage = new LoginPage(driver);

        //Acciones del test
        loginPage.enterUserName("performance_glitch_user");
        loginPage.enterUserPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isDisplayedShoppingCartLink(), "El carrito no esta visible");
        Assert.assertEquals(inventoryPage.getTitle(), "Products", "El titulo no tiene el texto correcto");
    }


    @AfterClass
    public void teardown(){
        if(driver != null){
            driver.quit();
        }
    }
}
