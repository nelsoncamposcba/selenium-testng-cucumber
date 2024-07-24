package cucumber.testng.selenium.clase_4.steps;

import cucumber.testng.selenium.clase_4.pages.InventoryPage;
import cucumber.testng.selenium.clase_4.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class InicioSesionSteps {

    LoginPage loginPage = null;
    InventoryPage inventoryPage = null;


    @Given("el usuario está en la página de inicio de sesión de SauceDemo")
    public void el_usuario_esta_en_la_pagina_de_inicio_de_sesion_de_sauce_demo() {
        //Ir a la pagina
        BaseSteps.driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(BaseSteps.driver);
        inventoryPage = new InventoryPage(BaseSteps.driver);
    }

    @When("el usuario ingresa el nombre de usuario {string}")
    public void el_usuario_ingresa_el_nombre_de_usuario(String usuario) {
        loginPage.enterUserName(usuario);
    }
    @When("el usuario ingresa la contraseña {string}")
    public void el_usuario_ingresa_la_contrasena(String contra) {
        loginPage.enterUserPassword("secret_sauce");
    }
    @When("el usuario hace clic en el botón de inicio de sesión")
    public void el_usuario_hace_clic_en_el_boton_de_inicio_de_sesion() {
        loginPage.clickLogin();
    }
    @Then("el usuario debe ser redirigido a la página de productos")
    public void el_usuario_debe_ser_redirigido_a_la_pagina_de_productos() {
        Assert.assertTrue(inventoryPage.isDisplayedShoppingCartLink(), "El carrito no esta visible");
    }
    @Then("el título de la página debe ser {string}")
    public void el_titulo_de_la_pagina_debe_ser(String titulo) {
        Assert.assertEquals(inventoryPage.getTitle(), titulo, "El titulo no tiene el texto correcto");
    }

    @Then("el usuario debe ver un mensaje de error que dice {string}")
    public void el_usuario_debe_ver_un_mensaje_de_error_que_dice(String mensaje) {
        Assert.assertTrue(loginPage.isDisplayedErrorMessage(), "El mensaje de error no esta visible");
        Assert.assertEquals(loginPage.getErrorMessage(), mensaje, "El mensaje de error no es el correcto");
    }

}
