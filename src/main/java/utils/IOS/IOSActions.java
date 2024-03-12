package utils.IOS;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class IOSActions {
    IOSDriver driver;
    public IOSActions(IOSDriver driver){
        this.driver = driver;
    }

    public void longTap(RemoteWebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("duration", 2.0);
        params.put("element", ((RemoteWebElement) ele).getId());
        js.executeScript("mobile: touchAndHold", params);

    }
    public void scrollIntoElement(RemoteWebElement ele){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement) ele).getId());
        params.put("direction", "down");
        js.executeScript("mobile: scroll", params);


    }
}
