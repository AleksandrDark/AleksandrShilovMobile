package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;
import setup.DataProviders;

public class NativeMobileTests extends BaseTest {

    @Test(groups = "native", dataProvider = "nativeTestData", dataProviderClass = DataProviders.class)
    public void checkRegistrationAndLoginTest(String email, String username, String password, String pageTitle)
        throws NoSuchFieldException, IllegalAccessException {

        getPageObject().getElement("registerButton").click();
        getPageObject().getElement("registerEmail").sendKeys(email);
        getPageObject().getElement("registerUsername").sendKeys(username);
        getPageObject().getElement("registerPassword").sendKeys(password);
        getPageObject().getElement("confirmPassword").sendKeys(password);
        getPageObject().getElement("checkBoxAgreements").click();
        getPageObject().getElement("registerNewAccountButton").click();

        getPageObject().getElement("loginUserNameOrEmail").sendKeys(email);
        getPageObject().getElement("loginPassword").sendKeys(password);
        getPageObject().getElement("signInButton").click();

        Assert.assertEquals(getPageObject().getElement("titleRegisterPage").getText(), pageTitle);
    }
}
