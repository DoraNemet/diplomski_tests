package mobileTesting.locators;

import mobileTesting.Util.CrossBy;
import org.openqa.selenium.By;

public class Calculator {
    public static By acButton = CrossBy.id("reset","com.example.dorafundak.multitask:id/ac");
    public static By cButton = CrossBy.id("C","com.example.dorafundak.multitask:id/delOne");
    public static By divideButton = CrossBy.id("divide","com.example.dorafundak.multitask:id/divide");
    public static By multiplyButton = CrossBy.id("x","com.example.dorafundak.multitask:id/multiply");
    public static By minusButton = CrossBy.id("-","com.example.dorafundak.multitask:id/minus");
    public static By plusButton = CrossBy.id("+","com.example.dorafundak.multitask:id/plus");
    public static By equalsButton = CrossBy.id("equals","com.example.dorafundak.multitask:id/equals");
    public static By dotButton = CrossBy.id(".","com.example.dorafundak.multitask:id/point");
    public static By button0 = CrossBy.id("0","com.example.dorafundak.multitask:id/n0");
    public static By button1 = CrossBy.id("1","com.example.dorafundak.multitask:id/n1");
    public static By button2 = CrossBy.id("2","com.example.dorafundak.multitask:id/n2");
    public static By button3 = CrossBy.id("3","com.example.dorafundak.multitask:id/n3");
    public static By button4 = CrossBy.id("4","com.example.dorafundak.multitask:id/n4");
    public static By button5 = CrossBy.id("5","com.example.dorafundak.multitask:id/n5");
    public static By button6 = CrossBy.id("6","com.example.dorafundak.multitask:id/n6");
    public static By button7 = CrossBy.id("7","com.example.dorafundak.multitask:id/n7");
    public static By button8 = CrossBy.id("8","com.example.dorafundak.multitask:id/n8");
    public static By button9 = CrossBy.id("9","com.example.dorafundak.multitask:id/n9");
    public static By title = CrossBy.id("Kalkulator","com.example.dorafundak.multitask:id/title");
    public static By currentNumberDisplay = CrossBy.id("currentNumberDisplay","com.example.dorafundak.multitask:id/currentNumber");
    public static By lastNumberDisplay = CrossBy.id("lastNumberLabel","com.example.dorafundak.multitask:id/lastNumber");
}
