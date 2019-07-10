package ru.code.open.service;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.PersistenceException;

import java.util.Collection;

public class QuestionnaireService implements IService<Questionnaire, Long> {

    private Session session;

    @Override
    public void create(Questionnaire newInstance) throws PersistenceException {
    }

    @Override
    public Questionnaire read(Long index) {
        return null;
    }

    @Override
    public void update(Questionnaire transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(Questionnaire transientInstance) throws PersistenceException {
    }

    @Override
    public Collection<Questionnaire> getAll() {
        return null;
    }

    public Questionnaire getByTitle(String title) {
        NativeQuery<Questionnaire> nativeQuery = session.createNativeQuery("SELECT * FROM questionnaire WHERE title = :title");
        nativeQuery.setParameter("title", title);
        return nativeQuery.getSingleResult();
    }
}
