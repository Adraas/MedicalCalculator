package ru.code.open.service;

import util.SessionUtil;
import ru.code.open.dao.IDao;
import ru.code.open.entities.Questionnaire;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionnaireService implements IDao {

    SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void add(Object o) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.save(o);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public List getAll() {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM Questionary";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionnaire.class);
        List<Questionnaire> questionnaireList = query.list();

        sessionUtil.closeTransactionSesstion();

        return questionnaireList;
    }

    @Override
    public Object getById(String id) {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM Questionary WHERE QuestionaryID = :id";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Questionnaire.class);
        query.setParameter("QuestionaryID", id);

        Questionnaire questionnaire = (Questionnaire) query.getSingleResult();

        sessionUtil.closeTransactionSesstion();

        return questionnaire;
    }

    @Override
    public void update(Object o) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.update(o);

        sessionUtil.closeTransactionSesstion();
    }

    @Override
    public void remove(Object o) {
        sessionUtil.openTransactionSession();

        Session session = sessionUtil.getSession();
        session.remove(o);

        sessionUtil.closeTransactionSesstion();
    }
}
