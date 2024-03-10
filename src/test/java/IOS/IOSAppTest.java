package IOS;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.iOS.App.PickerViewPage;
import pageObjects.iOS.App.SteppersPage;

public class IOSAppTest extends AppBasicTest {
    @Test
    public void longTapTest() throws InterruptedException {
        SteppersPage steppersPage = homePage.selectSteppers();
        RemoteWebElement incIcon = (RemoteWebElement) steppersPage.incrementButton;
        longTap(incIcon);
        Thread.sleep(5000);
        String value = steppersPage.valueField.getAttribute("value");
        Assert.assertNotEquals(value, "0");
    }
    @Test
    public void scrollIntoElementTest() throws InterruptedException {
        RemoteWebElement el = (RemoteWebElement) homePage.getWebViewElement();
        scrollIntoElement(el);
        Thread.sleep(5000);
        el.click();
    }

    @Test
    public void pickerWheelTest() throws InterruptedException {
        PickerViewPage pickerViewPage = homePage.selectPickerView();
        pickerViewPage.redColorComponentValue.sendKeys("80");
        String val = pickerViewPage.redColorComponentValue.getText();
        Assert.assertEquals(val, "80");
    }

}
