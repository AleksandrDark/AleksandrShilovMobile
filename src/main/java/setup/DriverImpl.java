package setup;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.WebElement;

public interface DriverImpl {

    MobileDriver<? extends WebElement> getDriver();

}
