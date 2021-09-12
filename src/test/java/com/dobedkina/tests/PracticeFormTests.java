package com.dobedkina.tests;

import com.codeborne.selenide.Configuration;
import com.dobedkina.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.dobedkina.tests.TestData.*;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void fillFormTest() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();

        practiceFormPage.openPage();

        practiceFormPage.setFirstName(firstName);
        practiceFormPage.setLastName(lastName);
        practiceFormPage.setEmail(email);
        practiceFormPage.selectGender(gender);
        practiceFormPage.setPhone(phone);
        practiceFormPage.calendar.setDate(year, month, day);
        practiceFormPage.setSubjects(subject1, subject2);
        practiceFormPage.selectHobbies(hobby1, hobby2, hobby3);
        practiceFormPage.selectPicture(picture);
        practiceFormPage.setAddress(address);
        practiceFormPage.selectStateAndCity(state, city);
        practiceFormPage.submitForm();

        practiceFormPage.checkIfFormIsOpened();
        practiceFormPage.checkFormFields(firstName, lastName, email, gender, phone, day, month,
                year, subject1, subject2, hobby1, hobby2, hobby3, picture, address, state, city);


    }
}
