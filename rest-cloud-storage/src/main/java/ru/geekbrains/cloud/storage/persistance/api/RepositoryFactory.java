package ru.geekbrains.cloud.storage.persistance.api;

import java.io.Closeable;

public interface RepositoryFactory {

    StoredFileRepository getStoredFileRepository();

    Closeable getCloseable();
}
