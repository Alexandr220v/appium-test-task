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
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static jdk.jfr.internal.SecuritySupport.getResourceAsStream;

/**
 * Appium server abstraction.
 */
public class DriverFactoryManager {

    private static final Logger LOGGER = Logger.getLogger(DriverFactoryManager.class.getName());
    private Config config = new Config();
    private final URL url;
    private final DesiredCapabilities capabilities;

    public DriverFactoryManager(String url, Map<String, Object> capabilities) throws MalformedURLException {
        this.url = new URL(url);
        this.capabilities = new DesiredCapabilities(capabilities);
    }


    public  AppiumDriver createDriver() {
        String platform = config.getPlatform().toUpperCase();

        switch (platform) {
            case "ANDROID":
                return new AndroidDriver(url, capabilities);
            case "IOS":
                return new IOSDriver<MobileElement>(url, capabilities);
            default:
                throw new IllegalArgumentException(
                        String.format("Driver Factory type not implemented: [%s]", platform));
        }
    }





}
