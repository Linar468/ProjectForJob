package selenide.pageObj.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import selenide.pageObj.pages.General;
import selenide.pageObj.pages.Main;

public class MainSteps {
    Main main = new Main();
    General general = new General();

    @Given("I am on main page")
    public void iAmOnMainPage() {
        main.open();
    }

    @When("I click {string} tab")
    public void iClickTab(String tabName) {
        general.openTab(tabName);
    }

}
