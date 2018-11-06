package ru.geekbrains.cloud.storage.persistance.api;

import ru.geekbrains.cloud.storage.persistance.entity.OrmEntity;

import java.util.List;

public interface CrudRepository<K, E extends OrmEntity<K>> {

    void save(E entity);

    void delete(E entity);

    E findById(K id);

    List<E> findAll();
}
