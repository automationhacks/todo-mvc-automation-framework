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
        WebDriver driver = getDriver();
        HomePage home = new HomePage(driver);
        String note = "Build a framework with selenium";
        home.addTodo(note);

        String addedTodosText = home.findNoteWith(note).getText();
        Assert.assertEquals(addedTodosText, note);
        closeDriver(driver);

    }

    @Test(groups = Tags.REGRESSION)
    public void testToDoItemsLeft() {
        Logger.printCurrentThread();
        WebDriver driver = getDriver();
        HomePage home = new HomePage(driver)
                .addTodo("Get work done")
                .addTodo("relax");

        int notDoneCount = home.getNotCompletedToDosCount();
        int actual = new FooterPage(driver).getItemsLeftCount();

        Assert.assertEquals(actual, notDoneCount);
        closeDriver(driver);
    }

    @Test(groups = Tags.REGRESSION)
    public void testAddMultipleToDosAndCompleteOne() {
        Logger.printCurrentThread();
        WebDriver driver = getDriver();
        HomePage home = new HomePage(driver);
        for (String todo : testTodos) {
            home.addTodo(todo);
        }

        String task = "Sleep";
        boolean isCompleted = home.completeToDo(task).isToDoCompleted(task);
        Assert.assertTrue(isCompleted);
        closeDriver(driver);
    }
}
