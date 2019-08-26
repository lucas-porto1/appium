package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import page.DragAndDropPage;
import page.MenuPage;
public class DragAndDropTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private DragAndDropPage dragAndDropPage = new DragAndDropPage();


    private String[] estadoInicial = new String[]{"Esta","é uma lista","Drag em Drop!","Faça um clique longo,","e arraste para","qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista","Drag em Drop!","Faça um clique longo,","e arraste para","Esta","qualquer local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,","é uma lista","Drag em Drop!","e arraste para","Esta","qualquer local desejado."};

    @Test
    public void efetuaDragAndDrop() {
        //acessa menu
        menuPage.acessarDragAndDrop();

        //verifica estado inicial
        menuPage.esperar(1000);
        Assert.assertArrayEquals(estadoInicial, dragAndDropPage.obterLista());


        //arrasta item "esta" para a quarta posição.
        dragAndDropPage.arrastar("Esta", "e arraste para");

        //verifica estado
        Assert.assertArrayEquals(estadoIntermediario,dragAndDropPage.obterLista());

        //arrasta item "faça um clique longo." para a primeira posição.
        dragAndDropPage.arrastar("Faça um clique longo,", "é uma lista");

        //verifica estado.
        Assert.assertArrayEquals(estadoFinal,dragAndDropPage.obterLista());

    }

}
