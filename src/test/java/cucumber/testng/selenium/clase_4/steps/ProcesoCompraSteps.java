package cucumber.testng.selenium.clase_4.steps;

import cucumber.testng.selenium.clase_4.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ProcesoCompraSteps {

    LoginPage loginPage = null;
    InventoryPage inventoryPage = null;
    CartPage cartPage = null;
    CheckoutStepOne checkoutStepOne = null;
    CheckoutStepTwo checkoutStepTwo = null;
    CheckoutComplete checkoutComplete = null;

    @Given("el usuario ha iniciado sesión exitosamente en SauceDemo")
    public void el_usuario_ha_iniciado_sesión_exitosamente_en_sauce_demo() {
        //Ir a la pagina
        BaseSteps.driver.get("https://www.saucedemo.com");

        loginPage = new LoginPage(BaseSteps.driver);
        loginPage.initLogin("standard_user", "secret_sauce");
    }
    @Given("el usuario ha agregado un producto al carrito")
    public void el_usuario_ha_agregado_un_producto_al_carrito() {
        inventoryPage = new InventoryPage(BaseSteps.driver);

        inventoryPage.addCartSauceLabsBackpack();
    }

    @Given("el usuario está en la página del carrito de compras")
    public void el_usuario_esta_en_la_pagina_del_carrito_de_compras() {
        inventoryPage.goShoppingCartLink();
    }
    @When("el usuario hace clic en el botón Checkout")
    public void el_usuario_hace_clic_en_el_botón_checkout() {
        cartPage = new CartPage(BaseSteps.driver);
        cartPage.goToCheckout();
    }
    @When("el usuario ingresa su información de {string}, {string} y {string}")
    public void el_usuario_ingresa_su_información_de_y(String firstName, String lastName, String postalCode) {
        checkoutStepOne = new CheckoutStepOne(BaseSteps.driver);

        checkoutStepOne.completedInformation(firstName, lastName, postalCode);
    }
    @When("el usuario hace clic en el botón Continue")
    public void el_usuario_hace_clic_en_el_botón_continue() {
        checkoutStepOne.goToCheckoutPage();
    }
    @When("el usuario revisa la información de su pedido y hace clic en el botón Finish")
    public void el_usuario_revisa_la_información_de_su_pedido_y_hace_clic_en_el_boton_finish() {
        checkoutStepTwo = new CheckoutStepTwo(BaseSteps.driver);

        Assert.assertTrue(checkoutStepTwo.isDisplayedCartList(), "El carrito no se encuentra visible");

        checkoutStepTwo.finish();
    }
    @Then("el usuario debe ver un mensaje que dice {string}")
    public void el_usuario_debe_ver_un_mensaje_que_dice(String text) {
        checkoutComplete = new CheckoutComplete(BaseSteps.driver);

        Assert.assertEquals(
                checkoutComplete.getCompleteHeaderText(),
                text,
                "El mensaje que debe ser igual a " + text
        );
    }
}
