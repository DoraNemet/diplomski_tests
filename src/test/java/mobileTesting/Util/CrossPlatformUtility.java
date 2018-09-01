package mobileTesting.Util;

import io.appium.java_client.TouchAction;
import mobileTesting.configuration.InitiateDevice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;

public abstract class CrossPlatformUtility extends InitiateDevice {

    /**
     * Thread sleep time interval
     *
     * @param durationInMilliseconds time interval in duration in milliseconds
     */
    public static void threadSleepMilisec(int durationInMilliseconds) {
        try {
            Thread.sleep(durationInMilliseconds);
        } catch (Exception e) {
            System.out.println("Can't sleep");
        }
    }

    /**
     * Hold test fot time interval
     *
     * @param durationInSec time interval in seconds
     */
    public static void threadSleep(int durationInSec) {
        threadSleepMilisec(durationInSec * 1000);
    }

    /**
     * Locate element
     *
     * @param identifier
     */
    public static void locateElement(By identifier) {
        switch (getPlatform()) {
            case IOS:
                new WebDriverWait(getIOSDriver(), normalTimeInterval).until(ExpectedConditions.visibilityOfElementLocated(identifier));
                getIOSDriver().findElement(identifier);
                break;
            case Android:
                WebElement e = getElement(identifier);
                if (e != null) {
                    return;
                }
                throw new UnhandledAlertException("Unable to find element");
        }
    }


    /**
     * Check if element is displayed
     *
     * @param identifier
     * @return
     */
    public static boolean isDisplayed(By identifier) {
        return getElement(identifier).isDisplayed();
    }

    /**
     * * Locate element and click on it
     *
     * @param identifier
     */
    public static void locateElementClick(By identifier) {
        getElement(identifier).click();
    }

    /**
     * * Locate element and send value
     *
     * @param identifier
     * @param sendValue
     */
    public static void locateElementSendKeys(By identifier, String sendValue) {
        getElement(identifier).sendKeys(sendValue);
    }

    /**
     * Get elements text
     *
     * @param identifier
     */
    public static String getItemText(By identifier) {
        WebElement e = getElement(identifier);
        if (e == null) {
            throw new UnhandledAlertException("Unable to find element");
        }
        return e.getText();
    }

    /**
     * Verifies that element contains text
     *
     * @param identifier
     * @param text
     */
    public static void verifyElementContainsText(By identifier, String text) {
        if (!getItemText(identifier).contains(text)) {
            failTest("Element does not contains text.");
        }
    }

    /**
     * Click if element is available and click on it
     *
     * @param clickIdentifier
     */
    public static void tryCatchClick(By clickIdentifier) {
        tryCatchClick(clickIdentifier, clickIdentifier);
    }

    /**
     * Click on element if element is available and click on other element
     *
     * @param locateIdentifier
     * @param clickIdentifier
     */
    public static void tryCatchClick(By locateIdentifier, By clickIdentifier) {
        if (isPresent(locateIdentifier)) {
            locateElementClick(clickIdentifier);
        }
    }

    /**
     * Swipe the element to the left
     *
     * @param identifier
     */
    public static void swipeElementToLeft(By identifier) {
        TouchAction swipe = new TouchAction(null);
        switch (getPlatform()) {
            case IOS:
                swipe = new TouchAction(getIOSDriver());
                break;
            case Android:
                swipe = new TouchAction(getAndroidDriver());
                break;
        }
        WebElement element = getElement(identifier);
        int leftX = element.getLocation().getX();
        int upperY = element.getLocation().getY();
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        swipe.press((int) (leftX + (elementWidth * 0.8)), (int) (upperY + elementHeight * 0.1)).moveTo((int) (elementWidth * 0.8) * -1, 0).release().perform();
    }

    /**
     * Check if element is present
     *
     * @param identifier
     * @return
     */
    public static Boolean isPresent(By identifier) {
        try {
            locateElement(identifier);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get element by identifier
     *
     * @param identifier
     * @return
     */
    public static WebElement getElement(By identifier) {
        switch (getPlatform()) {
            case IOS:
                new WebDriverWait(getIOSDriver(), normalTimeInterval).until(ExpectedConditions.visibilityOfElementLocated(identifier));
                return getIOSDriver().findElement(identifier);
            case Android:
                new WebDriverWait(getAndroidDriver(), normalTimeInterval).until(ExpectedConditions.visibilityOfElementLocated(identifier));
                return getAndroidDriver().findElement(identifier);
        }
        return null;
    }

    /**
     * Fail the test and trow a message
     *
     * @param message
     */
    public static void failTest(String message) {
        System.out.println(message);
        Assert.assertTrue(false);
    }

    /**
     * Skip the test
     *
     * @param message
     */
    public static void skipTest(String message) {
        throw new SkipException("Test skipped");
    }
}