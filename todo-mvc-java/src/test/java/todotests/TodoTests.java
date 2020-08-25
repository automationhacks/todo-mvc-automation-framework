package todotests;

import base.BaseTest;
import config.Tags;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FooterPage;
import pageobjects.HomePage;

public class TodoTests extends BaseTest {
    @Test(groups = Tags.REGRESSION)
    public void testAddTodo() {
        HomePage home = new HomePage(driver);
        String note = "Build a framework with selenium";
        home.addTodo(note);

        String addedTodosText = home.findNoteWith(note).getText();
        Assert.assertEquals(addedTodosText, note);
    }

    @Test(groups = Tags.REGRESSION)
    public void testToDoItemsLeft() {
        HomePage home = new HomePage(driver);
        home.addTodo("Get work done");
        home.addTodo("relax");

        int notDoneCount = home.getNotCompletedToDosCount();
        FooterPage footer = new FooterPage(driver);
        int actual = footer.getItemsLeftCount();

        Assert.assertEquals(actual, notDoneCount);
    }
}
