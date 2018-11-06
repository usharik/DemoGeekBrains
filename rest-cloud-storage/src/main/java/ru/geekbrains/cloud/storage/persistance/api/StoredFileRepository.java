package ru.geekbrains.cloud.storage.persistance.api;

import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import java.util.List;

public interface StoredFileRepository extends CrudRepository<Long, StoredFile> {

    List<StoredFile> getFileList();

    StoredFile getByName(String fileName);
}
