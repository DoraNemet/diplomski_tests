package mobileTesting.locators;

import mobileTesting.Util.CrossBy;
import org.openqa.selenium.By;

public class Fuel {
    public static By priceField = CrossBy.id("FuelPrice", "com.example.dorafundak.multitask:id/fuelPrice");
    public static By consumptionField = CrossBy.id("FuelConsumption", "com.example.dorafundak.multitask:id/usage");
    public static By distanceField = CrossBy.id("Distance", "com.example.dorafundak.multitask:id/distance");
    public static By tripPrice = CrossBy.id("Price", "com.example.dorafundak.multitask:id/tripPrice");
    public static By fuelUsed = CrossBy.id("FuelUsed", "com.example.dorafundak.multitask:id/fuelVolume");
    public static By doneButon = CrossBy.id("Done", "com.example.dorafundak.multitask:id/fuelVolume");
}