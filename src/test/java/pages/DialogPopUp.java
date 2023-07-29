package pages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import steps_definitions.Hooks;


public class DialogPopUp extends BasePage {

    @AndroidFindBy(id = "android:id/message")
    private MobileElement message;


    public DialogPopUp() {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public String getErrorMessage() {
        return message.getText();
    }


}
