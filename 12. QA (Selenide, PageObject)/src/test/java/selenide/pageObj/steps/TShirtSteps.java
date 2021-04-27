package selenide.pageObj.steps;

import io.cucumber.java.en.Then;
import selenide.pageObj.pages.TShirts;

public class TShirtSteps {
    TShirts tShirts = new TShirts();

    @Then("I am on t-shirts page")
    public void iAmOnTShirtsPage() {
        tShirts.iAmOnTShirtsPage();
    }

}
