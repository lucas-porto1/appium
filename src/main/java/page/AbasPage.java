package page;

import core.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {


    public void acessaAbaUm() {
        clicarPorTexto("ABA 1");
    }

    public void acessaAbaDois() {
        clicarPorTexto("ABA 2");
    }

    // Estou utilizando o xpath, porque o aplicativo não está com ID e nem com AccessibilityID.

    public String obterTextoAbaUm() {
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }

    public String obterTextoAbaDois() {
        return obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }


}
