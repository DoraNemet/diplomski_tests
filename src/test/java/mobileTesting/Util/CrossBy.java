package mobileTesting.Util;

import org.openqa.selenium.By;

import static mobileTesting.configuration.InitiateDevice.getPlatform;

public class CrossBy {

    /**
     * Id for IOS and ANDROID
     *
     * @param elementId    element id
     * @return
     */
    public static By id(String elementId) {
        return By.id(elementId);
        }

    /**
     * Id for IOS and ANDROID
     *
     * @param IOSId     IOS Id
     * @param androidId ANDROID id
     * @return
     */
    public static By id(String IOSId, String androidId) {
        switch (getPlatform()) {
            case IOS:
                return By.id(IOSId);
            case ANDROID:
                return By.id(androidId);
            default:
                return null;
        }
    }

    /**
     * Id for IOS and ANDROID
     *
     * @param IOSId     IOS Id
     * @param androidId ANDROID id
     * @return
     */
    public static By xpath(String IOSId, String androidId) {
        switch (getPlatform()) {
            case IOS:
                return By.xpath(IOSId);
            case ANDROID:
                return By.xpath(androidId);
            default:
                return null;
        }
    }

    /**
     * Id for IOS and ANDROID
     *
     * @param IOSId     IOS Id
     * @param androidBy ANDROID id
     * @return
     */
    public static By id(String IOSId,  By androidBy) {
        switch (getPlatform()) {
            case IOS:
                return By.xpath(IOSId);
            case ANDROID:
                return androidBy;
            default:
                return null;
        }
    }
}
