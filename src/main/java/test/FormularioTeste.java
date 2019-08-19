package test;

import core.BaseTest;
import page.FormularioPage;
import page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;

/**
 * Projeto Formulário - Com Design Patterns.
 *
 * @author Lucas Porto Gomes
 */


public class FormularioTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void inicializa() {
        menuPage.acessarFormulario();
    }


    @Test
    public void PreencheCampoTexto() {
        /**Cenário */
        formularioPage.escreverNome("Lucas");

        /**Validação*/
        Assert.assertEquals("Lucas", formularioPage.obterNome());

    }

    @Test
    public void InterageComboBox() throws MalformedURLException {

        /**Cenário */
        formularioPage.selecionarComboBox("PS4");

        /**Validação*/
        Assert.assertEquals("PS4", formularioPage.obterValorCombo());

    }

    @Test
    public void InterageSwitchCheckBox() {
        /**Cenário */
        //Verificar status do CheckBox e do Switch antes do clique.
        Assert.assertFalse(formularioPage.isCheckMarcado()); // O checkbox nesta aplicação se inicia desligado.
        Assert.assertTrue(formularioPage.isSwitchMarcado()); // O switch nesta aplicação se inicia ligado.

        //Clicar nos elementos
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        /**Validação */
        //Verificar alteração
        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());

    }

    @Test
    public void CadastrarUsuario() {

        /** Cenário: preenchendo campos **/

        formularioPage.escreverNome("Lucas Porto Gomes");
        formularioPage.selecionarComboBox("Nintendo Switch");
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();
        formularioPage.salvarCadastro();

        /** Validação **/

        Assert.assertEquals("Nome: Lucas Porto Gomes", formularioPage.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", formularioPage.obterConsoleCadastrado());
        Assert.assertTrue(formularioPage.obterCheckCadastrado().endsWith("Marcado"));
        Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
    }


}
