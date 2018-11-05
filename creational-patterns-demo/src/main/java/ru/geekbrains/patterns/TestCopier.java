package ru.geekbrains.patterns;


import ru.geekbrains.patterns.service.factory.method.FromFileToStdOutputCopier;

import java.io.IOException;

public class TestCopier {

    public static void main(String[] args) throws IOException {
        FromFileToStdOutputCopier copier = new FromFileToStdOutputCopier("/Users/macbook/IdeaProjects/DemoGeekBrains/creational-patterns-demo/src/main/java/ru/geekbrains/patterns/TestCopier.java");
        copier.copyData();
    }
}
