package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
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

    @Before
    public void inicializa() {
        menuPage.acessarAlert();
    }

    @Test
    public void confirmaAlert() {

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

    @Test
    public void simplesAlert() {
        //Clica no alerta simples
        alertPage.entraAlertaSimples();

        //Verifica se a mensagem do alerta está presente.
        String mensagem = alertPage.obterMensagemAlert();
        Assert.assertEquals("Pode clicar no OK ou fora da caixa para sair", mensagem);

        //Clica fora do alerta através de coordenadas.
        alertPage.esperar(1000);
        alertPage.clicarFora();

        //Verifica se saiu do alerta simples.
        Assert.assertFalse(alertPage.existeMensagem(mensagem)); //verifica que a mensagem não está mais presente.


    }

    @Test
    public void restritivoAlert() {
        //Clica no alerta restritivo.
        alertPage.entraAlertaRestritivo();

        //Verifica se a mensagem do alerta restritivo está presente.
        String mensagem = alertPage.obterMensagemAlert();
        Assert.assertEquals("Não pode clicar fora, apenas no SAIR", mensagem);

        //Clica em sair.
        alertPage.esperar(1000);
        alertPage.clicarPorTexto("SAIR");

        //Verifica se saiu do alerta restritivo.
        Assert.assertFalse(alertPage.existeMensagem(mensagem));
    }
}
