package selenide.pageObj.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void start(){
        Configuration.startMaximized = true;

//  Just to show some configuration examples
//        Configuration.timeout = 5000;
//        Configuration.headless = true;
//        Configuration.baseUrl = "www.example.com";
//        Configuration.browser = "firefox";
//        Configuration.downloadsFolder = "src/test/resources/download";
    }
}
