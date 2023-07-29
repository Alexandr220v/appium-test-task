package pages;


import dto.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import steps_definitions.Hooks;


public class LoginPage extends BasePage {
    @AndroidFindBy(accessibility = "username")
    private MobileElement username;

    @AndroidFindBy(accessibility = "password")
    private MobileElement password;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='login']/android.widget.Button")
    private MobileElement loginButton;

    public LoginPage() {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }

    public SamplesPage login(User credentials) {
        inputUsername(credentials.getUsername());
        inputPassword(credentials.getPassword());
        clickLogIn();
        return new SamplesPage();
    }

    public void inputUsername(String login) {
        if (login.equals("empty")) {
            username.clear();
        } else username.setValue(login);
    }

    public void inputPassword(String pass) {
        if (pass.equals("empty")) {
            password.clear();
        } else password.setValue(pass);
    }

    public void clickLogIn() {
        loginButton.click();
    }


}
