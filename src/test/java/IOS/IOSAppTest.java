package IOS;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSAppTest extends AppBasicTest {
    @Test
    public void longTapTest() throws InterruptedException {
        homePage.steppers.click();
        RemoteWebElement incIcon = (RemoteWebElement) steppersPage.incrementButton;
        longTap(incIcon);
        Thread.sleep(5000);
        String value = steppersPage.valueField.getAttribute("value");
        Assert.assertNotEquals(value, "0");
    }
    @Test
    public void scrollIntoElementTest() throws InterruptedException {
        RemoteWebElement el = (RemoteWebElement) homePage.webView;
        scrollIntoElement(el);
        Thread.sleep(5000);
        el.click();
    }

    @Test
    public void pickerWheelTest() throws InterruptedException {
        homePage.pickerView.click();
        pickerViewPage.redColorComponentValue.sendKeys("80");
        String val = pickerViewPage.redColorComponentValue.getText();
        Assert.assertEquals(val, "80");
    }

}
