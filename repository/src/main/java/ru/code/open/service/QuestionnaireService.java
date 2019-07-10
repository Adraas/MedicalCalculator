package ru.code.open.service;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.code.open.entities.Questionnaire;

public class QuestionnaireService extends Service<Questionnaire, Long> {

    public QuestionnaireService(Class<Questionnaire> v, Session session) {
        super(v, session);
    }

    @SuppressWarnings(value = {"unchecked"})
    public Questionnaire getByTitle(String title) {
        NativeQuery<Questionnaire> nativeQuery = getSession().createNativeQuery("SELECT * FROM questionnaire WHERE title = :title");
        nativeQuery.setParameter("title", title);
        return nativeQuery.getSingleResult();
    }
}
