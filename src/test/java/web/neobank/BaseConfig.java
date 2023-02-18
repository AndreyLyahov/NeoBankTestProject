package web.neobank;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;

public class BaseConfig {

    @BeforeSuite
    public void beforeSuite() {
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = "chrome";
        HashMap<String, Object> chromePrefs = new HashMap<>();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--verbose");
        options.addArguments("--disable-gpu");
        options.addArguments("--lang=en");
        options.addArguments("--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().manage().deleteAllCookies();
        WebDriverRunner.getWebDriver().get("about:blank");
    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        WebDriverRunner.closeWebDriver();
    }
}
