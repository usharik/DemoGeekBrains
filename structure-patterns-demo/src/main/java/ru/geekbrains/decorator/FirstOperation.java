package ru.geekbrains.decorator;

public class FirstOperation implements Operation {

    @Override
    public void perform() {
        System.out.println("Operation 1");
    }
}
