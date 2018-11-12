package ru.geekbrains.decorator;

public class BaseOperation implements Operation {

    @Override
    public void perform() {
        System.out.println("Base Operation");
    }
}
