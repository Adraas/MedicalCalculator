package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.dao.QuestionnaireDao;
import ru.code.open.entities.Questionnaire;

public class QuestionnaireService extends Service<Questionnaire, Long> {

    public QuestionnaireService(IDao<Questionnaire, Long> dao) {
        super(dao);
    }

    public Questionnaire getByTitle(String title) {
        return ((QuestionnaireDao) getDao()).getByTitle(title);
    }
}
