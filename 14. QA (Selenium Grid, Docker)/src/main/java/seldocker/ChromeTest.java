package seldocker;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeTest {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		URL url = new URL("http://192.168.0.102:4444/wd/hub");
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
