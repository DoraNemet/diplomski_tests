package mobileTesting.tests;

import mobileTesting.configuration.InitiateDevice;
import org.testng.annotations.Test;

public class TestingTest extends InitiateDevice {

    @Test
    public void firstTest() {
        System.out.println("Test started!");
    }
}
