package suites.junit;

import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Courgette.class)
@CourgetteOptions(
		threads = 1,
		runLevel = CourgetteRunLevel.SCENARIO,
		rerunFailedScenarios = false,
		showTestOutput = true,
		reportTargetDir = "build",
		cucumberOptions = @CucumberOptions(
				features = "src/test/resources/features",
				glue = "steps",
				tags = {"@regression"},
				plugin = {
						"pretty",
						"json:build/cucumber-report/cucumber.json",
						"html:build/cucumber-report/cucumber",
						"junit:build/cucumber-report/cucumber.xml"},
				strict = true
		))
public class RunnerTest {

}
