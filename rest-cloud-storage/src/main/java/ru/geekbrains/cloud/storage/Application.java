package ru.geekbrains.cloud.storage;

import org.eclipse.jetty.server.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.cloud.storage.persistance.api.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactoryProvider;

import java.io.Closeable;

public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private Closeable closeable;

    private Server jettyServer;

    public Application(RepositoryFactory repositoryFactory, JettyServerFactory jettyServerFactory) {
        this.closeable = repositoryFactory.getCloseable();
        this.jettyServer = jettyServerFactory.getJettyServer();
    }

    public void execute() throws Exception {
        try {
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
