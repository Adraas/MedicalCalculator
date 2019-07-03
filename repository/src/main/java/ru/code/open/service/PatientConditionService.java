package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.entities.Patient;
import ru.code.open.entities.PatientCondition;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.SessionUtil;

import java.util.List;

public class PatientConditionService implements IDao {

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

        String sql = "SELECT * FROM PatientCondition";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(PatientCondition.class);
        List<Patient> patientList = query.list();

        sessionUtil.closeTransactionSesstion();

        return patientList;
    }

    @Override
    public Object getById(String id) {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM PatientCondition WHERE PatientConditionID = :id";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(PatientCondition.class);
        query.setParameter("PatientConditionID", id);

        PatientCondition patientCondition = (PatientCondition) query.getSingleResult();

        sessionUtil.closeTransactionSesstion();

        return patientCondition;
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
