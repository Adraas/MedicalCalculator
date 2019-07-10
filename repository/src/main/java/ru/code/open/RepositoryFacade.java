package ru.code.open;

import lombok.Getter;
import ru.code.open.service.IService;
import ru.code.open.service.factory.IServiceFactory;
import ru.code.open.service.factory.ServiceFactory;
import ru.code.open.util.DaoRepository;
import ru.code.open.util.QuestionnaireInitializer;

public class RepositoryFacade {

    @Getter
    private String persistenceUnitName;
    @Getter
    private Class entityInstanceClass;
    private IServiceFactory serviceFactory;
    @Getter
    private IService service;

    @SuppressWarnings(value = {"unchecked"})
    public RepositoryFacade(String persistenceUnitName, Class entityInstanceClass) {
        this.persistenceUnitName = persistenceUnitName;
        this.entityInstanceClass = entityInstanceClass;
        serviceFactory = new ServiceFactory();
        serviceReinitialize();
        if (!QuestionnaireInitializer.isInitialized()) {
            QuestionnaireInitializer.initializeAllQuestionnaire(service);
        }
    }

    private void serviceReinitialize() {
        service = serviceFactory.createService(DaoRepository.getDao(persistenceUnitName, entityInstanceClass));
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
        serviceReinitialize();
    }

    public void setEntityInstanceClass(Class entityInstanceClass) {
        this.entityInstanceClass = entityInstanceClass;
        serviceReinitialize();
    }
}
