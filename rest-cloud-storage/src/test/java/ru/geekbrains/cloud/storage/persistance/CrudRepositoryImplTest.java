package ru.geekbrains.cloud.storage.persistance;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.geekbrains.cloud.storage.persistance.api.CrudRepository;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CrudRepositoryImplTest {

    @Mock
    EntityManager entityManager;

    @Test
    public void testSave() {
        when(entityManager.getTransaction()).thenReturn(mock(EntityTransaction.class));
        CrudRepository<Long, StoredFile> crudRepository = new CrudRepositoryImpl<>(entityManager, StoredFile.class);

        StoredFile storedFile = new StoredFile();

        crudRepository.save(storedFile);

        verify(entityManager, times(1)).persist(storedFile);
    }

}
