package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.entities.Patient;

public class PatientService extends Service<Patient, Long> {

    public PatientService(IDao<Patient, Long> dao) {
        super(dao);
    }
}
