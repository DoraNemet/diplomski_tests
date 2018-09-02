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

    private double price = 10.34;
    private double consumption = 8.69;
    private double distance = 23;
    NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
    DecimalFormat df = (DecimalFormat) nf;

    @BeforeMethod
    public void before() {
        locateElementClick(Navigation.gorivoButton);
    }

    @Test(description = "Formula check")
    public void formulaCheck() {
        df.setMaximumFractionDigits(2);

        locateElementSendKeys(Fuel.priceField, Double.toString(price));
        locateElementSendKeys(Fuel.consumptionField, Double.toString(consumption));
        locateElementSendKeys(Fuel.distanceField, Double.toString(distance));
        locateElementClick(Fuel.doneButon);
        verifyElementContainsText(Fuel.tripPrice, df.format(distance * (consumption / 100) * price));
        verifyElementContainsText(Fuel.fuelUsed, df.format(distance * (consumption / 100)));
    }
}
