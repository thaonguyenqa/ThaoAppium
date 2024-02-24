package Android;

import org.testng.annotations.Test;

public class AndroidBrowserTest extends BrowserBasicTest{
    @Test
    public void FirstTest() throws InterruptedException {
        driver.get("http://appium.io/docs/en/latest/");
        Thread.sleep(1000);
    }

}
