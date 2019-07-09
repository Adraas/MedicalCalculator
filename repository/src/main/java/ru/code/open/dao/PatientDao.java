package ru.code.open.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.code.open.entities.Patient;

public class PatientDao extends Dao<Patient, Long> {

    public PatientDao(Class<Patient> entity, Session session) {
        super(entity, session);
    }

    public boolean getPatient(String firstName, String surname, String patronymic) {
        NativeQuery<Patient> nativeQuery = getSession().createNativeQuery("SELECT * FROM patient WHERE patient_name :firstName AND patient_surname :surname AND patient_patronymic :patronymic");
        nativeQuery.setParameter("firstName", firstName);
        nativeQuery.setParameter("surname", surname);
        nativeQuery.setParameter("patronymic", patronymic);
        Patient patient = nativeQuery.getSingleResult();
        return patient != null;
    }
}
