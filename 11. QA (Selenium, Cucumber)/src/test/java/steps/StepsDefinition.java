package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StepsDefinition extends TestBase {
    private static final Logger LOG = LoggerFactory.getLogger(StepsDefinition.class);

    @Before
    public void initialization(Scenario scenario){
        start();
        LOG.info("Scenario " + scenario.getName() + " is started." );
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (!scenario.isFailed()) {
            LOG.info("Scenario successfully passed: " + scenario.getName());
        } else {
            File file = new File("target");
            if (!file.exists()) {
                file.mkdir();
            }
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentTime = new SimpleDateFormat("dd_MM_yyyy_hh_mm").format(new Date());
            String screenName = "target/" + "screenshots/" + currentTime + "/" + scenario.getName() + ".png";
            File targetFile = new File(screenName);
            FileUtils.copyFile(screenshotFile, targetFile);
            LOG.info("Scenario is  failed: " + scenario.getName());
            LOG.info("Screenshot " + screenName + " was created");
        }
        finish();
    }

    @Given("I go to main page")
    public void iGoToMainPage() {
        main.goTo();
    }

    @When("^I select \"([^\"]*)\" task$")
    public void iSelectTask(String taskNumber) {
        main.chooseTask(taskNumber);
    }

    @And("^I login as \"([^\"]*)\" with password \"([^\"]*)\"$")
    public void iLoginAsWithPassword(String login, String pass) {
        taskSix.checkAllElementsOnPagePresent()
                .fillInLogin(login)
                .fillInPass(pass)
                .logBtnClick();
    }

    @Then("I should (see|not see) the link to download file$")
    public void iShouldSeeTheLinkToDownloadFile(String visibility) {
        if (visibility.equals("see")) {
            taskSix.isLoginCorrect();
        } else {
            taskSix.isLoginWrong();
        }
    }




}
