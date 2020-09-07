package base;

import core.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver getDriver() {
        WebDriver driver = new ChromeDriver();
        String baseUrl = new PropertiesReader().getBaseURI();
        driver.get(baseUrl);
        return driver;
    }

    public void closeDriver(WebDriver driver) {
        driver.quit();
    }

}
