package seldocker;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CrossBrowser {
    WebDriver driver;
    Platform ANY;
    String nodeUrl;

    @Parameters({"portNO","appURL"})
    @BeforeMethod()
    public void setup(String portNO, String appURL) throws MalformedURLException {
        if(portNO.equalsIgnoreCase("4546")){
            nodeUrl = "http://192.168.0.102:4546/wd/hub";
            System.out.println("Chrome Browser Environmnent test created");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            cap.setPlatform(Platform.ANY);
            driver = new RemoteWebDriver(new URL(nodeUrl), cap);
            driver.manage().window().maximize();
            driver.navigate().to(appURL);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        else
            if(portNO.equalsIgnoreCase("4547")){
                nodeUrl = "http://192.168.0.102:4547/wd/hub";
                System.out.println("Firefox Browser Environmnent test created");
                DesiredCapabilities cap1 = DesiredCapabilities.firefox();
                cap1.setBrowserName("firefox");
                cap1.setPlatform(Platform.ANY);
                driver = new RemoteWebDriver(new URL(nodeUrl), cap1);
                //driver.manage().window().maximize();
                driver.navigate().to(appURL);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
            else
                System.err.println("Provide correct port no");
    }

    @Test(dataProvider="Authentication")
    public void facebookLogin(String username, String password) throws InterruptedException
    {
        System.out.println("Trying with :"+username);
        System.out.println(driver.getTitle());
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys(username);
        driver.findElement(By.cssSelector("input[id='pass']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    @DataProvider(name="Authentication")
    public Object[][] credentials()
    {
        Object[][] obj = new Object[3][2];
        obj[0][0]="Admin";
        obj[0][1]="Admin";

        obj[1][0]="Tester";
        obj[1][1]="Tester";

        obj[2][0]="Developer";
        obj[2][1]="developer";

        return obj;
    }

    @AfterMethod()
    public void tearDown()
    {
        driver.quit();
        System.out.println("Closing the Browser");
        System.out.println("**************************************************************");
    }
}
