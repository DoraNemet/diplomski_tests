package mobileTesting.tests;

import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Fuel;
import mobileTesting.locators.Navigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FuelTest extends CrossPlatformUtility {

    private static double PRICE = 10.34;
    private double CONSUMPTION = 8.59;
    private double DISTANCE = 23;
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df = (DecimalFormat) nf;

    @BeforeMethod
    public void before() {
        locateElementClick(Navigation.gorivoButton);
    }

    @Test(description = "Formula check")
    public void formulaCheck() {
        df.setMaximumFractionDigits(2);

        locateElementSendKeys(Fuel.priceField, Double.toString(PRICE));
        locateElementSendKeys(Fuel.consumptionField, Double.toString(CONSUMPTION));
        locateElementSendKeys(Fuel.distanceField, Double.toString(DISTANCE));
        locateElementClick(Fuel.doneButon);
        verifyElementContainsText(Fuel.tripPrice, df.format(DISTANCE * (CONSUMPTION / 100) * PRICE));
        verifyElementContainsText(Fuel.fuelUsed, df.format(DISTANCE * (CONSUMPTION / 100)));
    }

    @Test(description = "Result without PRICE")
    public void withoutPrice() {
        df.setMaximumFractionDigits(2);

        clearElement(Fuel.consumptionField);
        clearElement(Fuel.distanceField);
        clearElement(Fuel.priceField);

        locateElementSendKeys(Fuel.consumptionField, Double.toString(CONSUMPTION));
        locateElementSendKeys(Fuel.distanceField, Double.toString(DISTANCE));
        locateElementClick(Fuel.doneButon);
//        verifyElementContainsText(Fuel.tripPrice, "");
        verifyElementContainsText(Fuel.fuelUsed, df.format(DISTANCE * (CONSUMPTION / 100)));
    }
}
