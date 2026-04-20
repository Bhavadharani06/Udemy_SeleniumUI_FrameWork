package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

<<<<<<< HEAD
@CucumberOptions(
    features = {"src/test/java/featureFiles"},
    glue = "stepDefinition",
    dryRun = false
)
public class RunnerIO extends AbstractTestNGCucumberTests {

=======
@CucumberOptions(features = { "./src/test/java/freatures/signup.feature" }, 
glue = "stepDefinition", 
plugin = { "pretty" }, 
dryRun = false)
public class RunnerIO extends AbstractTestNGCucumberTests {
>>>>>>> mylearning
}