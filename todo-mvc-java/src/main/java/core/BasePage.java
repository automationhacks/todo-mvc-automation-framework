package core;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }
}
