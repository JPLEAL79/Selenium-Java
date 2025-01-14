package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class Tests extends BaseTest {


    @Test
    public void testAddToCart() {

        String product = "radio";

        // Este assertion valida el correcto funcionamiento de ingreso a la aplicación.
        loginPage.Login(getProperty("email"), getProperty("password"));
        Assert.assertTrue(loginPage.verifyLoginCorrect());

        // Este assertion valida el correcto funcionamiento de la caja de búsqueda.
        homePage.searchInTextBox(product);
       // Assert.assertTrue(homePage.verifyProduct());

        // Este assertion valida que se muestren por consola todas las marcas del producto seleccionado.
        filterPage.obtenerListadoDeMarcas();
        Assert.assertTrue(filterPage.verifyList());

        // Este assertion valida el correcto funcionamiento del botón "Ver producto" del producto seleccionado.
        shoppingCartPage.clickOnButtonSeeProduct();
        Assert.assertTrue(shoppingCartPage.verifyExistingProduct());

        // Este test selecciona el número de productos.
        shoppingCartPage.addNumberOfProducts("2");

        // Este assertion valida que exista el producto en el carro de compras
        shoppingCartPage.addToShoppingCart();
        //Assert.assertTrue(shoppingCartPage.verifyThePurchase());

    }
}
