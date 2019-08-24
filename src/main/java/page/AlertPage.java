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

    public void sairAlerta() {
        clicarPorTexto("SAIR");
    }


}
