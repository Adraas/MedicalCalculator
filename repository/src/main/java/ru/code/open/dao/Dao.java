package ru.code.open.dao;

import org.hibernate.Session;

import java.util.List;

public abstract class Dao<Entity> implements IDao<Entity> {
    util.SessionUtil sessionUtil = new util.SessionUtil();

    @Override
    public void add(Entity entity) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.save(entity);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public List getAll(String tableName) {
        List<Entity> entityList = (List<Entity>)  util.HibernateUtil.getSessionFactory().openSession().createQuery(tableName).list();
        return entityList;
    }

    @Override
    public Entity getById(String id) {
        return util.HibernateUtil.getSessionFactory().openSession().get(Entity.class, id);
    }

    @Override
    public void update(Entity entity) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.update(entity);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public void remove(Entity entity) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.remove(entity);

        sessionUtil.closeTransactionSesstion();
    }
}
