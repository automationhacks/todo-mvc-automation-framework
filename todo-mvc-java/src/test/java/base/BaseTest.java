package base;

import core.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected ThreadLocal<WebDriver> wbDriver = new ThreadLocal<WebDriver>();

    @BeforeMethod(alwaysRun = true)
    public void getDriver() {
        wbDriver.set(new ChromeDriver());
        String baseUrl = new PropertiesReader().getBaseURI();
        wbDriver.get().get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        wbDriver.get().quit();
    }

}
