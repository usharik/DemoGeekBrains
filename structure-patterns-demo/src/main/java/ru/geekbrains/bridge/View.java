package ru.geekbrains.bridge;

public abstract class View {

    protected final Schema schema;

    public View(Schema schema) {
        this.schema = schema;
    }

    public abstract void draw();
}
