package ru.geekbrains.decorator;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;

/**
 * Decorator pattern in Java core IO
 */
public class JavaIoExample {

    public static void main(String[] args) throws IOException {
        InputStream stream = JavaIoExample.class.getClassLoader().getResourceAsStream("file.txt.gz");
        BufferedInputStream bufferedStream = new BufferedInputStream(stream);
        GZIPInputStream gzipStream = new GZIPInputStream(bufferedStream);
        InputStreamReader reader = new InputStreamReader(gzipStream);
        BufferedReader bufferedReader = new BufferedReader(reader);

        System.out.println(bufferedReader.readLine());
    }
}
