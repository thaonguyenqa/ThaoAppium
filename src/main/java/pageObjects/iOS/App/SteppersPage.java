package pageObjects.iOS.App;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOS.IOSActions;


public class SteppersPage extends IOSActions {
    IOSDriver driver;
    public SteppersPage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeButton[`name == 'Increment'`]")
    private WebElement incrementButton;
    @iOSXCUITFindBy(xpath="(//XCUIElementTypeStaticText)[2]")
    private WebElement valueField;
    public WebElement getIncrementButton(){
        return incrementButton;
    }
    public String getIncrementValue(){
        longTap((RemoteWebElement)incrementButton);
        return valueField.getAttribute("value");
    }

}
