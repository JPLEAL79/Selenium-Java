# TechnicalTest

Arquitectura del proyecto.

1- Uso de Maven para la estructura del proyecto.

2- Uso de TestNG para la ejecución de los test mediante el testng.xml y para la creación de tests y validaciones con el uso de los Assert.

3- Uso de Java Intellij IDEA como lenguaje de programación.

4- Uso de Selenium Webdriver como herramienta de automatización para la ejecucion de los tests.

5- Uso de Chromedriver versión 108.0.5359.125   y Geckodriver versión 108.0.1

Uso del pom.xml para el uso de dependencias, allure, maven, testNG, selenium, webdrivermanager.

7- Uso de JavaDoc para la documentacion del proyecto.

Ejecución de los Test.
1- Abrir el proyecto.

2- Copiar la ruta de directorio allure.

3- Abrir la terminal escribir el comando “allure serve + la ruta del directorio” luego enter. Los test correran internamente y se desplegara un informe de Allure con los test failed y correct. Esto es solo si estan incluidas las variables de entorno de allure de lo contrario usar la opción N°4 para correr los tests.

4- Esta opcción a la anterior es mas fácil y se visualizan todas las acciones de la página, esto se logra corriendo los tests desde el “testng.xml”.


