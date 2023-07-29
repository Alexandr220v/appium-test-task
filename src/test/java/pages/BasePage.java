package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public abstract class BasePage extends MobileElement {

    protected AppiumDriver  driver;


    public    void scrollDown() {
        Dimension size = driver.manage().window().getSize();

        //Starting y location set to 80% of the height (near bottom)
        int starty = (int) (size.height * 0.80);
        //Ending y location set to 20% of the height (near top)
        int endy = (int) (size.height * 0.20);
        //x position set to mid-screen horizontally
        int startx = size.width / 2;

        new TouchAction(driver)
                .longPress(new PointOption<>().withCoordinates(startx,starty))
                .moveTo(new PointOption<>().withCoordinates(startx,endy))
                .release().perform();

    }


}