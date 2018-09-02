package mobileTesting.tests;

import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Calculator;
import org.testng.annotations.Test;

public class TestingTest extends CrossPlatformUtility {

    @Test
    public void firstTest() {
        System.out.println("Test started!");
        locateElementClick(Calculator.gorivoButton);
        locateElementClick(Calculator.kalkulatorButton);
        locateElementClick(Calculator.biljeskeButton);
        threadSleep(10);
    }
}
