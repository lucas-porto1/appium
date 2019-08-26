package page;

import core.BasePage;
import core.DriverFactory;
import org.openqa.selenium.By;

import java.util.Set;

public class WebViewPage extends BasePage {

    /**
     * Vai sair do contexto de aplicação para ir para o web.
     */

    public void entrarContextoWeb(){
        Set<String> contextHandles = DriverFactory.getDriver().getContextHandles();
        for(String valor: contextHandles){
            System.out.println(valor);
        }

        DriverFactory.getDriver().context((String) contextHandles.toArray()[1]);

    }

    public void sairContextoWeb(){
        DriverFactory.getDriver().context((String)DriverFactory.getDriver().getContextHandles().toArray()[0]);
    }

    public void setEmail(String valor){
        DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
    }
}
