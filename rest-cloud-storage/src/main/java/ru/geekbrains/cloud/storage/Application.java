package ru.geekbrains.cloud.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.cloud.storage.persistance.CrudRepository;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import java.io.Closeable;
import java.util.List;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private CrudRepository<Long, StoredFile> storedFileRepository;

    private Closeable closeable;

    public Application(RepositoryFactory repositoryFactory) {
        this.storedFileRepository = repositoryFactory.getCrudRepository(StoredFile.class);
        this.closeable = repositoryFactory.getCloseable();
    }

    public void execute() throws Exception {
        try {
            StoredFile storedFile = new StoredFile();
            storedFile.setFileName("fileName");
            storedFileRepository.save(storedFile);

            storedFile = new StoredFile();
            storedFile.setFileName("fileName1");
            storedFileRepository.save(storedFile);

            List<StoredFile> all = storedFileRepository.findAll();

            System.out.println("!!! ----------------" + all);
        } finally {
            closeable.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Application application = new Application(new RepositoryFactory());
        application.execute();
    }
}
