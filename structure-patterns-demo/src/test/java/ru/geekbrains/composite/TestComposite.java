package ru.geekbrains.composite;

import org.junit.Test;
import ru.geekbrains.composit.Composite;
import ru.geekbrains.composit.FirstOperation;
import ru.geekbrains.composit.SecondOperation;

public class TestComposite {

    @Test
    public void test() {
        Composite composite = new Composite();
        composite.addOperation(new FirstOperation());
        composite.addOperation(new SecondOperation());
        composite.perform();
    }
}
