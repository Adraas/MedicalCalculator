package ru.code.open.dao;

import java.util.List;

public abstract class Dao<Entity> implements IDao<Entity> {
    @Override
    public void add(Entity o) {

    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public Entity getById(String id) {
        return null;
    }

    @Override
    public void update(Entity o) {

    }

    @Override
    public void remove(Entity o) {

    }
}
