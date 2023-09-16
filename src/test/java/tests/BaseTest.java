package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.BaseSeleniumPage;
import steps.TestSteps;
import utils.Constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected TestSteps steps;

    public static String remote_url_chrome = "http://localhost:4444/wd/hub";

    @Step("Configure driver")
    @BeforeEach
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(Constants.ARGUMENT_OPTIONS);

        driver = new RemoteWebDriver(new URL(remote_url_chrome), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));

        BaseSeleniumPage.setDriver(driver);
        steps = new TestSteps(driver);
    }


    @Step("Stop driver")
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
