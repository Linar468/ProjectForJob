package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        return;
    }

    //wait wrapper method
    public void waitVisibility(By elementBy) {
        // expected conditions -- ожидаемые условия
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //click method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //isElementDisplayed
    public void isElementDisplayed(By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());

    }

    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);

    }

    public void isElementNotDisplayed(By elementBy) {
        Assert.assertFalse(driver.findElements(elementBy).size() > 0);
    }


}