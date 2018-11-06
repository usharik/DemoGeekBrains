package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import java.io.Closeable;

public interface RepositoryFactory {

    CrudRepository<Long, StoredFile> getStoredFileRepository();

    Closeable getCloseable();
}
