package pageobject;

import io.appium.java_client.AppiumDriver;
import java.lang.reflect.Field;
import java.util.List;
import org.openqa.selenium.WebElement;

public class PageObject implements PageObjectImpl {

    Object somePageObject;

    public  PageObject(String appType, AppiumDriver<? extends WebElement>  appiumDriver) throws Exception {

        switch (appType){
            case "web":
                somePageObject = new WebPageObject(appiumDriver);
                break;
            case "native":
                somePageObject = new NativePage(appiumDriver);
                break;
            default: throw new Exception("Can't create page object for: " + appType);
        }
    }
    @Override
    public WebElement getElement(String name) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return (WebElement) field.get(somePageObject);
    }

    @Override
    public List<WebElement> getWebElements(String names) throws NoSuchFieldException, IllegalAccessException {
        Field field = somePageObject.getClass().getDeclaredField(names);
        field.setAccessible(true);
        return (List<WebElement>) field.get(somePageObject);
    }
}
