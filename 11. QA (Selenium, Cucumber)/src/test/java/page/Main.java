package page;

import help.PropertyFileRead;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Main extends BasePage {
    String SITE_URL = new PropertyFileRead().getProp("url");

    public Main(WebDriver driver) {
        super(driver);
    }

    public Main goTo() {
        driver.get(SITE_URL);
        return this;
    }

    public Main chooseTask(String taskNum) {
        click(By.xpath("//h2[.='Zadanie " + taskNum + "']"));
        return this;
    }
}
