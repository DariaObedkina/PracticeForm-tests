package com.dobedkina.pages;

import com.codeborne.selenide.Condition;
import com.dobedkina.pages.components.Calendar;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends Calendar {
    private final String PAGE_LINK = "https://demoqa.com/automation-practice-form";
    private final String FORM_TITLE = "Student Registration Form";
    private final String SUBMITTED_FORM_TITLE = "Thanks for submitting the form";
    public Calendar calendar = new Calendar();

    public void openPage() {
        open(PAGE_LINK);
        $(".practice-form-wrapper").shouldHave(Condition.text(FORM_TITLE));
    }

    @Step("Ввести имя")
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    @Step("Ввести фамилию")
    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @Step("Ввести email")
    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @Step("Выбрать пол")
    public void selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    @Step("Ввести телефон")
    public void setPhone(String phone) {
        $("#userNumber").setValue(phone);
    }

    @Step("Ввести предметы")
    public void setSubjects(String subject1, String subject2) {
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
    }

    @Step("Выбрать хобби")
    public void selectHobbies(String hobby1, String hobby2, String hobby3) {
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
    }

    @Step("Загрузить картинку")
    public void selectPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath("img/" + picture);
    }

    @Step("Ввести текущий адрес")
    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    @Step("Выбрать штат и город")
    public void selectStateAndCity(String state, String city) {
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
    }

    @Step("Сохранить форму")
    public void submitForm() {
        $("#submit").click();
    }

    @Step("Форма отображается на странице")
    public void checkIfFormIsOpened() {
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(SUBMITTED_FORM_TITLE));
    }

    @Step("Поля на форме заполнены введенными ранее значениями")
    public void checkFormFields(String firstName, String lastName, String email, String gender, String phone,
                                String day, String month, String year, String subject1, String subject2,
                                String hobby1, String hobby2, String hobby3, String picture, String address,
                                String state, String city) {

        $x("//td[.='Student Name']/following-sibling::td").shouldHave(Condition.text(firstName + " " + lastName));
        $x("//td[.='Student Email']/following-sibling::td").shouldHave(Condition.text(email));
        $x("//td[.='Gender']/following-sibling::td").shouldHave(Condition.text(gender));
        $x("//td[.='Mobile']/following-sibling::td").shouldHave(Condition.text(phone));
        $x("//td[.='Date of Birth']/following-sibling::td").shouldHave(Condition.text(day + " " + month + "," + year));
        $x("//td[.='Subjects']/following-sibling::td").shouldHave(Condition.text(subject1 + ", " + subject2));
        $x("//td[.='Hobbies']/following-sibling::td").shouldHave(Condition.text(hobby1 + ", " + hobby2 + ", " + hobby3));
        $x("//td[.='Picture']/following-sibling::td").shouldHave(Condition.text(picture));
        $x("//td[.='Address']/following-sibling::td").shouldHave(Condition.text(address));
        $x("//td[.='State and City']/following-sibling::td").shouldHave(Condition.text(state + " " + city));
    }


}
