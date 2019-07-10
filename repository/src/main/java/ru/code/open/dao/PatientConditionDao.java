package ru.code.open.dao;

import org.hibernate.Session;
import ru.code.open.entities.PatientCondition;

public class PatientConditionDao extends Dao<PatientCondition, Long> {

    public PatientConditionDao(Class<PatientCondition> entity, Session session) {
        super(entity, session);
    }

    @Override
    public String getTableName() {
        return Entities.PATIENT_CONDITION.getTableName();
    }
}
