package ru.code.open.dao;

import java.util.List;

public interface IDao<Entity> {

    //create
    void add(Entity entity);

    //read
    List<Entity> getAll();

    Entity getById(String id);

    //update
    void update(Entity entity);

    //delete
    void remove(Entity entity);
}
