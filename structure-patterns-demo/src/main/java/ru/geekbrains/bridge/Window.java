package ru.geekbrains.bridge;

public class Window extends View {

    public Window(Schema schema) {
        super(schema);
    }

    @Override
    public void draw() {
        System.out.println("Window background is " + schema.getBackgroundColor());
    }
}
