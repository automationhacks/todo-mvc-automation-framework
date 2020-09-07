package todotests;

import base.BaseTest;
import config.Tags;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FooterPage;
import pageobjects.HomePage;
import utils.Logger;

import java.util.Arrays;
import java.util.List;

public class TodoTests extends BaseTest {
    List<String> testTodos = Arrays.asList("Eat", "Sleep", "Code", "Repeat");

    @Test(groups = Tags.REGRESSION)
    public void testAddTodo() {
        Logger.printCurrentThread();
        HomePage home = new HomePage(wbDriver.get());
        String note = "Build a framework with selenium";
        home.addTodo(note);

        String addedTodosText = home.findNoteWith(note).getText();
        Assert.assertEquals(addedTodosText, note);

    }

    @Test(groups = Tags.REGRESSION)
    public void testToDoItemsLeft() {
        Logger.printCurrentThread();
        WebDriver driver = wbDriver.get();
        HomePage home = new HomePage(driver)
                .addTodo("Get work done")
                .addTodo("relax");

        int notDoneCount = home.getNotCompletedToDosCount();
        int actual = new FooterPage(driver).getItemsLeftCount();

        Assert.assertEquals(actual, notDoneCount);
    }

    @Test(groups = Tags.REGRESSION)
    public void testAddMultipleToDosAndCompleteOne() {
        Logger.printCurrentThread();
        HomePage home = new HomePage(wbDriver.get());
        for (String todo : testTodos) {
            home.addTodo(todo);
        }

        String task = "Sleep";
        boolean isCompleted = home.completeToDo(task).isToDoCompleted(task);
        Assert.assertTrue(isCompleted);
    }
}
