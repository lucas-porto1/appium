package page;

import core.BasePage;
import core.DriverFactory;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SwipeElementPage extends BasePage {

    public void swipeElementLeft(String opcao) {
        swipeElement((MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
    }

    public void swipeElementRight(String opcao) {
        swipeElement((MobileElement) DriverFactory.getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
    }

}
