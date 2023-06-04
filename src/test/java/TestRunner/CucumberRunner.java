package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

public class CucumberRunner {
    @CucumberOptions(
            features = {
                    "src/test/resources/ApiFeatures",
                    "src/test/resources/AppFeatures",
                    "src/test/resources/WebFeatures",
            },
            glue = {"StepDefinition"},
            tags ="@smoke",
            monochrome = true,
            dryRun = false,
            plugin = {
                    "pretty",
                    "html:build/reports/feature.html"
            })
    @Test
    public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    }
}
