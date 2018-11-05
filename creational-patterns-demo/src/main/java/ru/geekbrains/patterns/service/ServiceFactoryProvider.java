package ru.geekbrains.patterns.service;

public class ServiceFactoryProvider {

    public static ServiceFactory provideServiceFactory() {
        return new ServiceFactoryImp();
    }
}
