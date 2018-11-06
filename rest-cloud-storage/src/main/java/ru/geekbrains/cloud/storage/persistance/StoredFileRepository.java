package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.persistence.EntityManager;

public class StoredFileRepository extends CrudRepositoryImpl<Long, StoredFile> {

    StoredFileRepository(EntityManager entityManager) {
        super(entityManager, StoredFile.class);
    }
}
