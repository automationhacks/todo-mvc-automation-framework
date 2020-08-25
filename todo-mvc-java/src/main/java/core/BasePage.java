package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public static final long WAIT_DURATION = 30;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void pressEnter(WebElement element) {
        element.sendKeys(Keys.ENTER);
    }

    public WebElement getElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_DURATION);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        return driver.findElement(by);
    }

    public String getText(WebElement elem) {
        return elem.getText();
    }
}
