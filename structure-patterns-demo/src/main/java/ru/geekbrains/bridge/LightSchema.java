package ru.geekbrains.bridge;

public class LightSchema implements Schema {

    @Override
    public String getBackgroundColor() {
        return "LightBk";
    }

    @Override
    public String getBorderColor() {
        return "LightBorder";
    }

    @Override
    public String getTextColor() {
        return "LightText";
    }
}
