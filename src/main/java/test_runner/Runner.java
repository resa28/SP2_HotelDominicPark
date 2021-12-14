package test_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = {"step_definitions"}, tags = {"@test0"}, plugin = { "pretty", "html:target/cucumber-reports" })
public class Runner {
}
