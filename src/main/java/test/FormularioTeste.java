package test;

import core.BaseTest;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import page.FormularioPage;
import page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * A Activity Formulário contém uma tela de cadastro com várias funcionalidades.
 * O intuíto é validar o cadastro do usuário e verificar se todos os campos estão funcionais.
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
    public void preencheCampoTexto() {
        //Cenário
        formularioPage.escreverNome("Lucas");

        //Validação
        Assert.assertEquals("Lucas", formularioPage.obterNome());

    }

    @Test
    public void interageComboBox() {

        //Cenário
        formularioPage.selecionarComboBox("PS4");

        //Validação
        Assert.assertEquals("PS4", formularioPage.obterValorCombo());

    }

    @Test
    public void interageSwitchCheckBox() {
        //Cenário
        //Verificar status do CheckBox e do Switch antes do clique.
        Assert.assertFalse(formularioPage.isCheckMarcado()); // O checkbox nesta aplicação se inicia desligado.
        Assert.assertTrue(formularioPage.isSwitchMarcado()); // O switch nesta aplicação se inicia ligado.

        //Clicar nos elementos
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        //Validação
        //Verificar alteração
        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());

    }

    @Test
    public void cadastrarUsuario() {

        // Cenário: preenchendo campos

        formularioPage.escreverNome("Lucas Porto Gomes");
        formularioPage.selecionarComboBox("Nintendo Switch");
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();
        formularioPage.salvarCadastro();

        // Validação

        Assert.assertEquals("Nome: Lucas Porto Gomes", formularioPage.obterNomeCadastrado());
        Assert.assertEquals("Console: switch", formularioPage.obterConsoleCadastrado());
        Assert.assertTrue(formularioPage.obterCheckCadastrado().endsWith("Marcado"));
        Assert.assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Off"));
    }

    @Test
    public void alterarData(){
        //clica na data.
        formularioPage.clicaData("01/01/2000");

        //altera data
        formularioPage.clicar(By.id("android:id/next")); // altera o mês.
        formularioPage.clicarPorTexto("25"); // seleciona o dia.
        formularioPage.clicarPorTexto("OK"); // confirma.

        //verifica data alterada.
        Assert.assertTrue(formularioPage.verificaData("25/3/2000"));

    }

    @Test
    public void alterarHora(){
        //clica na hora
        formularioPage.clicaHora("06:00");

        //altera a hora
        formularioPage.clicar(MobileBy.AccessibilityId("16")); // seleciona a hora.
        formularioPage.clicar(MobileBy.AccessibilityId("30")); // altera os minutos.
        formularioPage.clicarPorTexto("OK");

        //verifica alteração da hora
        Assert.assertTrue(formularioPage.verificaHora("16:30"));
    }


}
