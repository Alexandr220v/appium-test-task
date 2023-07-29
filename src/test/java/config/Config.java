package config;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.SneakyThrows;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Config {

    private static String platform = System.getProperty("platformName");
    private static String deviceName = System.getProperty("device");
    public  String url;

    private Map<String, Object> desiredCapabilities;

    File root = new File(System.getProperty("user.dir"));
    File app = new File(root, "src/test/resources/apps/VodQA.apk");


    public Map<String, Object> getAndroidCapabilities() throws Exception {

        // apk Capabilities
        desiredCapabilities = new HashMap<>();
        desiredCapabilities.put("platformName", platform);
        desiredCapabilities.put("automationName", "UiAutomator2");
        desiredCapabilities.put("deviceName", deviceName);
        desiredCapabilities.put("app", app.getAbsolutePath());
        desiredCapabilities.put("appPackage", "com.vodqareactnative");
        desiredCapabilities.put("appActivity", "MainActivity");

        return desiredCapabilities;
    }

    //will be added capabilities for IOS

    String getPlatform() {
        return platform;
    }

    public String getUrl() {
        return  "http://127.0.0.1:4723/wd/hub";
    }

    @SneakyThrows
    public Map<String, Object> getCapabilities() {
        switch (platform) {
            case "ANDROID":
                return getAndroidCapabilities();
            case "IOS":
                //todo return getIosCapabilities();

            default:
                throw new IllegalArgumentException(
                        String.format("Capabilities is not setup for platform: [%s]", platform));
        }
    }
}
