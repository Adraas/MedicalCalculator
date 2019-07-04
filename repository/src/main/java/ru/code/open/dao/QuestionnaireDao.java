package ru.code.open.dao;

import org.hibernate.Session;
import ru.code.open.entities.Questionnaire;

public class QuestionnaireDao extends Dao<Questionnaire, Long> {

    public QuestionnaireDao(Class<Questionnaire> entity, Session session) {
        super(entity, session);
    }
}
