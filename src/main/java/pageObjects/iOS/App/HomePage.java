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
