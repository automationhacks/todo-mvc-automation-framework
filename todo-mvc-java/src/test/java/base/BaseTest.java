package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver = new ChromeDriver();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver.get("https://todomvc-app-for-testing.surge.sh/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

}
