package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage extends BaseSeleniumPage {

    public static class Gender {
        public static By MALE = By.cssSelector("label[for='gender-radio-1']");
        public static By FEMALE = By.cssSelector("label[for='gender-radio-2']");
        public static By OTHER = By.cssSelector("label[for='gender-radio-3']");
    }

    public By firstNameField = By.id("firstName");
    public By lastNameField = By.xpath("//*[@id=\"lastName\"]");
    public By emailField = By.id("userEmail");
    public By numberField = By.id("userNumber");
    public By dateField = By.id("dateOfBirthInput");
    public By dayValue = By.xpath("//*[@id='dateOfBirth']//div[text()='28']");
    public By subjectsField = By.id("subjectsInput");
    public By fileInput = By.cssSelector("input[type=file]");
    public By addressField = By.xpath("//*[@id=\"currentAddress\"]");
    public By stateField = By.xpath("//*[@id=\"state\"]/div");
    public By cityField = By.xpath("//*[@id=\"city\"]");
    public By submitButton = By.id("submit");

    @Override
    public boolean isLoaded(int seconds) {
        return !getForm().isDisplayed();
    }

    public WebElement getForm() {
        return driver.findElement(By.id("userForm"));
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameField);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameField);
    }

    public WebElement getEmail() {
        return driver.findElement(emailField);
    }

    public WebElement getGender(By genderSelector) {
        return driver.findElement(genderSelector);
    }

    public WebElement getNumber() {
        return driver.findElement(numberField);
    }

    public WebElement getDateField() {
        return driver.findElement(dateField);
    }

    public WebElement getDay() {
        return driver.findElement(dayValue);
    }

    public WebElement getSubject() {
        return driver.findElement(subjectsField);
    }

    public WebElement getHobby(String number) {
        return driver.findElement(By.cssSelector("label[for='hobbies-checkbox-" + number + "']"));
    }

    public WebElement getFile() {
        return driver.findElement(fileInput);
    }

    public WebElement getAddress() {
        return driver.findElement(addressField);
    }

    public WebElement getStateField() {
        return driver.findElement(stateField);
    }

    public WebElement getStateValue(String value) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
    }

    public WebElement getCityField() {
        return driver.findElement(cityField);
    }

    public WebElement getCityValue(String value) {
        return driver.findElement(By.xpath("//*[contains(text(), '" + value + "')]"));
    }

    public WebElement getSubmitBtn() {
        return driver.findElement(submitButton);
    }


    @Step
    public void selectMonthAndYear(String month, String year) {
        var monthSelect = new Select(driver.findElement(By.cssSelector(".react-datepicker__month-select")));
        monthSelect.selectByVisibleText(month);

        var yearSelect = new Select(driver.findElement(By.cssSelector(".react-datepicker__year-select")));
        yearSelect.selectByVisibleText(year);
    }
}
