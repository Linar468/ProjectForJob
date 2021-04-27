package selenide.pageObj.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.element;

public class Dresses {

    //just to show how FindBy can be used
    @FindBy(xpath = "//button[contains(.,'Selected')]")
    private SelenideElement exportRunSelectedButton;

    public Dresses open() {
        Selenide.open("http://automationpractice.com/index.php?id_category=8&controller=category");
        return this;
    }

    public void iAmOnDressesPage(){
        element(By.xpath("//h2[@class='title_block']")).shouldHave(text("DRESSES"));
    }

    //just to show how FindBy can be used
    public void justForTest(){
        exportRunSelectedButton.setValue("2");
    }
}

