package mobileTesting.tests;

import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Calculator;
import org.testng.annotations.Test;

public class TestingTest extends CrossPlatformUtility {

    @Test
    public void firstTest() {
        System.out.println("Test started!");
        locateElementClick(Calculator.button7);
        locateElementClick(Calculator.button2);
        locateElementClick(Calculator.plusButton);
        //System.out.println(getIOSDriver().getPageSource());
        verifyElementContainsText(Calculator.lastNumberDisplay, "72");
        verifyElementContainsText(Calculator.currentNumberDisplay, "+");
        locateElementClick(Calculator.button3);
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "75");
    }
}
