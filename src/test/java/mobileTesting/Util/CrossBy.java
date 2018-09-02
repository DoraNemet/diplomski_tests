package mobileTesting.Util;

import org.openqa.selenium.By;

import static mobileTesting.configuration.InitiateDevice.getPlatform;

public class CrossBy {

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
}
