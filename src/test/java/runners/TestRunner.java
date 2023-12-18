package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        publish = true,
        plugin = {"pretty",
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml"},

        features = "src/test/resources/features",
        glue = {"stepDefinitions", "hooks"},
        tags = "@back1",
        dryRun = false


)
public class TestRunner {
}
