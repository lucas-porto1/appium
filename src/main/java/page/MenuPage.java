package page;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * O aplicativo tem um menu principal ao ser aberto.
 * Portanto os métodos relacionados ao menu são criados nesta classe.
 *
 * @author Lucas Porto Gomes
 */

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlert() {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() {
        clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarCliques() {
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe() {
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        //scroll down
        scrollDown();

        //clicar item
        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop() {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        //scroll down
        scrollDown();

        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        clicarPorTexto("SeuBarriga Híbrido");
    }
}
