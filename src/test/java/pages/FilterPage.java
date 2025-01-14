package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author jp
 * Esta clase representa la seccion de FILTROS espesificamente "Marcas".
 * El @Findby de page factory se utiliza para inicializar elementos de una clase
 * sin tener que usar FindElement o FindElements
 */

public class FilterPage {

    WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='amasty-shopby-product-list']/div[2]/ol/li")
    private List<WebElement> listaDeMarcas;
    @FindBy(xpath = "//*[@id='amasty-shopby-product-list']")
    private WebElement verifyBrandList;


    /**
     * Este es un método constructor
     * tiene implementada una espera "Implícita" y la incializacion de "PageFactory" quien se encarga de
     * cargar los elementos WEb de la clase.
     * @param driver Se utiliza para interactuar con el Browser.
     */
    public FilterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);

    }
    /**
     * Este método recorre una una lista de marcas con un bucle "For each"
     * y obtiene el texto del WebElement de la lista e Imprime por consola
     */
    public void obtenerListadoDeMarcas() {

        String nombreMarca = "";
        for (WebElement marca : listaDeMarcas) {
            nombreMarca = marca.getText();
            System.out.println(nombreMarca);
        }
    }
    /**
     * @return Devuelve por consola una lista de marcas del produsto seleccionado.
     */
    public boolean verifyList() {
        return verifyBrandList.isDisplayed();
    }
}


