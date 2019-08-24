package core;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

import static core.DriverFactory.*;

/**
 *  DSL
 * @author Lucas Porto Gomes
 */

public class BasePage {

    public void escrever(By by, String texto){
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by){
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by){
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto){
        clicar(By.xpath("//*[@text='"+texto+"']"));
    }

    public void selecionarCombo(By by, String valor){
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by){
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElemento(By by){
        return getDriver().findElement(by).isDisplayed();
    }

    /** Alternativa do método existe elementos, mas com FindElements**/
    public boolean existemElementos(By by){
        List<MobileElement> elements = getDriver().findElements(by);
        return elements.size() > 0;
    }



}
