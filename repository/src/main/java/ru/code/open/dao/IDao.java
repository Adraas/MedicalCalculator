package ru.code.open.dao;

import ru.code.open.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

public interface IDao<Entity, Key extends Serializable> {

    void add(Entity entity) throws PersistenceException;

    Entity getById(Key id);

    void update(Entity entity) throws PersistenceException;

    void remove(Entity entity) throws PersistenceException;

    Collection<Entity> getAll(String tableName);
}
