package ru.code.open.service;

import util.SessionUtil;
import ru.code.open.dao.IDao;
import ru.code.open.entities.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PatientService implements IDao {

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

        String sql = "SELECT * FROM Patient";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Patient.class);
        List<Patient> patientList = query.list();

        sessionUtil.closeTransactionSesstion();

        return patientList;
    }

    @Override
    public Object getById(String id) {
        sessionUtil.openTransactionSession();

        String sql = "SELECT * FROM Patient WHERE PatientID = :id";

        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Patient.class);
        query.setParameter("PatientID", id);

        Patient patient= (Patient) query.getSingleResult();

        sessionUtil.closeTransactionSesstion();

        return patient;
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
