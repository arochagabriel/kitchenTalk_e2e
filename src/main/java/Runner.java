import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources",
		glue="steps",
		plugin = { "pretty", "html:build/reports/cucumber","json:build/reports/cucumber/cucumber.json",
		"junit:build/reports/cucumber/cucumber.xml"},
		dryRun =false,
		monochrome = false,
		tags = {},
		snippets = SnippetType.CAMELCASE)
public class Runner {

}
