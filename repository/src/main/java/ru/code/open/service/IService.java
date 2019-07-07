package ru.code.open.service;

import ru.code.open.exceptions.PersistenceException;

import java.io.Serializable;
import java.util.Collection;

public interface IService<V, I extends Serializable> {

    void create(V newInstance) throws PersistenceException;

    V read(I index);

    void update(V transientInstance) throws PersistenceException;

    void delete(V transientInstance) throws PersistenceException;

    Collection<V> getAll();
}
