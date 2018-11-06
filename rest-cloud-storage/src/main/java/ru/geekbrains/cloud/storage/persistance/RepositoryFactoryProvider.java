package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.api.RepositoryFactory;

public class RepositoryFactoryProvider {

    private static RepositoryFactory repositoryFactoryInstance;

    public static RepositoryFactory provide() {
        if (repositoryFactoryInstance == null) {
            repositoryFactoryInstance = new RepositoryFactoryImpl();
        }
        return repositoryFactoryInstance;
    }
}
