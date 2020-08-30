package pageobjects;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#root input")
    WebElement todo;

    @FindBy(xpath = "//ul[@class='todo-list']//label")
    List<WebElement> todos;

    String addedNote =
            "//ul[@class='todo-list']//label[contains(text(), '%s')]";

    String todoListXPath = "//ul[@class=\"todo-list\"]";
    String todoItemToCheckXPath = "//label[contains(text(), \"%s\")]//parent::div//input";
    String completedTodo = "//li[@class=\"completed\"]//label[contains(text(), \"%s\")]";


    public HomePage addTodo(String todoNote) {
        enterText(todo, todoNote);
        pressEnter(todo);
        return this;
    }

    public WebElement findNoteWith(String text) {
        return getElement(By.xpath(String.format(addedNote, text)));
    }

    public int getNotCompletedToDosCount() {
        return todos.size();
    }

    public HomePage completeToDo(String todoItem) {
        WebElement todos = getElement(By.xpath(todoListXPath));
        WebElement toDoCheckBox = todos.findElement(By.xpath(String.format(todoItemToCheckXPath, todoItem)));

        toDoCheckBox.click();
        return this;
    }

    public boolean isToDoCompleted(String name) {
        return isElementVisible(By.xpath(String.format(completedTodo, name)));
    }
}
