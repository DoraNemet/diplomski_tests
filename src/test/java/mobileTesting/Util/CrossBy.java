package mobileTesting.Util;

import org.openqa.selenium.By;

import static mobileTesting.configuration.InitiateDevice.getPlatform;

public class CrossBy {

    /**
     * Id for IOS and Android
     *
     * @param IOSId     IOS Id
     * @param androidId Android id
     * @return
     */
    public static By id(String IOSId, String androidId) {
        switch (getPlatform()) {
            case IOS:
                return By.id(IOSId);
            case Android:
                return By.id(androidId);
            default:
                return null;
        }
    }
}
