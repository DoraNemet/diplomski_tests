package mobileTesting.tests;

import mobileTesting.Util.CrossBy;
import mobileTesting.Util.CrossPlatformUtility;
import mobileTesting.locators.Navigation;
import mobileTesting.locators.Notes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NotesTest extends CrossPlatformUtility {

    private String TEST_NOTE = "test note text";
    private String TEST_NOTE2 = "test note text2";

    @BeforeMethod
    public void before() {
        locateElementClick(Navigation.biljeskeButton);
    }

    @Test(description = "Add note")
    public void addNote() {
        locateElementClick(Notes.add);
        locateElementSendKeys(Notes.noteField, TEST_NOTE);
        locateElementClick(Notes.save);
        locateElement(CrossBy.id(TEST_NOTE, ""));
    }

    @Test(description = "Delete note")
    public void deleteNote() {
        if(!isPresent(CrossBy.id(TEST_NOTE, ""))){
            addNote();
        }
        switch (getPlatform()){
            case IOS:
                swipeElementToLeft(CrossBy.id(TEST_NOTE, ""));
                break;
            case ANDROID:
                locateElementClick(CrossBy.id(TEST_NOTE, ""));
                //locateElementClick();
                break;
        }

        if(isPresent(CrossBy.id(TEST_NOTE, ""))) {
            failTest(TEST_NOTE + " not deleted");
        }
    }

    @Test(description = "Cancel from adding the note")
    public void cancelAddNote() {
        locateElementClick(Notes.add);
        locateElementSendKeys(Notes.noteField, TEST_NOTE2);
        locateElementClick(Notes.cancel);
        if(isPresent(CrossBy.id(TEST_NOTE2, ""))){
            failTest("Note is added and it shouldn't be");
        }
    }

}
