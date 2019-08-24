package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.AlertPage;
import page.MenuPage;

/**
 * A activity Alerts contém diversos alertas.
 * O método irá validar o funcionamento desses alertas, como:
 * confirmação, negação, títulos, textos, entradas e saídas.
 *
 * @author Lucas Porto Gomes
 */

public class AlertTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertPage alertPage = new AlertPage();

    @Test
    public void confirmaAlert() {
        //Acessa o menu de alertas.
        menuPage.acessarAlert();

        //Clica no alerta de confirmação.
        alertPage.entraAlertaConfirmacao();

        //Verifica título e mensagem do alerta.
        Assert.assertEquals("Info", alertPage.obterTituloAlert());
        Assert.assertEquals("Confirma a operação?", alertPage.obterMensagemAlert());

        //Confirma alerta.
        alertPage.confirmaAlert();

        //Verifica a confirmação do alerta.
        Assert.assertEquals("Confirmado", alertPage.obterMensagemAlert());

        //Sai do alerta
        alertPage.sairAlerta();

    }
}
