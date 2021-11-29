package setup;

import com.google.gson.Gson;
import entities.NativeData;
import entities.WebData;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "nativeTestData")
    public static Object[][] nativeDataProvider() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/nativeTestData.json");
        NativeData nativeData = new Gson().fromJson(reader, NativeData.class);
        return new Object[][]{
            {nativeData.getEmail(), nativeData.getUsername(), nativeData.getPassword(), nativeData.getPageTitle()}
        };
    }

    @DataProvider(name = "webTestData")
    public static Object[][] webDataProvider() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/webTestData.json");
        WebData webData = new Gson().fromJson(reader, WebData.class);
        return new Object[][]{
            {webData.getURL(), webData.getPageTitle(), webData.getSearchText()}
        };
    }
}
