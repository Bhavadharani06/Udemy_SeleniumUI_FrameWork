package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src\\test\\java\\featureFiles\\Explore1.feature"},
    glue = "stepDefinition",
    dryRun = false
)
public class RunnerIO extends AbstractTestNGCucumberTests {

}