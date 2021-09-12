package com.dobedkina.tests;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public class TestData {
    public static String gender = randomGender();
    public static String month = "May";
    public static String day = "12";
    public static String year = "2002";
    public static String subject1 = "Maths";
    public static String subject2 = "History";
    public static String hobby1 = "Sports";
    public static String hobby2 = "Reading";
    public static String hobby3 = "Music";
    public static String picture = "cat.jpg";
    public static String state = "NCR";
    public static String city = "Delhi";

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String phone = faker.number().digits(10);
    public static String address = faker.address().fullAddress();

    static private String randomGender() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        int randNumber = (int) (Math.random() * 3);
        return genders.get(randNumber);
    }


}
