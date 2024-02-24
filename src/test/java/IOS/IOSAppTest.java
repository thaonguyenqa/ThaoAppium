package IOS;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSAppTest extends AppBasicTest {
    @Test
    public void longTapTest() throws InterruptedException {
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Steppers'`]")).click();
        RemoteWebElement incIcon = (RemoteWebElement) driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`]"));
        longTap(incIcon);
        Thread.sleep(5000);
        String value = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeStaticText)[2]")).getAttribute("value");
        Assert.assertNotEquals(value, "0");
    }

}
