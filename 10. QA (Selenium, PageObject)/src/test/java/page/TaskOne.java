package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TaskOne extends BasePage {

    public TaskOne(WebDriver driver) {
        super(driver);
    }

    public void checkPageIsCorrect() {
        isElementDisplayed(By.xpath("//li[.='Zadanie 1']"));
    }

    public void scrollToElement(String element) {
        WebElement webElement = driver.findElement(By.xpath("//h4[text()='" + element + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.perform();
    }
}
