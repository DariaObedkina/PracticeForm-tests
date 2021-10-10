package com.dobedkina.tests;

import com.dobedkina.pages.PracticeFormPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Feature("Practice form")
@Owner("Daria Obedkina")
public class PracticeFormTests extends TestBase {

    @Test
    @Tag("practice_form")
    void fillFormTest() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        TestData testData = new TestData();

        practiceFormPage.openPage();

        practiceFormPage.setFirstName(testData.getFirstName());
        practiceFormPage.setLastName(testData.getLastName());
        practiceFormPage.setEmail(testData.getEmail());
        practiceFormPage.selectGender(testData.getGender());
        practiceFormPage.setPhone(testData.getPhone());
        practiceFormPage.calendar.setDate(testData.getYear(), testData.getMonth(), testData.getDay());
        practiceFormPage.setSubjects(testData.getSubject1(), testData.getSubject2());
        practiceFormPage.selectHobbies(testData.getHobby1(), testData.getHobby2(), testData.getHobby3());
        practiceFormPage.selectPicture(testData.getPicture());
        practiceFormPage.setAddress(testData.getAddress());
        practiceFormPage.selectStateAndCity(testData.getState(), testData.getCity());
        practiceFormPage.submitForm();

        practiceFormPage.checkIfFormIsOpened();
        practiceFormPage.checkFormFields(testData.getFirstName(), testData.getLastName(), testData.getEmail(), testData.getGender(),
                testData.getPhone(), testData.getDay(), testData.getMonth(), testData.getYear(),
                testData.getSubject1(), testData.getSubject2(), testData.getHobby1(), testData.getHobby2(),
                testData.getHobby3(), testData.getPicture(), testData.getAddress(), testData.getState(), testData.getCity());


    }
}
