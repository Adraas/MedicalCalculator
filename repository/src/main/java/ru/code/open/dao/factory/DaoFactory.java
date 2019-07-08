package ru.code.open.dao.factory;

import org.hibernate.Session;
import ru.code.open.dao.IDao;
import ru.code.open.dao.PatientConditionDao;
import ru.code.open.dao.PatientDao;
import ru.code.open.dao.QuestionnaireDao;
import ru.code.open.entities.Patient;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Questionnaire;

public class DaoFactory implements IDaoFactory {

    @Override
    public IDao createDao(Class entityInstanceClass, Session session) {
        return entityInstanceClass.equals(Patient.class) ? new PatientDao(entityInstanceClass, session)
                : entityInstanceClass.equals(Questionnaire.class) ? new QuestionnaireDao(entityInstanceClass, session)
                : entityInstanceClass.equals(PatientCondition.class) ? new PatientConditionDao(entityInstanceClass, session)
                : null;
    }
}
