package ru.code.open.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.code.open.entities.Patient;

public class PatientDao extends Dao<Patient, Long> {

    public PatientDao(Class<Patient> entity, Session session) {
        super(entity, session);
    }

    @SuppressWarnings(value = {"unchecked"})
    public boolean getPatient(String firstName, String surname, String patronymic) {
        NativeQuery<Patient> nativeQuery = (patronymic != null && !patronymic.trim().equals(""))
                ? getSession().createNativeQuery("SELECT * FROM patient WHERE patient.name = :firstName AND "
                .concat("surname = :surname AND patronymic = :patronymic"))
                : getSession().createNativeQuery("SELECT * FROM patient WHERE patient.name = :firstName AND "
                .concat("surname = :surname"));
        nativeQuery.setParameter("firstName", firstName);
        nativeQuery.setParameter("surname", surname);
        nativeQuery.setParameter("patronymic", patronymic);
        Patient patient = nativeQuery.getSingleResult();
        return patient != null;
    }

    @Override
    public String getTableName() {
        return Entities.PATIENT.getTableName();
    }
}
