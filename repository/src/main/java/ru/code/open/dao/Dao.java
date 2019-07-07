package ru.code.open.dao;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import ru.code.open.exceptions.PersistenceException;

import javax.persistence.RollbackException;
import java.io.Serializable;
import java.util.Collection;

@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
public abstract class Dao<Entity, Key extends Serializable> implements IDao<Entity, Key> {

    private Class<Entity> entity;
    private Session session;

    @Override
    public void add(Entity entity) throws PersistenceException {
        Transaction transaction = session.getTransaction();
        try {
            session.save(entity);
            transaction.commit();
        } catch (IllegalStateException | RollbackException e) {
            transaction.rollback();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public Entity getById(Key id) {
        return session.get(entity, id);
    }

    @Override
    public void update(Entity entity) throws PersistenceException {
        Transaction transaction = session.getTransaction();
        try {
            session.update(entity);
            transaction.commit();
        } catch (IllegalStateException | RollbackException e) {
            transaction.rollback();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @Override
    public void remove(Entity entity) throws PersistenceException {
        Transaction transaction = session.getTransaction();
        try {
            session.remove(entity);
            transaction.commit();
        } catch (IllegalStateException | RollbackException e) {
            transaction.rollback();
            throw new PersistenceException(e.getMessage(), e);
        }
    }

    @SuppressWarnings(value = {"unchecked"})
    @Override
    public Collection<Entity> getAll(String tableName) {
        NativeQuery<Entity> nativeQuery = session.createNativeQuery("SELECT * FROM :tableName");
        nativeQuery.setParameter("tableName", tableName);
        return nativeQuery.list();
    }
}
