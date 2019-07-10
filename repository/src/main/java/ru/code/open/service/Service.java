package ru.code.open.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.code.open.dao.IDao;
import ru.code.open.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
public abstract class Service<V, I extends Serializable> implements IService<V, I> {

    private IDao<V, I> dao;

    @Override
    public void create(V newInstance) throws PersistenceException {
        dao.add(newInstance);
    }

    @Override
    public V read(I index) {
        return dao.getById(index);
    }

    @Override
    public void update(V transientInstance) throws PersistenceException {
        dao.update(transientInstance);
    }

    @Override
    public void delete(V transientInstance) throws PersistenceException {
        dao.remove(transientInstance);
    }

    @Override
    public Collection<V> getAll() {
        return dao.getAll(dao.getTableName());
    }
}
