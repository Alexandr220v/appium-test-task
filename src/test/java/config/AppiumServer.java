package config;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Appium server abstraction.
 */
public class AppiumServer {
    private static final Logger LOGGER = Logger.getLogger(AppiumServer.class.getName());
    public AppiumDriverLocalService service;
    public AppiumServiceBuilder builder;

    public void startServer() throws Exception {

        // Build the Appium Service
        builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));
        builder.withIPAddress("127.0.0.1");
        builder.usingPort(4723);
        //builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "debug");

        try {

            service = AppiumDriverLocalService.buildService(builder);
            service.start();
            LOGGER.info("Starting appium server...");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public void stopServer() throws Exception {


        try {

            service.stop();
            LOGGER.info("Stoping appium server...");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

}
