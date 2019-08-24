package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.AccordionPage;
import page.MenuPage;

/**
 * A activity Accordion contém diversas opções para serem clicadas..
 * O método irá validar o funcionamento de cada accordion.
 *
 * @author Lucas Porto Gomes
 */

public class AccordionTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();


    @Test
    public void accordionTestes() {
        //Acessa accordion
        menuPage.acessarAccordion();

        //Verifica se a tela contém todas as opções.
        Assert.assertTrue(accordionPage.verificaQtdElementos());

        //Acessa opção 1.
        accordionPage.acessaOpcaoUm();
        //Verifica texto da opção 1.
        Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.verificaTextoOpcaoUm());

        //Acessa opção 2.
        accordionPage.acessaOpcaoDois();
        //Verifica texto da opção 2.
        Assert.assertEquals("Esta é a descrição da opção 2", accordionPage.verificaTextoOpcaoDois());

        //Acessa opção 3.
        accordionPage.acessaOpcaoTres();
        //Verifica texto da opção 3.
        Assert.assertEquals("Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha", accordionPage.verificaTextoOpcaoTres());

        //Acessa opção 4.
        accordionPage.acessaOpcaoQuatro();
        //Verifica texto da opção 4.
        Assert.assertEquals("Esta é a descrição da opção 4", accordionPage.verificaTextoOpcaoQuatro());

        //Acessa opção 5.
        accordionPage.acessaOpcaoCinco();
        //Verifica texto da opção 5.
        Assert.assertEquals("Esta é a descrição da opção 5", accordionPage.verificaTextoOpcaoCinco());

        //Acessa opção 6.
        accordionPage.acessaOpcaoSeis();
        //Verifica texto da opção 6.
        Assert.assertEquals("Esta é a descrição da opção 6", accordionPage.verificaTextoOpcaoSeis());
    }
}
