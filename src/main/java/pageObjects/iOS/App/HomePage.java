package pageObjects.iOS.App;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOS.IOSActions;

public class HomePage extends IOSActions {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @iOSXCUITFindBy(accessibility="Picker View")
    private WebElement pickerView;
    @iOSXCUITFindBy(accessibility="Web View")
    private WebElement webView;
    @iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`name == 'Steppers'`]")
    private WebElement steppers;
    public PickerViewPage selectPickerView(){
        pickerView.click();
        return new PickerViewPage(driver);
    }
    public void selectWebView(){
        scrollIntoElement((RemoteWebElement) webView);
        webView.click();
    }
    public WebElement getWebViewElement(){
        return webView;
    }

    public SteppersPage selectSteppers(){
        steppers.click();
        return new SteppersPage(driver);
    }

}
