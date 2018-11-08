package ru.geekbrains.adapter;

import java.util.Iterator;
import java.util.Random;

/**
 * Адаптер уровня объекта
 *
 * использует композицию
 */
public class RandomIterableAdapter implements Iterable<Integer> {

    private Random random;

    public RandomIterableAdapter(Random random) {
        this.random = random;
    }

    // Here is factory method pattern
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt();
            }
        };
    }
}
