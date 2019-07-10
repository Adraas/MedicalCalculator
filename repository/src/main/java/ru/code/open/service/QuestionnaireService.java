package ru.code.open.service;

import ru.code.open.dao.IDao;
import ru.code.open.dao.QuestionnaireDao;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Questionnaire;
import ru.code.open.util.ImmutablePair;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QuestionnaireService extends Service<Questionnaire, Long> {

    public QuestionnaireService(IDao<Questionnaire, Long> dao) {
        super(dao);
    }

    public Questionnaire getByTitle(String title) {
        return ((QuestionnaireDao) getDao()).getByTitle(title);
    }

    public Set<ImmutablePair<String, String>> getPatientConditions(String title, Collection<Double> scores) {
        Questionnaire questionnaire = getByTitle(title);
        Set<ImmutablePair<String, String>> resultSet = new HashSet<>();
        for (double score : scores) {
            Iterator<PatientCondition> iterator = questionnaire.getPatientCondition().iterator();
            boolean isNotSaved = true;
            while (isNotSaved && iterator.hasNext()) {
                PatientCondition patientCondition = iterator.next();
                if (patientCondition.getInterval().contains((int) score)) {
                    resultSet.add(new ImmutablePair<>(patientCondition.getCondition(),
                            patientCondition.getDescription()));
                    isNotSaved = false;
                }
            }
        }
        return resultSet;
    }
}
