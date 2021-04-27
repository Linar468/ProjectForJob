package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskSix extends BasePage {
    public TaskSix(WebDriver driver) {
        super(driver);
    }

    public TaskSix fillInLogin(String login) {
        writeText(By.id("LoginForm__username"), login);
        return this;
    }

    public TaskSix fillInPass(String pass) {
        writeText(By.name("LoginForm[_password]"), pass);
        return this;

    }

    public TaskSix logBtnClick() {
        click(By.cssSelector(".btn-default.btn"));
        return this;
    }

    public TaskSix isLoginCorrect() {
        isElementDisplayed(By.linkText("Pobierz plik"));
        return this;
    }

    public TaskSix checkAllElementsOnPagePresent() {
        isElementDisplayed((By.id("LoginForm__username")));
        isElementDisplayed((By.name("LoginForm[_password]")));
        isElementDisplayed((By.cssSelector(".btn-default.btn")));
        return this;
    }

    public TaskSix isLoginWrong() {
        isElementNotDisplayed(By.linkText("Pobierz plik"));
        return this;
    }
}
