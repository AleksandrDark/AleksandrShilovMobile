package scenarios;

import static org.testng.Assert.assertTrue;

import java.util.Objects;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.DataProviders;

public class WebMobileTests extends BaseTest {

    @Test(groups = "web", dataProvider = "webTestData", dataProviderClass = DataProviders.class)
    public void checkWebPageTest(String url, String pageTitle, String searchText)
        throws NoSuchFieldException, IllegalAccessException {
        getDriver().get(url);

        new WebDriverWait(getDriver(), 25).until(
            webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState")
                .equals("complete")
        );
        assert ((WebDriver) getDriver()).getTitle().equals(pageTitle) : "This is not Google page";

        getPageObject().getElement("searchField").sendKeys(searchText, Keys.ENTER);

        assertTrue(getPageObject().getWebElements("searchResults").stream()
            .map(WebElement::getText)
            .filter(Objects::nonNull)
            .map(String::trim)
            .anyMatch(text -> text.toLowerCase().contains(searchText.toLowerCase())));
    }
}
