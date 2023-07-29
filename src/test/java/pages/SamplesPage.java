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


public class SamplesPage extends BasePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[text()='Back']")
    private MobileElement backButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Samples List')]")
    private MobileElement samplesListLabel;

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc='scrollView']//android.widget.TextView[1]")
    private List<MobileElement> samplesList;




    public SamplesPage() {
        this.driver = new Hooks().getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(this.driver),this);
    }


    public String getSamplesListLabel() {
       return samplesListLabel.getText();
    }


    public List<String> getSamplesListItems() {
        return samplesList.stream().map(RemoteWebElement::getText).collect(Collectors.toList());
    }

    public <T> T openSamplesListItem(String item) {
        samplesList.stream().filter(name -> name.getText().equals(item))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("There are no item on page"))
                .click();
        return  (T) (driver);
    }

}
