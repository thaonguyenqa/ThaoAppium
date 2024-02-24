package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppBasicTest {
    public IOSDriver driver;
    @BeforeClass
    public void AppiumTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setApp("/Users/thaonguyen/ThaoAppium/src/test/java/resources/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void longTap(RemoteWebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 2.0);
        params.put("element", ((RemoteWebElement) ele).getId());
        js.executeScript("mobile: touchAndHold", params);

    }


}