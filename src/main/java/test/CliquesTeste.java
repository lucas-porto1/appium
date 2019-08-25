package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.CliquesPage;
import page.MenuPage;

public class CliquesTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Test
    public void cliqueLongo() {
        //acessar menu
        menuPage.acessarCliques();

        //clique longo
        cliquesPage.cliqueLongo();

        //verificar Texto
        Assert.assertTrue(cliquesPage.obterMensagemClique().equals("Clique Longo"));

    }

    @Test
    public void cliqueDuplo() {
        //acessar menu
        menuPage.acessarCliques();

        //clique duplo.
        cliquesPage.duploClique();

        //verificar Texto
        Assert.assertEquals("Duplo Clique", cliquesPage.obterMensagemClique());

    }
}
