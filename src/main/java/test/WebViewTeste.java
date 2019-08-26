package test;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import page.MenuPage;
import page.WebViewPage;



public class WebViewTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private WebViewPage webViewPage = new WebViewPage();

    @Test
    public void deveFazerLogin(){
        //acessar o menu.
        menuPage.acessarSBHibrido();
        menuPage.esperar(4000);
      //  webViewPage.entrarContextoWeb();

        //preencher email.

      //  webViewPage.setEmail("lucas-porto1@hotmail.com");


    }
}
