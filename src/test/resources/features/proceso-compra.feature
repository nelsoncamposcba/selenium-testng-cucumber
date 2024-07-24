Feature: Proceso de compra en SauceDemo

  Scenario: Completar una compra exitosamente
    Given el usuario ha iniciado sesión exitosamente en SauceDemo
    And el usuario ha agregado un producto al carrito
    And el usuario está en la página del carrito de compras
    When el usuario hace clic en el botón Checkout
    And el usuario ingresa su información de "First Name", "Last Name" y "Postal Code"
    And el usuario hace clic en el botón Continue
    And el usuario revisa la información de su pedido y hace clic en el botón Finish
    Then el usuario debe ver un mensaje que dice "Thank you for your order!"