package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.MenuPage;

public class SwipeTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void realizaSwipe() {
        //acessar menu
        menuPage.acessarSwipe();

        //verificar texto
        Assert.assertTrue(menuPage.existemElementosByText("a esquerda"));

        //swipe para direita.
        menuPage.swipeRight();
        menuPage.esperar(1000);
        //verificar texto.
        Assert.assertTrue(menuPage.existemElementosByText("E veja se"));

        //clicar botão para direita.
        menuPage.clicarPorTexto("›");
        menuPage.esperar(1000);
        //verificar texto.
        Assert.assertTrue(menuPage.existemElementosByText("Chegar até o fim!"));

        //swipe esquerda.
        menuPage.swipeLeft();
        menuPage.esperar(1000);
        //clicar botão para esquerda.
        menuPage.clicarPorTexto("‹");

        //verificar texto.
        Assert.assertTrue(menuPage.existemElementosByText("a esquerda"));
    }
}
