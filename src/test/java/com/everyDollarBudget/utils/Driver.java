package com.everyDollarBudget.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {

    private static AppiumDriver<MobileElement> driver;

    private Driver() {
    }

    /**
     * Method creates the Driver instance within a singleton design.
     *
     * @return
     */
    public static AppiumDriver<MobileElement> getDriver() {

        if (Objects.isNull(driver)) {
            // to run in Jenkins: execute shells :
            // Run Appium in background first with one shell command:
                /* set -ex
                    export PATH="SPATH:"paste-nodeJS-path-(bin-folder)-from-EC2-machine"
                    copy-Appium-app-path-(bin/appium-folder)-from-EC2-machine --base-path /wd/hub > appium.log 2>&1
                 */
            // Next run build step:
                /*
                    set -ex
                    export PATH="SPATH:"copy-Appium-app-path-(bin-folder)-from-EC2-machine" "path-of-script-from-machine"

                 */
            //Caps for native app (everyDollarApp / Pixel 7 PRO emulator)
//                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
//                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
//                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
//                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
//                    desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");
//                    //desiredCapabilities.setCapability(MobileCapabilityType.NO_RESET, true);
//                    desiredCapabilities.setCapability("appPackage", "com.everydollar.android");
//                    desiredCapabilities.setCapability("appActivity", "crc64e89ea541bcc9feb1.MainActivity");
//                    desiredCapabilities.setCapability("unicodeKeyboard", "true");
//                    desiredCapabilities.setCapability("resetKeyboard", "true");
//                    desiredCapabilities.setCapability("autoAcceptAlerts", "false");

            try {
                driver = new AndroidDriver<>(new URL(ConfigurationReader.getProperty("appium.server.ip")), CapabsReader.getCapabilities());
                //driver.resetApp();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    /**
     * Method closes the driver instance within a simple singleton design.
     */
    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.quit();
            driver = null;
        }
    }
}


