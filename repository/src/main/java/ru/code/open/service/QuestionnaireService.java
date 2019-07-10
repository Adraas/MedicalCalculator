package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.dao.QuestionnaireDao;
import ru.code.open.entities.Questionnaire;

public class QuestionnaireService extends Service<Questionnaire, Long> {

    public QuestionnaireService(IDao<Questionnaire, Long> dao) {
        super(dao);
    }

    @SuppressWarnings(value = {"unchecked"})
    public Questionnaire getByTitle(String title) {
        NativeQuery<Questionnaire> nativeQuery = getSession().createNativeQuery("SELECT * FROM questionnaire WHERE title = :title");
        nativeQuery.setParameter("title", title);
        return nativeQuery.getSingleResult();
    }
}
