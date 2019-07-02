package service;

import util.SessionUtil;
import dao.IDAO;
import entities.Questionary;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class QuestionaryService extends SessionUtil implements IDAO {
    @Override
    public void add(Object o) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(o);

        closeTransactionSesstion();
    }

    @Override
    public List getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Questionary";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionary.class);
        List<Questionary> questionaryList = query.list();

        closeTransactionSesstion();

        return questionaryList;
    }

    @Override
    public Object getById(String id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Questionary WHERE QuestionaryID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionary.class);
        query.setParameter("QuestionaryID", id);

        Questionary questionary= (Questionary) query.getSingleResult();

        closeTransactionSesstion();

        return questionary;
    }

    @Override
    public void update(Object o) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(o);

        closeTransactionSesstion();
    }

    @Override
    public void remove(Object o) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(o);

        closeTransactionSesstion();
    }
}
