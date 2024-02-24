package Android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserBasicTest {
    public AndroidDriver driver;
    @BeforeClass
    public void AppiumTest() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("samsung SM-A125F");
        options.setChromedriverExecutable("/Users/thaonguyen/ThaoAppium/chromedriver");
        options.setCapability("browserName", "chrome");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
