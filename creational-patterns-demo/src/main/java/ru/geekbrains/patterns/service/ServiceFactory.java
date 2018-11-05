package ru.geekbrains.patterns.service;

public interface ServiceFactory {

    Service createService();

    SubService1 createSubService1();
}
