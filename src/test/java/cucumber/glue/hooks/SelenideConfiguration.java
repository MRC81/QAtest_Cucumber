package cucumber.glue.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;
import static java.lang.Boolean.parseBoolean;


public class SelenideConfiguration {

    public void getBrowser(){
        String browser = System.getProperty("selenide.browser", "chrome");
//       boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = false;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "reports";

        Configuration.baseUrl = "https://www.investing.com";

        clearBrowserCache();
        WebDriverRunner.driver().clearCookies();
    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
