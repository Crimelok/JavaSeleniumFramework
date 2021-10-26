package testRunner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/AmazonExample.feature",
        glue = "stepDefinitions",
        dryRun = false,
        plugin = {"pretty", "html:test-output"}
)
public class Runner {
}
