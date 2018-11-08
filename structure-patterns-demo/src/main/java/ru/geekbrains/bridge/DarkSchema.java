package ru.geekbrains.bridge;

public class DarkSchema implements Schema {

    @Override
    public String getBackgroundColor() {
        return "DarkBackground";
    }

    @Override
    public String getBorderColor() {
        return "DarkBOrder";
    }

    @Override
    public String getTextColor() {
        return "DarkText";
    }
}
