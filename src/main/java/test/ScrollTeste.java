package test;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AlertPage;
import page.MenuPage;

public class ScrollTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Test
    public void interageOpcaoEscondida() {
        /* vai fazer scroll-down e clicar no último item.*/

        //há um problema de sincronismo com o scroll down no inicio da tela, portanto foi corrigido com wait.
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

        //scroll down
        menuPage.scrollDown();

        //clicar item
        menuPage.clicarPorTexto("Opção bem escondida");

        //verificar mensagem
        Assert.assertEquals("Você achou essa opção", alertPage.obterMensagemAlert());

        //sair
        menuPage.clicarPorTexto("OK");

    }
}
