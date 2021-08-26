package cucumber.glue.steps;

import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class valueWithin52wkRangeStepDefs {

    private TestContext testContext;

    public valueWithin52wkRangeStepDefs(TestContext testContext) {
        this.testContext = testContext;
    }


    @Given("^The GameStop Corp page$")
    public void openPage() {
        open("/equities/gamestop-corp");
    }

    @When("^Get the currentStock value from the page$")
    public void getCurrentStockValue() {
        String currentValue = $("span[class^=instrument-price_last]")
               .shouldBe(visible)
               .getText();

        testContext.scenarioData.put("currentValue", currentValue);
    }

    @And("^Get the 52 week range values$")
    public void get52weekRange() {
        String weekRange = $("[data-test='weekRange']")
                .shouldBe(visible)
                .getText();

        String[] weekRangeValues = weekRange.split("-");

        testContext.scenarioData.put("startWeekValue", weekRangeValues[0]);
        testContext.scenarioData.put("endWeekValue", weekRangeValues[1]);
    }

    @Then("^Verify that the current value is within the 52 week range values$")
    public void verifyValueWithinRange() {

        double startWeekValue = Double.parseDouble((String) testContext.scenarioData.get("startWeekValue"));
        double endWeekValue = Double.parseDouble((String) testContext.scenarioData.get("endWeekValue"));
        double currentValue = Double.parseDouble((String)testContext.scenarioData.get("currentValue"));

        Assertions.assertTrue(startWeekValue < currentValue && currentValue < endWeekValue,
                "The lastPrice value: " + currentValue + " is not within the expected range: "
                        + startWeekValue + " - " + endWeekValue);
    }

}
