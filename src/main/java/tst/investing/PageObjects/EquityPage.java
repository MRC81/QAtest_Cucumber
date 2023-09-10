package tst.investing.PageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import tst.investing.hooks.Infrastructure.LogLevel;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static tst.investing.Infrastructure.Utilities.logAndGetString;


public class EquityPage {
    private final SelenideElement currentValue = $("[data-test='open']");
    private final SelenideElement weekRange = $("[data-test='weekRange']");


    public void navigateTo(String uri) {
        try {
            open(uri);
        } catch (Exception e) {
            throw new IllegalStateException(logAndGetString(LogLevel.ERROR, "Unable to open '" + uri + "' page, " +
                    "see the traces: \n" + e));
        }

    }

    public double getEquityOpenValue() {
        try {
            return  Double.parseDouble(currentValue.shouldBe(Condition.visible).getText());
        } catch (Exception e) {
            throw new IllegalStateException(logAndGetString(LogLevel.ERROR, "Unable to get Equity open value, " +
                    "see the traces: \n" + e));
        }
    }

    public Map<String, Double> getEquity52WeekRangeValues() {
        try {
            String[] weekRangeValues = weekRange.shouldBe(visible).getText().split("-");

            return  Map.of(
                    "startWeekValue", Double.parseDouble(weekRangeValues[0]),
                    "endWeekValue", Double.parseDouble(weekRangeValues[1])
                    );
        } catch (Exception e) {
            throw new IllegalStateException(logAndGetString(LogLevel.ERROR, "Unable to get Equity 52 week range value, " +
                    "see the traces: \n" + e));
        }
    }



}
