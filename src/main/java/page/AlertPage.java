package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AlertPage extends BasePage {

    public void entraAlertaConfirmacao() {
        clicarPorTexto("ALERTA CONFIRM");
    }

    public void entraAlertaRestritivo() {
        clicarPorTexto("ALERTA RESTRITIVO");
    }

    public void entraAlertaSimples() {
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void confirmaAlert() {
        clicarPorTexto("CONFIRMAR");
    }


    public String obterTituloAlert() {
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlert() {
        return obterTexto(By.id("android:id/message"));
    }

    public boolean existeMensagem(String mensagem) {
        return existemElementos(By.xpath("//*[@text='" + mensagem + "']"));
    }

    public void sairAlerta() {
        clicarPorTexto("SAIR");
    }

    public void clicarFora() {
        tapScreen(200, 200);
    }



}
