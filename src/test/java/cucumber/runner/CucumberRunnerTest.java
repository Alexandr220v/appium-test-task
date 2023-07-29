package cucumber.runner;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        glue = "steps_definitions",
        tags = {"@smoke"},
        plugin = {"pretty", "html:target/cucumber-reports"})

public class CucumberRunnerTest {

    private static final Logger LOGGER = Logger.getLogger(CucumberRunnerTest.class.getName());

}