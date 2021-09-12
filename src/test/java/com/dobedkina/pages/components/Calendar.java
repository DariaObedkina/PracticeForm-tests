package com.dobedkina.pages.components;

import com.dobedkina.tests.TestData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Calendar {
    public void setDate(String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").$(byText(TestData.month)).click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").$(byText(TestData.year)).click();
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
    }
}
