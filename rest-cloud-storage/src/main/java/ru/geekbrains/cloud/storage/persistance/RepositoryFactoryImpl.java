package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;


class RepositoryFactoryImpl implements RepositoryFactory {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("RestStorageClient");

    private CrudRepository<Long, StoredFile> storedFileRepositoryInstance;

    public CrudRepository<Long, StoredFile> getStoredFileRepository() {
        if (storedFileRepositoryInstance == null) {
            storedFileRepositoryInstance = new StoredFileRepository(entityManagerFactory.createEntityManager());
        }
        return storedFileRepositoryInstance;
    }

    public Closeable getCloseable() {
        return entityManagerFactory::close;
    }
}
