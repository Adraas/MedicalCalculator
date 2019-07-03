package ru.code.open.dao;

import ru.code.open.entities.Patient;

public class PatientDao extends Dao<Patient> {
    @Override
    public Patient getById(String id) {
        return util.HibernateUtil.getSessionFactory().openSession().get(Patient.class, id);
    }
}
