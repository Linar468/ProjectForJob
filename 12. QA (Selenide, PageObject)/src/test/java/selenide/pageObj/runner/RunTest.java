package selenide.pageObj.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"},
        glue = {"selenide/pageObj/steps"}, plugin = {"pretty"})
public class RunTest {
}
