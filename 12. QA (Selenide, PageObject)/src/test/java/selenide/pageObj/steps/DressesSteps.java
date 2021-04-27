package selenide.pageObj.steps;

import io.cucumber.java.en.Then;
import selenide.pageObj.pages.Dresses;

public class DressesSteps {
    Dresses dresses = new Dresses();

    @Then("I am on dresses page")
    public void iAmOnDressesPage() {
        dresses.iAmOnDressesPage();
    }
}
