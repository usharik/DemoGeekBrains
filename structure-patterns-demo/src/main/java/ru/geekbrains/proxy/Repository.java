package ru.geekbrains.proxy;

public interface Repository {

    void save(Object obj);

    void getAll(Object obj);

    void delete (Long id);
}
