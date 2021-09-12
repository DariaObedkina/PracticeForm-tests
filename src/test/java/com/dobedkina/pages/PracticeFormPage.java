package com.dobedkina.pages;

import com.codeborne.selenide.Condition;
import com.dobedkina.pages.components.Calendar;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPage extends Calendar {
    private final String PAGE_LINK = "/automation-practice-form";
    private final String FORM_TITLE = "Student Registration Form";
    private final String SUBMITTED_FORM_TITLE = "Thanks for submitting the form";
    public Calendar calendar = new Calendar();

    public void openPage() {
        open(PAGE_LINK);
        $(".practice-form-wrapper").shouldHave(Condition.text(FORM_TITLE));
    }

    //Заполнение формы
    public void setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
    }

    public void setLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    public void setEmail(String email) {
        $("#userEmail").setValue(email);
    }

    public void selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
    }

    public void setPhone(String phone) {
        $("#userNumber").setValue(phone);
    }

    public void setSubjects(String subject1, String subject2) {
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
    }

    public void selectHobbies(String hobby1, String hobby2, String hobby3) {
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
    }

    public void selectPicture(String picture) {
        $("#uploadPicture").uploadFromClasspath(picture);
    }

    public void setAddress(String address) {
        $("#currentAddress").setValue(address);
    }

    public void selectStateAndCity(String state, String city) {
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
    }

    public void submitForm() {
        $("#submit").click();
    }

    //Проверка заполненной формы
    public void checkIfFormIsOpened() {
        $("#example-modal-sizes-title-lg").shouldHave(Condition.text(SUBMITTED_FORM_TITLE));
    }

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
