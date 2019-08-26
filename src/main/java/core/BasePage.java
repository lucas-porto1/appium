package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;

import static core.DriverFactory.*;

/**
 * DSL
 *
 * @author Lucas Porto Gomes
 */

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='" + texto + "']"));
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElemento(By by) {
        return getDriver().findElement(by).isDisplayed();
    }

    /**
     * Alternativa do método existe elementos, mas com FindElements
     **/
    public boolean existemElementos(By by) {
        List<MobileElement> elements = getDriver().findElements(by);
        return elements.size() > 0;
    }

    public boolean existemElementosByText(String texto) {
        return existemElementos(By.xpath("//*[@text='" + texto + "']"));
    }

    public boolean existemQtdElementos(By by, int x) {
        List<MobileElement> elements = getDriver().findElements(by);
        return elements.size() >= x;
    }

    //toque por coordenadas
    public void tapScreen(int x, int y) {
        new TouchAction(DriverFactory.getDriver()).tap(PointOption.point(x, y)).perform();
    }

    public void esperar(int tempo) {
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void scroll(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int yInicial = (int) (size.height * inicio);
        int yFinal = (int) (size.height * fim);

        new TouchAction(getDriver())
                .longPress(PointOption.point(x, yInicial)) //pressiona
                .moveTo(PointOption.point(x, yFinal)) // move a tela
                .release() //solta a tela
                .perform(); //realiza ação

    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }


    public void swipe(double inicio, double fim) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int xInicial = (int) (size.width * inicio);
        int xFinal = (int) (size.width * fim);

        new TouchAction(getDriver())
                .longPress(PointOption.point(xInicial, y)) //pressiona
                .moveTo(PointOption.point(xFinal, y)) // move a tela
                .release() //solta a tela
                .perform(); //realiza ação

    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void swipeElement(MobileElement element, double inicio, double fim) {

        int y = element.getLocation().y + (element.getSize().height / 2);

        int xInicial = (int) (element.getSize().width * inicio);
        int xFinal = (int) (element.getSize().width * fim);

        new TouchAction(getDriver())
                .longPress(PointOption.point(xInicial, y)) //pressiona
                .moveTo(PointOption.point(xFinal, y)) // move a tela
                .release() //solta a tela
                .perform(); //realiza ação

    }

}
