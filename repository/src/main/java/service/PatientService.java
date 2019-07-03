package service;

import util.SessionUtil;
import dao.IDao;
import entities.Patient;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class PatientService extends SessionUtil implements IDao {
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

        String sql = "SELECT * FROM Patient";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Patient.class);
        List<Patient> patientList = query.list();

        closeTransactionSesstion();

        return patientList;
    }

    @Override
    public Object getById(String id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM Patient WHERE PatientID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Patient.class);
        query.setParameter("PatientID", id);

        Patient patient= (Patient) query.getSingleResult();

        closeTransactionSesstion();

        return patient;
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
