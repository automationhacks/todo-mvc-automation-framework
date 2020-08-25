package todotests;

import base.BaseTest;
import config.Tags;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class TodoTests extends BaseTest {
    @Test(groups = Tags.REGRESSION)
    public void testAddTodo() {
        HomePage home = new HomePage(driver);
        home.addTodo("Build a framework with selenium");
    }
}
