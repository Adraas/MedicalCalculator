package ru.code.open.dao;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.code.open.entities.Patient;
import ru.code.open.entities.Questionnaire;

public class QuestionnaireDao extends Dao<Questionnaire, Long> {

    public QuestionnaireDao(Class<Questionnaire> entity, Session session) {
        super(entity, session);
    }

    @SuppressWarnings(value = {"unchecked"})
    public Questionnaire getByTitle(String title) {
        NativeQuery<Questionnaire> nativeQuery = getSession().createNativeQuery("SELECT * FROM questionnaire WHERE tittle = :title");
        nativeQuery.setParameter("title", title);
        return nativeQuery.getSingleResult();
    }
}
