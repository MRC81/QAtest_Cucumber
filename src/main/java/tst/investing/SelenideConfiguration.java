package tst.investing;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Boolean.parseBoolean;
import static tst.investing.Infrastructure.Utilities.setSelenideProperties;


public class SelenideConfiguration {

    public void getBrowser(){
        String browser = System.getProperty("selenide.browser", "chrome");
        boolean headless = parseBoolean(System.getProperty("selenide.headless", "false"));

        Configuration.browser = browser;
        Configuration.headless = headless;
        Configuration.baseUrl = "https://www.investing.com";

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");

        Configuration.browserCapabilities = options;

        setSelenideProperties();
    }

    public void closeSession(){
        WebDriverRunner.closeWebDriver();
    }
}
