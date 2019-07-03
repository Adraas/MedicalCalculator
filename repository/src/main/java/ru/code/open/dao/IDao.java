package ru.code.open.dao;

import java.util.List;

public interface IDao<Entity> {

    void add(Entity entity);

    Entity getById(String id);

    void update(Entity entity);

    void remove(Entity entity);

    List<Entity> getAll(String tableName);
}
