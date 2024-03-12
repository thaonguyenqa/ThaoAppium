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
//        RemoteWebElement incIcon = (RemoteWebElement) steppersPage.getIncrementButton();
//        longTap(incIcon);
        Thread.sleep(5000);
        String value = steppersPage.getIncrementValue();
        Assert.assertNotEquals(value, "0");
    }
    @Test
    public void scrollIntoElementTest() throws InterruptedException {
        homePage.selectWebView();
    }

    @Test
    public void pickerWheelTest() throws InterruptedException {
        PickerViewPage pickerViewPage = homePage.selectPickerView();
        pickerViewPage.setRedColorComponentValue("80");
        String val = pickerViewPage.getRedColorComponentValue();
        Assert.assertEquals(val, "80");
    }

}
