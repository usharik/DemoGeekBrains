package ru.geekbrains.cloud.storage.persistance;

import ru.geekbrains.cloud.storage.persistance.api.StoredFileRepository;
import ru.geekbrains.cloud.storage.persistance.entity.StoredFile;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


class StoredFileRepositoryImpl extends CrudRepositoryImpl<Long, StoredFile>
        implements StoredFileRepository {

    StoredFileRepositoryImpl(EntityManager entityManager) {
        super(entityManager, StoredFile.class);
    }

    @Override
    public List<StoredFile> getFileList() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StoredFile> query = criteriaBuilder.createQuery(clazz);
        Root<StoredFile> root = query.from(clazz);
        query.multiselect(root.get("id"), root.get("fileName"), root.get("createDate"), root.get("updateDate"));

        return runInTransaction(() -> entityManager.createQuery(query)
                .getResultList());
    }

    @Override
    public StoredFile getByName(String fileName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<StoredFile> query = criteriaBuilder.createQuery(clazz);
        Root<StoredFile> root = query.from(clazz);
        query.select(root)
                .where(criteriaBuilder.equal(root.get("fileName"), fileName));

        return runInTransaction(() -> entityManager.createQuery(query)
                .getSingleResult());
    }
}
