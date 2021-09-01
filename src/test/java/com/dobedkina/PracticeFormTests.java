package com.dobedkina;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Ivan";
        String lastName = "Ivanov";
        String email = "test@test.test";
        String gender  = "Male";
        String month = "May";
        String day = "12";
        String year = "2002";
        String phone = "1234567890";
        String subject1 = "Maths";
        String subject2 = "History";
        String hobby1 = "Sports";
        String hobby2 = "Reading";
        String hobby3 =  "Music";
        String address = "Moscow, Test str., 15";
        String state = "NCR";
        String city = "Delhi";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(year)).click();
        $(byText(day)).click();
        $("#subjectsInput").setValue(subject1).pressEnter();
        $("#subjectsInput").setValue(subject2).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#hobbiesWrapper").$(byText(hobby3)).click();
        $("#uploadPicture").uploadFromClasspath("cat.jpg");
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();


        $x("//td[.='Student Name']/following-sibling::td").shouldHave(Condition.text(firstName + " " + lastName));
        $x("//td[.='Student Email']/following-sibling::td").shouldHave(Condition.text(email));
        $x("//td[.='Gender']/following-sibling::td").shouldHave(Condition.text(gender));
        $x("//td[.='Mobile']/following-sibling::td").shouldHave(Condition.text(phone));
        $x("//td[.='Date of Birth']/following-sibling::td").shouldHave(Condition.text(day + " " + month + "," + year));
        $x("//td[.='Subjects']/following-sibling::td").shouldHave(Condition.text(subject1 + ", " + subject2));
        $x("//td[.='Hobbies']/following-sibling::td").shouldHave(Condition.text( hobby1 + ", " + hobby2 + ", " +hobby3));
        $x("//td[.='Picture']/following-sibling::td").shouldHave(Condition.text("cat.jpg"));
        $x("//td[.='Address']/following-sibling::td").shouldHave(Condition.text(address));
        $x("//td[.='State and City']/following-sibling::td").shouldHave(Condition.text(state + " " + city));
    }
}
