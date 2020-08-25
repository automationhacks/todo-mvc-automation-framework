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


    public void addTodo(String todoNote) {
        enterText(todo, todoNote);
        pressEnter(todo);
    }

    public WebElement findNoteWith(String text) {
        return getElement(By.xpath(String.format(addedNote, text)));
    }

    public int getNotCompletedToDosCount() {
        return todos.size();
    }
}
