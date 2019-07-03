package ru.code.open.dao;

import java.util.Collection;

public interface IDao<Entity> {

    void add(Entity entity);

    Entity getById(String id);

    void update(Entity entity);

    void remove(Entity entity);

    Collection<Entity> getAll(String tableName);
}
