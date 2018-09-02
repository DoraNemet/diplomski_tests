package mobileTesting.locators;

import mobileTesting.Util.CrossBy;
import org.openqa.selenium.By;

public class Calculator {
    public static By kalkulatorButton = CrossBy.id("Kalkulator","com.example.dorafundak.multitask:id/calculatorButton");
    public static By gorivoButton = CrossBy.id("Gorivo","com.example.dorafundak.multitask:id/fuelButton");
    public static By biljeskeButton = CrossBy.id("Bilješke","com.example.dorafundak.multitask:id/notesButton");
}
