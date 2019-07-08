package ru.code.open.dao.factory;

import org.hibernate.Session;
import ru.code.open.dao.IDao;

public interface IDaoFactory {
    IDao createDao(Class entityInstanceClass, Session session);
}
