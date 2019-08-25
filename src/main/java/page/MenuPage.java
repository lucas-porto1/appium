package page;

import core.BasePage;

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
}
