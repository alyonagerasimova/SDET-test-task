package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseSeleniumPage;

import java.time.Duration;

public class TestSteps {
    WebDriver driver;

    public TestSteps(WebDriver driver) {
        this.driver = driver;
    }

    public TestSteps toUrl(String url) {
        driver.get(url);
        return this;
    }

    @Step("Выполнен клик по элементу: {0}")
    public TestSteps click(WebElement element) {
        element.click();
        return this;
    }

    @Step("Заполнено поле")
    public TestSteps fillInput(WebElement input, CharSequence... values) {
        input.sendKeys(values);
        return this;
    }

    @Step("Выполнен шаг: {0}")
    public TestSteps runCustomStep(String stepName, CustomStep step) {
        step.runStep();
        return this;
    }

    @Step("Ожидание загрузки страницы")
    public TestSteps waitLoaded(BaseSeleniumPage page, int seconds) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(id -> page.isLoaded(seconds));
        return this;
    }
}
