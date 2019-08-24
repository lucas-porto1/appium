package test;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import page.MenuPage;
import page.SplashPage;

/**
 * O Splash é uma activity simples que ao entrar, terá um tempo de retorno automático.
 * O método irá validar o sincronismo dos elementos que aparecem e desaparecem da tela.
 *
 * @author Lucas Porto Gomes
 */

public class SplashTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Test
    public void aguardarSplashSumir() {
        //Acessar menu splash
        menuPage.acessarSplash();

        //Verificar o splash que está sendo exibido.
        Assert.assertTrue(splashPage.splashVisivel());


        //Aguardar saída do splash.
        splashPage.aguardarSplashSumir();

        //Verificar se voltou ao menu principal.
        Assert.assertTrue(menuPage.existeElemento(By.xpath("//*[@text='Formulário']")));

    }
}
