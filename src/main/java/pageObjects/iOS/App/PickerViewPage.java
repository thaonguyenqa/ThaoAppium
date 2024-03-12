package pageObjects.iOS.App;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PickerViewPage {
    IOSDriver driver;
    public PickerViewPage(IOSDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility="Red color component value")
    private WebElement redColorComponentValue;
    public void setRedColorComponentValue(String val){
        redColorComponentValue.sendKeys(val);
    }
    public String getRedColorComponentValue(){
        return redColorComponentValue.getText();
    }

}
