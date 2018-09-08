package mobileTesting.tests;

import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Calculator;
import mobileTesting.locators.Navigation;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest extends CrossPlatformUtility {

    @BeforeClass
    public void beforeClass() {
        locateElementClick(Navigation.kalkulatorButton);
    }
    @BeforeMethod
    public void before() {
        locateElementClick(Calculator.acButton);
    }

    @Test(description = "Addition test 72+3=75")
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

    @Test(description = "Subtraction test 68-4=64")
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

    @Test(description = "Multiplication test 5x1=5")
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

    @Test(description = "Division test 9/4=2.25")
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

    @Test(description = "Multiple operations in a row  (9+5)x2=28.0")
    public void stackedOperationsTest() {
        locateElementClick(Calculator.button9);
        verifyElementContainsText(Calculator.currentNumberDisplay, "9");
        locateElementClick(Calculator.plusButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "9");
        verifyElementContainsText(Calculator.currentNumberDisplay, "+");
        locateElementClick(Calculator.button5);
        verifyElementContainsText(Calculator.currentNumberDisplay, "5");
        verifyElementContainsText(Calculator.lastNumberDisplay, "9");
        locateElementClick(Calculator.multiplyButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "14.0");
        verifyElementContainsText(Calculator.currentNumberDisplay, "x");
        locateElementClick(Calculator.button2);
        verifyElementContainsText(Calculator.currentNumberDisplay, "2");
        verifyElementContainsText(Calculator.lastNumberDisplay, "14.0");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "28.0");
    }

    @Test(description = "Test decimal point")
    public void decimalPointTest() {
        locateElementClick(Calculator.button7);
        locateElementClick(Calculator.dotButton);
        locateElementClick(Calculator.button2);
        verifyElementContainsText(Calculator.currentNumberDisplay, "7.2");
        locateElementClick(Calculator.plusButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "7.2");
        verifyElementContainsText(Calculator.currentNumberDisplay, "+");
        locateElementClick(Calculator.button3);
        locateElementClick(Calculator.dotButton);
        locateElementClick(Calculator.button3);
        verifyElementContainsText(Calculator.currentNumberDisplay, "3.3");
        verifyElementContainsText(Calculator.lastNumberDisplay, "7.2");
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "10.5");
    }

    @Test(description = "AC button test")
    public void acTest() {
        locateElementClick(Calculator.button1);
        locateElementClick(Calculator.button5);
        locateElementClick(Calculator.plusButton);
        locateElementClick(Calculator.acButton);
        if(isPresent(Calculator.lastNumberDisplay)) {
            verifyElementContainsText(Calculator.lastNumberDisplay, "");
        }

        if(isPresent(Calculator.currentNumberDisplay)){
            verifyElementContainsText(Calculator.currentNumberDisplay, "");
        }
        additionTest();
    }


    @Test(description = "C button test")
    public void cTest() {
        locateElementClick(Calculator.button1);
        locateElementClick(Calculator.button2);
        locateElementClick(Calculator.button3);
        locateElementClick(Calculator.button4);
        locateElementClick(Calculator.cButton);
        verifyElementContainsText(Calculator.currentNumberDisplay, "123");
        locateElementClick(Calculator.plusButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "123");
        verifyElementContainsText(Calculator.currentNumberDisplay, "+");
        locateElementClick(Calculator.button5);
        locateElementClick(Calculator.equalsButton);
        verifyElementContainsText(Calculator.lastNumberDisplay, "128");
    }

}
