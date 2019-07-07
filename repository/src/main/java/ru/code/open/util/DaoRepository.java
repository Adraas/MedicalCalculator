package ru.code.open.util;
import ru.code.open.dao.IDao;

import java.util.HashMap;

import java.util.Map;

public class DaoRepository {

    private static Map<Class, IDao> daoMap;

    private static IDaoFactory daoFactory;

    static {
        daoMap = new HashMap<>();
        daoFactory = new DaoFactory();
    }

    public static void addDao(Class entityInstanceClass, IDao dao) {
        daoMap.put(entityInstanceClass, dao);
    }

    public static IDao getDao(String persistenceUnitName, Class entityInstanceClass) {
        if (!daoMap.containsKey(entityInstanceClass)) {
            IDao dao = daoFactory.createDao(entityInstanceClass, SessionRepository.getSession(persistenceUnitName));
            addDao(entityInstanceClass, dao);
        }
        return daoMap.get(entityInstanceClass);
    }
}
