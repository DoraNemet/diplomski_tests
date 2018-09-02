package mobileTesting.tests;

import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Calculator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorOperationsTest extends CrossPlatformUtility {

    @BeforeMethod
    public void before() {
        locateElementClick(Calculator.acButton);
    }

    @Test
    public void additionTest() {
        locateElementClick(Calculator.button7);
        locateElementClick(Calculator.button2);
        verifyElementContainsText(Calculator.currentNumberDisplay, "72");
        locateElementClick(Calculator.plusButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "72");
        verifyElementContainsText(Calculator.currentNumberDisplay, "+");
        locateElementClick(Calculator.button3);
        verifyElementContainsText(Calculator.currentNumberDisplay, "3");
        verifyElementContainsText(Calculator.lastNumberDisplay, "72");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "75");
    }

    @Test
    public void subtractionTest() {
        locateElementClick(Calculator.button6);
        locateElementClick(Calculator.button8);
        verifyElementContainsText(Calculator.currentNumberDisplay, "68");
        locateElementClick(Calculator.minusButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "68");
        verifyElementContainsText(Calculator.currentNumberDisplay, "-");
        locateElementClick(Calculator.button4);
        verifyElementContainsText(Calculator.currentNumberDisplay, "4");
        verifyElementContainsText(Calculator.lastNumberDisplay, "68");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "64");
    }

    @Test
    public void multiplicationTest() {
        locateElementClick(Calculator.button5);
        verifyElementContainsText(Calculator.currentNumberDisplay, "5");
        locateElementClick(Calculator.multiplyButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "5");
        verifyElementContainsText(Calculator.currentNumberDisplay, "x");
        locateElementClick(Calculator.button1);
        verifyElementContainsText(Calculator.currentNumberDisplay, "1");
        verifyElementContainsText(Calculator.lastNumberDisplay, "5");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "5");
    }

    @Test
    public void divisionTest() {
        locateElementClick(Calculator.button9);
        verifyElementContainsText(Calculator.currentNumberDisplay, "9");
        locateElementClick(Calculator.divideButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "9");
        verifyElementContainsText(Calculator.currentNumberDisplay, "/");
        locateElementClick(Calculator.button4);
        verifyElementContainsText(Calculator.currentNumberDisplay, "4");
        verifyElementContainsText(Calculator.lastNumberDisplay, "9");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "2.25");
    }

}
