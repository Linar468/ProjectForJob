package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskSix;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Main main;
    protected TaskSix taskSix;

    public void start() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--test-type");
        ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(chromeDriverService, options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        main = PageFactory.initElements(driver, Main.class);
        taskSix = PageFactory.initElements(driver, TaskSix.class);
    }

    public void finish() {
        if (driver != null)
            driver.quit();
    }
}