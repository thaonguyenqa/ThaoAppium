package pageObjects.iOS.App;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility="Picker View")
    public WebElement pickerView;
    @iOSXCUITFindBy(accessibility="Web View")
    public WebElement webView;
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == 'Steppers'`]")
    public WebElement steppers;
}
