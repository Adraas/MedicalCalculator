package ru.code.open.service.factory;

import ru.code.open.dao.IDao;
import ru.code.open.entities.Patient;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Questionnaire;
import ru.code.open.service.IService;
import ru.code.open.service.PatientConditionService;
import ru.code.open.service.PatientService;
import ru.code.open.service.QuestionnaireService;

public class ServiceFactory implements IServiceFactory {

    @SuppressWarnings(value = {"unchecked"})
    @Override
    public IService createService(IDao dao) {
        Class entityClass = dao.getClass();
        return entityClass.equals(Patient.class) ? new PatientService(dao)
                : entityClass.equals(Questionnaire.class) ? new QuestionnaireService(dao)
                : entityClass.equals(PatientCondition.class) ? new PatientConditionService(dao)
                : null;
    }
}
