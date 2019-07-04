package ru.code.open.dao;

import java.io.Serializable;
import java.util.Collection;

public interface IDao<Entity, Key extends Serializable> {

    void add(Entity entity);

    Entity getById(Key id);

    void update(Entity entity);

    void remove(Entity entity);

    Collection<Entity> getAll(String tableName);
}
