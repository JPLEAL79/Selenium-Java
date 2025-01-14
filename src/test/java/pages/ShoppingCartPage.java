package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jp
 * Esta clase representa la página de compras del producto.
 * El @Findby de page factory se utiliza para inicializar elementos de una clase
 * sin tener que usar FindElement o FindElements
 */

public class ShoppingCartPage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='amasty-shopby-product-list']/div[2]/ol/li[1]")
    private WebElement clickInProduct;
    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement verifyProduct;
    @FindBy(xpath = "//*[@id='qty']")
    private WebElement clearTextBox;
    @FindBy(xpath = "//*[@id='qty']")
    private WebElement selectQuantity;
    @FindBy(xpath = "//*[@id='product-addtocart-button']")
    private WebElement addToCart;
    @FindBy(xpath = "//*[@class='message-success success message']")
    private WebElement verifyPurchase;


    /**
     * Este es un método constructor
     * tiene implementada una espera "Implícita" y la incializacion de "PageFactory" quien se encarga de
     * cargar los elementos WEb de la clase.
     *
     * @param driver Se utiliza para interactuar con el Browser
     */

    public ShoppingCartPage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Este método hace click en el botón "Ver producto"
     */
    public void clickOnButtonSeeProduct() {
        clickInProduct.click();
    }

    /**
     * @return Devuelve un booleano varifica que exista el producto
     */
    public boolean verifyExistingProduct() {
        return verifyProduct.isDisplayed();
    }

    /**
     * Este método sirve para limpiar y agregar la cantidad de productos en la caja de texto
     * tiene un parametro de tipo String y es llamado desde la clase "Test"
     *
     * @param amount Sirve para seleccionar la cantidad de productos a comprar
     */
    public void addNumberOfProducts(String amount) {
        clearTextBox.clear();
        selectQuantity.sendKeys(amount);
    }

    /**
     * Este método hace la accion de dar click en el botón "Agregar al carrito"
     */
    public void addToShoppingCart() {
        wait.until(ExpectedConditions.visibilityOf(addToCart));
        addToCart.submit();
    }

    /**
     * @return Devuelve un booleano varifica que este en el carrito de compras
     */
    public boolean verifyThePurchase() {
        return verifyPurchase.isDisplayed();
    }

}