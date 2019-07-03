package ru.code.open.dao;

import ru.code.open.entities.PatientCondition;

public class PatientConditionDao extends Dao<PatientCondition> {
    @Override
    public PatientCondition getById(String id) {
        return util.HibernateUtil.getSessionFactory().openSession().get(PatientCondition.class, id);
    }
}
