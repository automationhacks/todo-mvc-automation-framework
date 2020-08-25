package pageobjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends BasePage {
    public FooterPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath= "//span[@class='todo-count']/strong")
    WebElement todoCount;

    public int getItemsLeftCount() {
        return Integer.parseInt(todoCount.getText());
    }
}
