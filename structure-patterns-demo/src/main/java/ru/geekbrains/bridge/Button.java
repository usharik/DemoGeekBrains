package ru.geekbrains.bridge;

public class Button extends View {

    public Button(Schema schema) {
        super(schema);
    }

    @Override
    public void draw() {
        System.out.println("Button background is " + schema.getBackgroundColor());
        System.out.println("Button border is " + schema.getBackgroundColor());
    }
}
