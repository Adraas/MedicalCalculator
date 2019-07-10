package ru.code.open.service;

import org.hibernate.Session;
import ru.code.open.entities.Patient;

public class PatientService extends Service<Patient, Long> {

    public PatientService(Class<Patient> v, Session session) {
        super(v, session);
    }
}
