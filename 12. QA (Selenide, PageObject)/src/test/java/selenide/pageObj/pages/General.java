package selenide.pageObj.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.element;

public class General {

    public General openTab(String tabName){
        element(By.linkText(tabName)).click();
        return this;
    }
}
