package com.dobedkina.tests;

import com.github.javafaker.Faker;

import java.util.Arrays;
import java.util.List;

public class TestData {
    private Faker faker = new Faker();

    private String gender;
    private String month;
    private String day;
    private String year;
    private String subject1;
    private String subject2;
    private String hobby1;
    private String hobby2;
    private String hobby3;
    private String picture;
    private String state;
    private String city;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;

    public TestData(String gender, String month, String day, String year, String subject1, String subject2,
                    String hobby1, String hobby2, String hobby3, String picture, String state, String city,
                    Faker faker, String firstName, String lastName, String email, String phone, String address) {
        this.gender = gender;
        this.month = month;
        this.day = day;
        this.year = year;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
        this.hobby3 = hobby3;
        this.picture = picture;
        this.state = state;
        this.city = city;
        this.faker = faker;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public TestData() {
        this.gender = randomGender();
        this.month = "May";
        this.day = "12";
        this.year = "2002";
        this.subject1 = "Maths";
        this.subject2 = "History";
        this.hobby1 = "Sports";
        this.hobby2 = "Reading";
        this.hobby3 = "Music";
        this.picture = "cat.jpg";
        this.state = "NCR";
        this.city = "Delhi";
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phone = faker.number().digits(10);
        this.address = faker.address().fullAddress();
    }

    public Faker getFaker() {
        return faker;
    }

    public String getGender() {
        return gender;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getSubject1() {
        return subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public String getHobby1() {
        return hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public String getHobby3() {
        return hobby3;
    }

    public String getPicture() {
        return picture;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
//    public static String gender = randomGender();
//    public static String month = "May";
//    public static String day = "12";
//    public static String year = "2002";
//    public static String subject1 = "Maths";
//    public static String subject2 = "History";
//    public static String hobby1 = "Sports";
//    public static String hobby2 = "Reading";
//    public static String hobby3 = "Music";
//    public static String picture = "cat.jpg";
//    public static String state = "NCR";
//    public static String city = "Delhi";

//    static Faker faker = new Faker();
//    public static String firstName = faker.name().firstName();
//    public static String lastName = faker.name().lastName();
//    public static String email = faker.internet().emailAddress();
//    public static String phone = faker.number().digits(10);
//    public static String address = faker.address().fullAddress();

    static private String randomGender() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        int randNumber = (int) (Math.random() * 3);
        return genders.get(randNumber);
    }


}
