package ru.nerology.delivery.test;

import java.time.LocalDate;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    private DataGenerator() {

    }

    static Faker faker = new Faker((new Locale("ru")));

    public static String generateCity() {
        var cities = new String[]{
                "Санкт-Петербург", "Казань", "Москва", "Ижевск", "Владивосток",
                "Хабаровск", "Нижний Новгород", "Калининград", "Севастополь", "Краснодар"};
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        return faker.name().fullName();
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));

        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}

