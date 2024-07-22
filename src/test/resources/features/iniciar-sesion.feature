Feature: Inicio de sesión en SauceDemo

  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given el usuario está en la página de inicio de sesión de SauceDemo
    When el usuario ingresa el nombre de usuario "standard_user"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace clic en el botón de inicio de sesión
    Then el usuario debe ser redirigido a la página de productos
    And el título de la página debe ser "Products"


  Scenario: Inicio de sesión fallido con nombre de usuario inválido
    Given el usuario está en la página de inicio de sesión de SauceDemo
    When el usuario ingresa el nombre de usuario "usuario_invalido"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace clic en el botón de inicio de sesión
    Then el usuario debe ver un mensaje de error que dice "Epic sadface: Username and password do not match any user in this service"
