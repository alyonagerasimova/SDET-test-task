package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import pages.FormPage;
import pages.ModalPage;
import utils.Constants;

@Epic("Форма регистрации")
@Feature("Тесты формы регистрации")
public class FormRegistrationTest extends BaseTest {
    @Test
    @AllureId(value = "1")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Заполнение формы регистрации")
    public void testPracticeForm() {
        FormPage form = new FormPage();
        ModalPage modal = new ModalPage();

        steps
                .toUrl(Constants.URL)
                .runCustomStep("Проверка открытия формы", () -> {
                    Assertions.assertTrue(form.getForm().isDisplayed());
                })
                .runCustomStep("Заполнение ФИО", () -> {
                    steps.fillInput(form.getFirstName(), Constants.FIRST_NAME)
                            .fillInput(form.getLastName(), Constants.LAST_NAME);
                })
                .fillInput(form.getEmail(), Constants.EMAIL)
                .runCustomStep("Выбор гендера", () -> {
                    steps.click( form.getGender(FormPage.Gender.MALE));
                })
                .fillInput(form.getNumber(), Constants.MOBILE)
                .runCustomStep("Заполение даты", () -> {
                    steps.click(form.getDateField());
                    form.selectMonthAndYear(Constants.MONTH, Constants.YEAR);
                    steps.click(form.getDay());
                })
                .runCustomStep("Выбор предметов", () -> {
                    var subjectsInput = form.getSubject();
                    steps.fillInput(subjectsInput, Constants.SUBJECTS)
                            .fillInput(subjectsInput, Keys.TAB);
                })
                .runCustomStep("Выбор хобби", () -> {
                    steps.click(form.getHobby(Constants.NUMBER_OF_HOBBY));
                })
                .fillInput(form.getFile(), Constants.FILE_PATH)
                .fillInput(form.getAddress(), Constants.ADDRESS)
                .runCustomStep("Заполнение региона и города", () -> {
                    steps.click(form.getStateField())
                            .click(form.getStateValue(Constants.STATE))
                            .click(form.getCityField())
                            .click(form.getCityValue(Constants.CITY));
                })
                .click(form.getSubmitBtn())
                .waitLoaded(modal, 2)
                .runCustomStep("Проверка модального окна", () -> {
                    checkTitle(modal);
                    checkModalTable(modal, form);
                });
    }

    @Step("Проверка заголовка модального окна")
    public static void checkTitle(ModalPage modal) {
        Assertions.assertEquals("Thanks for submitting the form", modal.getTitle());
    }

    @Step("Проверка полей модального окна")
    public static void checkModalTable(ModalPage modal, FormPage form) {
        Assertions.assertEquals(Constants.FIRST_NAME + " " + Constants.LAST_NAME, modal.getName());
        Assertions.assertEquals(Constants.EMAIL, modal.getEmail());
        Assertions.assertEquals(form.getGender(FormPage.Gender.MALE).getText(), modal.getGender());
        Assertions.assertEquals(Constants.MOBILE, modal.getMobile());
        Assertions.assertEquals(Constants.DAY + " " + Constants.MONTH + "," + Constants.YEAR, modal.getDate());
        Assertions.assertEquals(Constants.SUBJECTS, modal.getSubjects());
        Assertions.assertEquals(form.getHobby(Constants.NUMBER_OF_HOBBY).getText(), modal.getHobbies());
        Assertions.assertEquals(Constants.FILE_NAME, modal.getPicture());
        Assertions.assertEquals(Constants.ADDRESS, modal.getAddress());
        Assertions.assertEquals(Constants.STATE + " " + Constants.CITY, modal.getStateAndCity());

    }
}
