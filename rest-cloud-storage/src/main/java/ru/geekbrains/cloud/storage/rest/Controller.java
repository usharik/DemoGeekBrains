package ru.geekbrains.cloud.storage.rest;

import ru.geekbrains.cloud.storage.persistance.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactoryProvider;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/v1/file/")
public class Controller {

    RepositoryFactory repositoryFactory = RepositoryFactoryProvider.provide();

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoredFile> test() {
        return repositoryFactory.getStoredFileRepository().findAll();
    }
}
