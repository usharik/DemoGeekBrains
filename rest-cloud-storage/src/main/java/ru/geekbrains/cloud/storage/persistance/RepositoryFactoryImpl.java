package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.api.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.api.StoredFileRepository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;


class RepositoryFactoryImpl implements RepositoryFactory {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("RestStorageClient");

    private StoredFileRepository storedFileRepositoryInstance;

    public StoredFileRepository getStoredFileRepository() {
        if (storedFileRepositoryInstance == null) {
            storedFileRepositoryInstance = new StoredFileRepositoryImpl(entityManagerFactory.createEntityManager());
        }
        return storedFileRepositoryInstance;
    }

    public Closeable getCloseable() {
        return entityManagerFactory::close;
    }
}
