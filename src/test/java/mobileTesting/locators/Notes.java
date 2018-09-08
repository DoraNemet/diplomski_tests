package mobileTesting.locators;

import mobileTesting.Util.CrossBy;
import org.openqa.selenium.By;

public class Notes {
    public static By add = CrossBy.id("+", "com.example.dorafundak.multitask:id/addNote");
    public static By noteField = CrossBy.id("Bilješka", "com.example.dorafundak.multitask:id/noteInput");
    public static By save = CrossBy.id("Save", "com.example.dorafundak.multitask:id/saveButton");
    public static By cancel = CrossBy.id("Cancel", "com.example.dorafundak.multitask:id/cancelButton");
    public static By notesText = CrossBy.id("", "com.example.dorafundak.multitask:id/noteText");
    public static By yes = CrossBy.id("android:id/button1");
    public static By no = CrossBy.id("android:id/button2");

}
