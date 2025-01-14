package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * @author jp
 * Esta clase representa la página del "Login"
 * el @Findby de page factory se utiliza para inicializar elementos de una clase
 * sin tener que usar "FindElement o FindElements"
 */

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Entrar")
    private WebElement enter;
    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "pass")
    private WebElement passwordField;
    @FindBy(css = "fieldset .primary:nth-of-type(1) span")
    private WebElement loginButton;
    @FindBy(xpath = "//*[contains(text(),'Registrate')]")
    private WebElement verifyEmptyLogin;
    @FindBy(xpath = "//*[contains(text(),'Logout')]")
    private WebElement verifyLoginOk;


    /**
     * Este es un método constructor
     * tiene implemetada una espera "Implícita" y la incializacion de "PageFactory" quien se encarga de
     * cargar los elementos WEb de la clase.
     *
     * @param driver Se utiliza para interactuar con el Browser
     */

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Este es un método con dos parametros de tipo String. Basicamente limpia las cajas de texto e ingresar datos.
     * @param email    Este parametro sirve para ingresar el email
     * @param password Este parametro sirve para ingresar la password
     */
    public void Login(String email, String password) {
        wait.until(ExpectedConditions.elementToBeClickable((enter)));
        enter.click();
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }

    /**
     * Es un test negativo
     * @return Devuelve un booleano validando que exista el texto "Campo Obligatorio"
     */
    public boolean verifyEmptyLogin() {
        return verifyEmptyLogin.isDisplayed();
    }

    /**
     * Este es un test positivo valida el correcto ingreso a la aplicacion.
     * @return Devuelve un booleano validando que exista el link "Logout"
     */
    public boolean verifyLoginCorrect() {
        return verifyLoginOk.isDisplayed();
    }
}



