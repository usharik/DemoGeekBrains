package ru.geekbrains.cloud.storage.persistance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.geekbrains.cloud.storage.persistance.api.CrudRepository;
import ru.geekbrains.cloud.storage.persistance.entity.OrmEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.function.Supplier;

class CrudRepositoryImpl<K, E extends OrmEntity<K>> implements CrudRepository<K, E> {

    private static final Logger logger = LoggerFactory.getLogger(CrudRepositoryImpl.class);

    protected final EntityManager entityManager;
    protected final Class<E> clazz;

    CrudRepositoryImpl(EntityManager entityManager, Class<E> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    @Override
    public void save(E entity) {
        runInTransaction(() -> entityManager.persist(entity));
    }

    @Override
    public void delete(E entity) {
        runInTransaction(() -> entityManager.remove(entity));
    }

    @Override
    public E findById(K id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<E> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> query = criteriaBuilder.createQuery(clazz);
        query.select(query.from(clazz));

        return runInTransaction(() -> entityManager.createQuery(query).getResultList());
    }

    protected void runInTransaction(Runnable action) {
        runInTransaction(() -> {
            action.run();
            return null;
        });
    }

    protected  <Q> Q runInTransaction(Supplier<Q> supplier) {
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Q result = supplier.get();

            transaction.commit();
            return result;
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.error("Exception", ex);
            return null;
        }
    }
}
