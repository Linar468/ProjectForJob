package selenide.pageObj.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;

public class TShirts {

    public TShirts open() {
        Selenide.open("http://automationpractice.com/index.php?id_category=5&controller=category");
        return this;
    }

    public void iAmOnTShirtsPage(){
        element(By.className("category-name")).shouldHave(text("T-shirts"));
    }

}
