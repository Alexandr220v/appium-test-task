package steps_definitions;

import config.AppiumServer;
import config.Config;
import config.DriverFactoryManager;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final Logger LOGGER = Logger.getLogger(Hooks.class.getName());
    private DriverFactoryManager driverFactoryManager;

    private Config config = new Config();
    protected static AppiumDriver appiumDriver;

    private static AppiumServer appiumServer = new AppiumServer();

    public AppiumDriver getDriver() {
        return appiumDriver;
    }
    @SneakyThrows
    @Before
    public void init() {
        driverFactoryManager = new DriverFactoryManager(config.getUrl(), config.getCapabilities());
        appiumDriver = driverFactoryManager.createDriver();

        LOGGER.info("Appium driver initialization...");
    }

    @After
    public void quit(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) appiumDriver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
        if (appiumDriver != null) {
            appiumDriver.quit();
        }
        LOGGER.info("Appium driver quit.");
    }

    @BeforeClass
    public  static void tearUp() throws Exception {
        appiumServer.startServer();

    }

    @SneakyThrows
    @AfterClass
    public static void tearDown() {
        if (appiumServer!=null) {
            appiumServer.stopServer();
        }
    }
}
