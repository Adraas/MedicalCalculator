package ru.code.open.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

public abstract class Dao<Entity> implements IDao<Entity> {
    Class<Entity> entity;
    Session session;

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
    public Collection<Entity> getAll(String tableName) {
        Transaction transaction = session.getTransaction();
        Collection<Entity> entityList = session.createQuery("SELECT * FROM".concat(tableName)).list();
        transaction.commit();
        return entityList;
    }

    @Override
    public Entity getById(String id) {
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
