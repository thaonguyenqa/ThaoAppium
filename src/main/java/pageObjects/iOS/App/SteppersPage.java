package pageObjects.iOS.App;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SteppersPage {
    IOSDriver driver;
    public SteppersPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == 'Increment'`]")
    public WebElement incrementButton;
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText)[2]")
    public WebElement valueField;

}
