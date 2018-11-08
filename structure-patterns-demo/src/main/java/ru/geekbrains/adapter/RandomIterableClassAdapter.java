package ru.geekbrains.adapter;

import java.util.Iterator;
import java.util.Random;

/**
 * Адаптер уровня объекта
 *
 * использует наследование
 */
public class RandomIterableClassAdapter extends Random implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return nextInt();
            }
        };
    }
}
