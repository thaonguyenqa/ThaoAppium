package Android;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AndroidBrowserTest extends BrowserBasicTest{
    @Test
    public void FirstTest() throws InterruptedException {
        driver.get("http://appium.io/docs/en/latest/");
        Thread.sleep(1000);
    }
    @Test
    public void verifyLoginFormWithValidCreds() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login//");
        driver.findElement(AppiumBy.id("username")).sendKeys("student");
        driver.findElement(AppiumBy.id("password")).sendKeys("Password123");
        driver.findElement(AppiumBy.id("submit")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(AppiumBy.className("post-title")).getText(),"Logged In Successfully");
        Thread.sleep(1000);
    }
    @Test
    public void verifyLoginFormWithInvalidCreds() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(AppiumBy.id("username")).sendKeys("Student");
        driver.findElement(AppiumBy.id("password")).sendKeys("Password123");
        driver.findElement(AppiumBy.id("submit")).click();
        Assert.assertTrue(driver.findElement(AppiumBy.id("error")).isDisplayed());
        Thread.sleep(1000);
    }

}
