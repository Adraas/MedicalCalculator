package ru.code.open.dao;

import ru.code.open.entities.Questionnaire;

public class QuestionnaireDao extends Dao<Questionnaire> {
    @Override
    public Questionnaire getById(String id) {
        return util.HibernateUtil.getSessionFactory().openSession().get(Questionnaire.class, id);
    }
}
