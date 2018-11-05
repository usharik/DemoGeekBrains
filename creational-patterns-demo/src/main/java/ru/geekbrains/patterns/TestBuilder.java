package ru.geekbrains.patterns;

import ru.geekbrains.patterns.service.builder.Email;


public class TestBuilder {

    public static void main(String[] args) {
        Email email = Email.builder()
                .withFrom("from@mail.ru")
                .withTo("to@gmail.com")
                .withHeader("Header")
                .withText("Text")
                .build();
        System.out.println(email);

    }
}
