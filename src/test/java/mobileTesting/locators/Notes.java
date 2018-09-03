package mobileTesting.locators;

import mobileTesting.Util.CrossBy;
import org.openqa.selenium.By;

public class Notes {
    public static By add = CrossBy.id("+", "com.example.dorafundak.multitask:id/fuelPrice");
    public static By noteField = CrossBy.id("Bilješka", "com.example.dorafundak.multitask:id/usage");
    public static By save = CrossBy.id("Save", "com.example.dorafundak.multitask:id/distance");
    public static By cancel = CrossBy.id("Cancel", "com.example.dorafundak.multitask:id/distance");
    public static By yes = CrossBy.id("", "com.example.dorafundak.multitask:id/distance");

}
