package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author jp
 * Esta clase representa la página del "HomePage",
 * el @Findby de page factory se utiliza para inicializar elementos de una clase
 * sin tener que usar FindElement o FindElements
 */
public class HomePage {

    private WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@id='search']")
    private WebElement searchBox;
    @FindBy(xpath = "//*[@class='base']")
    private WebElement verifyProduct;

    /**
     * Este es un método constructor
     * tiene implementada una espera "Implícita" y la incializacion de "PageFactory" quien se encarga de
     * cargar los elementos WEb de la clase.
     * @param driver Se utiliza para interactuar con el Browser
     */

    public HomePage(WebDriver driver) {
        wait = new WebDriverWait(driver, 15);
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Este método valida la caja de busqueda
     *
     * @param nombreProducto Este parametro es de tipo String y sirve para buscar un producto
     * desde la clase Tests.
     */

    public void searchInTextBox(String nombreProducto) {
        searchBox.clear();
        searchBox.sendKeys(nombreProducto);
        searchBox.sendKeys(Keys.ENTER);
    }

    /**
     * @return Devuelve un booleano validando que exista el producto seleccionado.
     */
    public boolean verifyProduct() {
        return searchBox.isDisplayed();
    }
}


