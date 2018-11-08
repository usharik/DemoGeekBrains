package ru.geekbrains.bridge;

import org.junit.Test;

public class TestBridge {

    @Test
    public void test() {
        Window windowLight = new Window(new LightSchema());
        Window windowDark = new Window(new DarkSchema());

        windowDark.draw();
        windowLight.draw();
    }
}
