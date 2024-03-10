package Android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidAppTest extends BasicTest{
    @Test
    public void FirstTest() {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
    }
    @Test
    public void HandlePopupTest(){
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("This is a text");
        // Note: findElements by index
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

    }
    @Test
    public void LongPressTest(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        // https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
        RemoteWebElement ppNames = (RemoteWebElement)driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='People Names']"));
        longPressElement(ppNames);
        String menuText = driver.findElement(AppiumBy.id("android:id/title")).getText();
        Assert.assertEquals(menuText, "Sample menu");

    }
    @Test
    public void scrollIntoViewTest() {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"WebView\"))")).click();
    }

    @Test
    public void swipeTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='1. Photos']")).click();
        RemoteWebElement firstImage = (RemoteWebElement)driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        // Note: Should not use firstImage to get attribute focusable because after swiping, it is not present in the DOM
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"true");
        swipeGesture(firstImage, "left");
        Assert.assertEquals(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).getAttribute("focusable"),"false");
    }
    @Test
    public void dragAndDropTeset() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        RemoteWebElement source = (RemoteWebElement)driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
        dragGesture(source);
        Thread.sleep(3000);
        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result, "Dropped!");
        driver.pressKey(new KeyEvent(AndroidKey.HOME));
    }

    @Test
    public void androidKeyTest() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(AppiumBy.id("android:id/checkbox")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).click();
        String alertTitle = driver.findElement(AppiumBy.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertTitle, "WiFi settings");
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1));
    }
    @Test
    public void handleAlertsTestWithAcceptMethod() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        driver.switchTo().alert().accept();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).isDisplayed();
    }
    @Test
    public void handleAlertsTestWithDismissMethod() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("App")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
        driver.switchTo().alert().dismiss();
        driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).isDisplayed();
    }


}
