package ru.code.open.service;

import ru.code.open.entities.PatientCondition;
import ru.code.open.exceptions.PersistenceException;

import java.util.Collection;

public class PatientConditionService implements IService<PatientCondition, Long> {

    @Override
    public void create(PatientCondition newInstance) throws PersistenceException {
    }

    @Override
    public PatientCondition read(Long index) {
        return null;
    }

    @Override
    public void update(PatientCondition transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(PatientCondition transientInstance) throws PersistenceException {
    }

    @Override
    public Collection<PatientCondition> getAll() {
        return null;
    }
}
