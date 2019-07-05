package ru.code.open.util;

import org.hibernate.Session;
import ru.code.open.jpa.HibernateJPAContextInitializer;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

public class SessionRepository {

    private static Map<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public static void addSession(String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = HibernateJPAContextInitializer.getEntityManagerFactory();
        if (entityManagerFactory == null) {
            entityManagerFactory = HibernateJPAContextInitializer.getEntityManagerFactory(persistenceUnitName);
        }
        sessionMap.put(persistenceUnitName, (Session) entityManagerFactory.createEntityManager().getDelegate());
    }

    public static Session getSession(String persistenceUnitName) {
        if (!sessionMap.containsKey(persistenceUnitName)) {
            addSession(persistenceUnitName);
        }
        return sessionMap.get(persistenceUnitName);
    }
}