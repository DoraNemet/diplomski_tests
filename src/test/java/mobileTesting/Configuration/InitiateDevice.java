package mobileTesting.Configuration;

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

    public enum Platform {IOS, Android}
    private static Platform platform = Platform.Android;

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
                System.out.println("IOS driver initialized successfully.");
                break;

            case Android:
                capabilities.setCapability("deviceName", "Galaxy S6");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "7.0");
                capabilities.setCapability("automationName", "Appium");

                capabilities.setCapability("appPackage", "com.example.dorafundak.multitask");
                capabilities.setCapability("appActivity", "MainActivity");

                androidDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                System.out.println("Android driver initialized successfully.");
                break;
        }
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {

        if (androidDriver != null) {
            androidDriver.quit();
            System.out.println("Android driver quit.");
        }

        if (iosDriver != null) {
            iosDriver.quit();
            System.out.println("IOS driver quit.");
        }
    }

    public static IOSDriver getIOSDriver() {
        if (!platform.equals(Platform.IOS))
            throw new SkipException("Can't use Android driver on a IOS platform");
        return iosDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        if (!platform.equals(Platform.Android))
            throw new SkipException("Can't use IOS driver on an Android platform");
        return androidDriver;
    }
}
