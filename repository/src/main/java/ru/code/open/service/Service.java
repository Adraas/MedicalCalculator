package ru.code.open.service;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import ru.code.open.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
public class Service<V, I extends Serializable> implements IService<V, I> {

    private Class<V> entity;
    private Session session;

    @Override
    public void create(V newInstance) throws PersistenceException {

    }

    @Override
    public V read(I index) {
        return null;
    }

    @Override
    public void update(V transientInstance) throws PersistenceException {

    }

    @Override
    public void delete(V transientInstance) throws PersistenceException {

    }

    @Override
    public Collection<V> getAll() {
        return null;
    }
}
