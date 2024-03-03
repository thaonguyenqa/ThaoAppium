package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BrowserBasicTest {
    public IOSDriver driver;
    @BeforeTest
    public void AppiumTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setCapability("browserName", "safari");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
