package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {
        new TouchAction(DriverFactory.getDriver())
                .longPress(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))).perform();
    }

    public String obterMensagemClique() {
        return obterTexto(By.xpath(("(//android.widget.TextView)[3]")));
    }

    public void duploClique() {
        clicarPorTexto("Clique duplo");
        clicarPorTexto("Clique duplo");
    }

}
