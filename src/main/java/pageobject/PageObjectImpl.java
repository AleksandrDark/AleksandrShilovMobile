package pageobject;

import java.util.List;
import org.openqa.selenium.WebElement;

public interface PageObjectImpl {

    WebElement getElement(String name) throws NoSuchFieldException, IllegalAccessException;

    List<WebElement> getWebElements(String elementsName) throws NoSuchFieldException,
        IllegalAccessException;

}
