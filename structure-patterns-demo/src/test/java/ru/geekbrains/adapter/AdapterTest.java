package ru.geekbrains.adapter;

import org.junit.Test;

import java.util.Random;

public class AdapterTest {

    @Test
    public void test() {
        Random random = new Random();
        RandomIterableAdapter randomIterableAdapter =
                new RandomIterableAdapter(random);

        System.out.println("RandomIterableAdapter\n");
        int cnt=0;
        for (Integer num : randomIterableAdapter) {
            System.out.println(num);
            if (cnt++ > 10) {
                break;
            }
        }

        RandomIterableClassAdapter classAdapter =
                new RandomIterableClassAdapter();

        System.out.println("\nRandomIterableClassAdapter\n");
        cnt=0;
        for (Integer num : classAdapter) {
            System.out.println(num);
            if (cnt++ > 10) {
                break;
            }
        }
    }
}
