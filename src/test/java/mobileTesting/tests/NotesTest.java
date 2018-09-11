package mobileTesting.tests;

import mobileTesting.Util.CrossBy;
import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Navigation;
import mobileTesting.locators.Notes;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NotesTest extends CrossPlatformUtility {

    private String TEST_NOTE = "test note text";
    private String TEST_NOTE2 = "test note text2";

    @BeforeClass
    public void before() {
        locateElementClick(Navigation.biljeskeButton);
    }

    @Test(description = "Add note")
    public void skipTest() {
        skipTest("Test skipped");
        locateElementClick(Notes.add);
        locateElementSendKeys(Notes.noteField, TEST_NOTE);
        locateElementClick(Notes.save);
        switch (getPlatform()) {
            case IOS:
                verifyElementContainsText(By.id(TEST_NOTE), TEST_NOTE);
                break;
            case ANDROID:
                verifyElementContainsText(Notes.notesText, TEST_NOTE);
                break;
        }
    }

    @Test(description = "Delete note")
    public void failTest() {
        if(!isPresent(Notes.notesText)){
           // addNote();
        }
        failTest("Test failed");
        switch (getPlatform()){
            case IOS:
                swipeElementToLeft(By.id(TEST_NOTE));
                if(isPresent(By.id(TEST_NOTE))){
                    failTest("Note is added and it shouldn't be");
                }
                break;
            case ANDROID:
                locateElementClick(Notes.notesText);
                locateElementClick(Notes.yes);
                if(isPresent(Notes.notesText)){
                    failTest("Note is added and it shouldn't be");
                }
                break;
        }
    }

    @Test(description = "Cancel from adding the note")
    public void passTest() {
        threadSleep(2);
        locateElementClick(Notes.add);
        locateElementSendKeys(Notes.noteField, TEST_NOTE2);
        locateElementClick(Notes.cancel);
        switch (getPlatform()) {
            case IOS:
                if(isPresent(By.id(TEST_NOTE2))){
                    failTest("Note is added and it shouldn't be");
                }
                break;
            case ANDROID:
                if(isPresent(Notes.notesText)){
                    failTest("Note is added and it shouldn't be");
                }
                break;
        }
    }
}
