package ru.geekbrains.patterns;

import ru.geekbrains.patterns.service.Service;
import ru.geekbrains.patterns.service.ServiceFactory;
import ru.geekbrains.patterns.service.ServiceFactoryProvider;

public class App {

    private static ServiceFactory serviceFactory =
            ServiceFactoryProvider.provideServiceFactory();

    public static void main(String[] args) {
        Service service = serviceFactory.createService();
        service.action();
    }
}
