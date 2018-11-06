package ru.geekbrains.cloud.storage.rest;

import ru.geekbrains.cloud.storage.persistance.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/entry-point")
public class Controller {

    RepositoryFactory repositoryFactory = new RepositoryFactory();

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoredFile> test() {
        return repositoryFactory.getCrudRepository(StoredFile.class).findAll();
    }
}
