package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;



import java.util.List;

import static core.DriverFactory.*;

public class DragAndDropPage extends BasePage {

    public void arrastar(String origem, String destino) {
        MobileElement inicio = (MobileElement) getDriver().findElement(By.xpath("//*[@text='" + origem + "']"));
        MobileElement fim = (MobileElement) getDriver().findElement(By.xpath("//*[@text='" + destino + "']"));

        TouchAction action = new TouchAction(DriverFactory.getDriver());
        action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(inicio)))
                .moveTo(ElementOption.element(fim))
                .release()
                .perform();
    }

    public String[] obterLista() {
       List<MobileElement> elements = getDriver().findElements(By.className("android.widget.TextView"));
       String [] retorno = new String[elements.size()];

       for(int i = 0; i<elements.size();i++){
           retorno[i] = elements.get(i).getText();
         //  System.out.println("\""+retorno[i]+"\",");
       }
       return retorno;
    }


}
