package ru.code.open.service.factory;

import ru.code.open.dao.IDao;
import ru.code.open.service.IService;

public interface IServiceFactory {

    IService createService(IDao iDao);
}
