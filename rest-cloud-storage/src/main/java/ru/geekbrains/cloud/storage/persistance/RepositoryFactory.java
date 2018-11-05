package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.entity.OrmEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Closeable;

public class RepositoryFactory {

    private final EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("RestStorageClient");

    public <K, E extends OrmEntity<K>> CrudRepository<K, E> getCrudRepository(Class<E> clazz) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return (CrudRepository<K, E>) new CrudRepositoryImpl(entityManager, clazz);
    }

    public Closeable getCloseable() {
        return () -> entityManagerFactory.close();
    }
}
