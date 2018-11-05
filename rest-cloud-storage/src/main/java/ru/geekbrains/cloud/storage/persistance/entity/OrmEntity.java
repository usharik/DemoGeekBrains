package ru.geekbrains.cloud.storage.persistance.entity;

/**
 * Interface for all stored entities
 *
 * @param <Key> type of OrmEntity unique Id
 */
public interface OrmEntity<Key> {

    Key getId();

    void setId(Key id);
}
