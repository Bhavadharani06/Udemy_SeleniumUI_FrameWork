package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "./src/test/java/freatures/signup.feature" }, 
glue = "stepDefinition", 
plugin = { "pretty" }, 
dryRun = false)
public class RunnerIO extends AbstractTestNGCucumberTests {
}