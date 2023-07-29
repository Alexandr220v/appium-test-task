package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import steps_definitions.Hooks;

import java.util.List;
import java.util.stream.Collectors;


public class NativeViewDemoPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[text()='Back']")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Native View Demo')]")
    private MobileElement nativeViewDemoLabel;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='textView']")
    private List<MobileElement> nativeViewDemoList;

    public NativeViewDemoPage() {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public List<String> getNativeViewDemoList() {
        return nativeViewDemoList.stream().map(RemoteWebElement::getText).collect(Collectors.toList());
    }
    public String getNativeViewTitle() {
       return nativeViewDemoLabel.getText();
    }


}
