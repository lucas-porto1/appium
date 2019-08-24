package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.AbasPage;
import page.MenuPage;

/**
 * A activity Abas contém duas abas com textos diferentes.
 * O método irá validar o funcionamento de cada aba.
 *
 * @author Lucas Porto Gomes
 */

public class AbasTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();


    @Test
    public void testeAbas() {
        //acessa menu abas
        menuPage.acessarAbas();

        //verifica texto da aba 1.
        Assert.assertEquals("Este é o conteúdo da Aba 1", abasPage.obterTextoAbaUm());

        //acessa aba 2.
        abasPage.acessaAbaDois();

        //verifica texto da aba 2.
        Assert.assertEquals("Este é o conteúdo da Aba 2", abasPage.obterTextoAbaDois());

    }
}
