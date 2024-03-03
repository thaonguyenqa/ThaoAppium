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
    @Test
    public void scrollIntoElementTest() throws InterruptedException {
        RemoteWebElement el = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId("Web View"));
        scrollIntoElement(el);
        Thread.sleep(5000);
        el.click();
    }
    @Test
    public void pickerWheelTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        String val = driver.findElement(AppiumBy.accessibilityId("Red color component value")).getText();
        Assert.assertEquals(val, "80");
    }

}
