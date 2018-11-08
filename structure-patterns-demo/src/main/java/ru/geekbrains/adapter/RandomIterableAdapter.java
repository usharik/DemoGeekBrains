package ru.geekbrains.adapter;

import java.util.Iterator;
import java.util.Random;

/**
 * Адаптер уровня объекта
 *
 * использует композицию
 */
public class RandomIterableAdapter implements Iterable<Integer> {

    private RandomIterator randomIterator;

    public RandomIterableAdapter(Random random) {
        this.randomIterator = new RandomIterator(random);
    }

    @Override
    public Iterator<Integer> iterator() {
        return randomIterator;
    }

    private static class RandomIterator implements Iterator<Integer> {

        private final Random random;

        public RandomIterator(Random random) {
            this.random = random;
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Integer next() {
            return random.nextInt();
        }
    }

}
