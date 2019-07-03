package service;

import util.SessionUtil;
import dao.IDao;
import entities.Questionary;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class QuestionaryService implements IDao {

    SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void add(Object o) throws SQLException {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.save(o);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public List getAll() throws SQLException {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM Questionary";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionary.class);
        List<Questionary> questionaryList = query.list();

        sessionUtil.closeTransactionSesstion();

        return questionaryList;
    }

    @Override
    public Object getById(String id) throws SQLException {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM Questionary WHERE QuestionaryID = :id";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionary.class);
        query.setParameter("QuestionaryID", id);

        Questionary questionary= (Questionary) query.getSingleResult();

        sessionUtil.closeTransactionSesstion();

        return questionary;
    }

    @Override
    public void update(Object o) throws SQLException {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.update(o);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public void remove(Object o) throws SQLException {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.remove(o);

        sessionUtil.closeTransactionSesstion();
    }
}
