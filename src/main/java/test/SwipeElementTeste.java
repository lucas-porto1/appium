package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.MenuPage;
import page.SwipeElementPage;

public class SwipeElementTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeElementPage swipeElementPage = new SwipeElementPage();

    @Test
    public void SwipeList() {
        //acessa swipeList.
        menuPage.acessarSwipeList();

        //opção 1 para a direita
        swipeElementPage.swipeElementRight("Opção 1");

        //clica no sinal -, que está dentro da opção 1.
        menuPage.clicarPorTexto("(-)");

        //Verifica que a opção 1 foi alterada.
        Assert.assertTrue(menuPage.existemElementosByText("Opção 1 (-)"));

        //Opção 4 para a direita.
        swipeElementPage.swipeElementRight("Opção 4");

        //clica no sinal -, que está dentro da opção 4.
        swipeElementPage.clicarPorTexto("(-)");

        //Verifica que a opção 4 foi alterada.
        Assert.assertTrue(menuPage.existemElementosByText("Opção 4 (-)"));

        //Opção 5 para a esquerda.
        swipeElementPage.swipeElementLeft("Opção 5 (-)");

        //Verifica que a opção 5 foi alterada.
        Assert.assertTrue(menuPage.existemElementosByText("Opção 5"));

    }
}
