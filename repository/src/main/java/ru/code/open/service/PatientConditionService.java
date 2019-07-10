package ru.code.open.service;

import org.hibernate.Session;
import ru.code.open.entities.PatientCondition;

public class PatientConditionService extends Service<PatientCondition, Long> {

    public PatientConditionService(Class<PatientCondition> v, Session session) {
        super(v, session);
    }
}
