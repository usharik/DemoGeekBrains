package ru.geekbrains.cloud.storage;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.cloud.storage.persistance.CrudRepository;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactoryProvider;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import java.io.Closeable;
import java.util.List;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private CrudRepository<Long, StoredFile> storedFileRepository;

    private Closeable closeable;

    private Server jettyServer;

    public Application(RepositoryFactory repositoryFactory, JettyServerFactory jettyServerFactory) {
        this.storedFileRepository = repositoryFactory.getStoredFileRepository();
        this.closeable = repositoryFactory.getCloseable();
        this.jettyServer = jettyServerFactory.getJettyServer();
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

            jettyServer.start();
            jettyServer.join();
        } catch (Exception ex) {
            logger.error("Exception", ex);
        } finally {
            closeable.close();
            jettyServer.destroy();
        }
    }

    public static void main(String[] args) throws Exception {
        Application application = new Application(RepositoryFactoryProvider.provide(), new JettyServerFactory());
        application.execute();
    }
}
