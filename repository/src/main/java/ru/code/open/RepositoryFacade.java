package ru.code.open;

import lombok.Getter;
import ru.code.open.service.IService;
import ru.code.open.util.DaoRepository;

public class RepositoryFacade {

    @Getter
    private String persistenceUnitName;
    @Getter
    private Class entityInstanceClass;
    private IServiceFactory serviceFactory;
    @Getter
    private IService service;

    public RepositoryFacade(String persistenceUnitName, Class entityInstanceClass) {
        this.persistenceUnitName = persistenceUnitName;
        this.entityInstanceClass = entityInstanceClass;
        serviceFactory = new ServiceFactory();
        serviceReinitialize();
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
