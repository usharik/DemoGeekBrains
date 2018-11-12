package ru.geekbrains.proxy.dynamic;

import ru.geekbrains.proxy.Repository;

class RepositoryImpl implements Repository {

    @Override
    public void save(Object obj) {
        System.out.println("Saving object " + obj);
    }

    @Override
    public void getAll(Object obj) {
        System.out.println("Getting all object" + obj);
    }

    @Override
    public void delete(Long id) {
        System.out.println("Deleting object with id " + id);
    }
}
