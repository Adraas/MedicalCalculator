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
    @Override
    public IService createService(IDao iDao) {
        Class entityClass = iDao.getClass();
        return entityClass.equals(Patient.class) ? new PatientService()
                : entityClass.equals(Questionnaire.class) ? new QuestionnaireService()
                : entityClass.equals(PatientCondition.class) ? new PatientConditionService()
                : null;
    }
}
