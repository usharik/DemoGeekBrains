package ru.geekbrains.cloud.storage.rest;

import org.apache.commons.io.IOUtils;
import ru.geekbrains.cloud.storage.persistance.RepositoryFactoryProvider;
import ru.geekbrains.cloud.storage.persistance.api.RepositoryFactory;
import ru.geekbrains.cloud.storage.persistance.api.StoredFileRepository;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Path("/v1/file/")
public class Controller {

    RepositoryFactory repositoryFactory = RepositoryFactoryProvider.provide();

    StoredFileRepository storedFileRepository = repositoryFactory.getStoredFileRepository();

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StoredFile> listAllFiles() {
        return storedFileRepository.getFileList();
    }

    @POST
    @Path("/path/{fileName}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    public Response createFiles(@PathParam("fileName") String fileName, InputStream data) throws IOException {
        StoredFile storedFile = storedFileRepository.getByName(fileName);
        if (storedFile == null) {
            storedFile = new StoredFile();
            storedFile.setFileName(fileName);
            storedFile.setFileData(IOUtils.toByteArray(data));
            storedFile.setCreateDate(Date.from(Instant.now()));
        } else {
            storedFile.setFileData(IOUtils.toByteArray(data));
            storedFile.setUpdateDate(Date.from(Instant.now()));
        }
        storedFileRepository.save(storedFile);
        return Response.accepted().build();
    }

    @GET
    @Path("/path/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getFile(@PathParam("fileName") String fileName) {
        StoredFile storedFile = storedFileRepository.getByName(fileName);
        if (storedFile == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response
                .ok(storedFile.getFileData(), MediaType.APPLICATION_OCTET_STREAM)
                .build();
    }

    @DELETE
    @Path("/path/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response deleteFile(@PathParam("fileName") String fileName) {
        StoredFile storedFile = storedFileRepository.getByName(fileName);
        if (storedFile == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        storedFileRepository.delete(storedFile);
        return Response.accepted().build();
    }
}
