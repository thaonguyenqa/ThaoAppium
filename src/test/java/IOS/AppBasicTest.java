package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.iOS.App.HomePage;
import pageObjects.iOS.App.PickerViewPage;
import pageObjects.iOS.App.SteppersPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AppBasicTest {
    public IOSDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void AppiumTest() throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setApp("/Users/thaonguyen/ThaoAppium/src/test/java/resources/UIKitCatalog.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        homePage = new HomePage(driver);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }




}
