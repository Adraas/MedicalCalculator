package ru.code.open.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.Collection;

public abstract class Dao<Entity, Key extends Serializable> implements IDao<Entity, Key> {

    private Class<Entity> entity;
    private Session session;

    public Dao(Class<Entity> entity, Session session){
        this.entity = entity;
        this.session = session;
    }

    @Override
    public void add(Entity entity) {
        Transaction transaction = session.getTransaction();
        session.save(entity);
        transaction.commit();
    }

    @Override
    public Entity getById(Key id) {
        Transaction transaction = session.getTransaction();
        Entity entityClass= (Entity) session.get(entity.getClass(), id);
        transaction.commit();
        return entityClass;
    }

    @Override
    public void update(Entity entity) {
        Transaction transaction = session.getTransaction();
        session.save(entity);
        transaction.commit();
    }

    @Override
    public void remove(Entity entity) {
        Transaction transaction = session.getTransaction();
        session.save(entity);
        transaction.commit();
    }
}
