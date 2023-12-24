import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"cucumber.glue.hooks", "cucumber.glue.steps"},
        plugin = {"pretty", "html:reports/cucumber-report.html"},
        features = {"src/test/resources/features"},
        monochrome =true,
        publish = true
)

public class CucumberRunner {
}
