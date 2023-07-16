package tst.investing.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import static tst.investing.hooks.Infrastructure.Utilities.setSelenideProperties;
import static java.lang.Boolean.parseBoolean;


public class SelenideConfiguration {

    public void getBrowser(){
        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.baseUrl = "https://www.investing.com";

        setSelenideProperties();

    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
