package selenide.pageObj.pages;

import com.codeborne.selenide.Selenide;

public class Main {
    public void open() {
        Selenide.open("http://automationpractice.com");
    }
}
