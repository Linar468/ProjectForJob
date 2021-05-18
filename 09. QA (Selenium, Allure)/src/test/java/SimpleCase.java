import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class SimpleCase {
    final String siteURL = "https://buggy-testingcup.pgs-soft.com/";
    WebDriver driver;

    @BeforeEach
    public void start(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(siteURL);

    }
    @AfterEach
    public void finish(){
        driver.quit();
    }

    @Attachment(value = "Failed test screenshot")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Epic("TESTING FOR https://testingcup.pgs-soft.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.MINOR)
    @Description("In this test we will login with correct credentials. When we logged we see link for file.")
    @Story(value = "Test for login with correct credentials")

    @Test
    public void loginClickWithCorrectCredentials() throws InterruptedException {
        chooseTaskSix();
        fillInLogin("tester");
        fillInPassword("123-xyz");
        loginButtonClick();
        attachScreenshot();
        isLoginSuccessful();
    }


    @Epic("TESTING FOR https://testingcup.pgs-soft.com/ tasks")
    @Feature(value = "Tests for task 6")
    @Severity(SeverityLevel.BLOCKER)
    @Description("In this test we will login with correct credentials. When we logged we see link for file.")
    @Story(value = "Test for login with incorrect credentials")


    @Step(value = "Fill in login with {0}")   // {0} - считывает значение Login  ----> 1,2,3......
    public void fillInLogin(String login){
        driver.findElement(By.id("LoginForm__username")).sendKeys(login);
    }

    @Step(value = "Fill in password with {0}")
    public void fillInPassword(String password){
        driver.findElement(By.id("LoginForm__password")).sendKeys(password);
    }

    @Step(value = "Click button Login")
    public void loginButtonClick(){
        driver.findElement(By.id("LoginForm_save")).click();
    }
    @Step(value = "Choose task 6 on main page")
    public void chooseTaskSix() throws InterruptedException {
        driver.findElement(By.linkText("Zadanie 6")).click();
        Thread.sleep(1500);
    }
    @Step(value = "Login was successful")
    public void isLoginSuccessful(){
        assertTrue(driver.findElement(By.linkText("Pobierz plik")).isDisplayed());
    }
    @Step(value = "Login was unsuccessful")
    public void isLoginUnsuccessful(){
        assertTrue(driver.findElements(By.linkText("Pobierz plik")).isEmpty());
    }
}
