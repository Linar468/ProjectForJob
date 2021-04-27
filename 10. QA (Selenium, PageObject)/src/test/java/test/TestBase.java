package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskOne;
import page.TaskSix;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public Main main;
    public TaskOne taskOne;
    public TaskSix taskSix;

    @BeforeEach
    public void start() {
        WebDriverManager.chromedriver().setup();
        //driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        options.addArguments("--test-type");
        ChromeDriverService chromeDriverService = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(chromeDriverService, options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //подтягивает элементы со страницы Main
        main = PageFactory.initElements(driver, Main.class);
        //подтягивает элементы со страницы TaskOne
        taskOne = PageFactory.initElements(driver, TaskOne.class);
        taskSix = PageFactory.initElements(driver, TaskSix.class);
    }

    @AfterEach
    public void finish() {
        if (driver != null)
            driver.quit();
    }
}