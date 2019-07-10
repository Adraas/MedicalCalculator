package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.entities.PatientCondition;

public class PatientConditionService extends Service<PatientCondition, Long> {

    public PatientConditionService(IDao<PatientCondition, Long> dao) {
        super(dao);
    }
}
