import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"cucumber.glue.hooks", "cucumber.glue.steps"},
        plugin = {
//                "progress",
//                "summary",
//                "pretty",
                "html:reports/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/features"},
        monochrome =false,
        publish = false
)

public class CucumberRunner {
}
