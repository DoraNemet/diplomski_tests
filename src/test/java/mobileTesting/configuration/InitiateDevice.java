package mobileTesting.configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;

public abstract class InitiateDevice {

    private static AndroidDriver androidDriver;
    private static IOSDriver iosDriver;
    public static int zeroTimeInterval, shortTimeInterval, normalTimeInterval, longTimeInterval;
    public enum Platform {IOS, ANDROID}
    private static Platform platform = Platform.IOS;

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("clearSystemFiles", "true");
        capabilities.setCapability("newCommandTimeout", "200");
        capabilities.setCapability("useNewWDA", true);
        capabilities.setCapability("wdaStartupRetryInterval", "1000");

        switch (platform) {
            case IOS:

                capabilities.setCapability("deviceName", "iPhone 8");
                capabilities.setCapability("udid", "ebd4d4bf9bbae04a6a0d8663fa0ae4df8403a259");
                capabilities.setCapability("platformName", "iOS");
                capabilities.setCapability("platformVersion", "11.4.1");
                capabilities.setCapability("automationName", "XCUITest");

                capabilities.setCapability("bundleId", "dfundak.MultiTask");

                iosDriver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;

            case ANDROID:
                capabilities.setCapability("deviceName", "Galaxy S6");
                capabilities.setCapability("platformName", "ANDROID");
                capabilities.setCapability("platformVersion", "7.0");
                capabilities.setCapability("automationName", "Appium");

                capabilities.setCapability("appPackage", "com.example.dorafundak.multitask");
                capabilities.setCapability("appActivity", "MainActivity");

                androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                System.out.println("ANDROID driver initialized successfully.");
                break;
        }
        // timeout intervals
        zeroTimeInterval = 0;
        shortTimeInterval = 5;
        normalTimeInterval = 10;
        longTimeInterval = 60;
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {

        if (androidDriver != null) {
            androidDriver.quit();
        }

        if (iosDriver != null) {
            iosDriver.quit();
        }
    }

    public static IOSDriver getIOSDriver() {
        if (!platform.equals(Platform.IOS))
            throw new SkipException("Can't use ANDROID driver on a IOS platform");
        return iosDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        if (!platform.equals(Platform.ANDROID))
            throw new SkipException("Can't use IOS driver on an ANDROID platform");
        return androidDriver;
    }

    public static Platform getPlatform() {
        return platform;
    }
}
