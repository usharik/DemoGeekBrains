package ru.geekbrains.decorator;

public abstract class Decorator implements Operation {

    private final Operation decorated;

    public Decorator(Operation decorated) {
        this.decorated = decorated;
    }

    @Override
    public abstract void perform();
}
