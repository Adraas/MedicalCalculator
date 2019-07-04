package ru.code.open.dao;

import org.hibernate.Session;
import ru.code.open.entities.Patient;

public class PatientDao extends Dao<Patient, Long> {

    public PatientDao(Class<Patient> entity, Session session) {
        super(entity, session);
    }
}
