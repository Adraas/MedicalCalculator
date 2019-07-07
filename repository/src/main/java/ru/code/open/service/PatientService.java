package ru.code.open.service;

import ru.code.open.entities.Patient;
import ru.code.open.exceptions.PersistenceException;

import java.util.Collection;

public class PatientService implements IService<Patient, Long> {

    @Override
    public void create(Patient newInstance) throws PersistenceException {
    }

    @Override
    public Patient read(Long index) {
        return null;
    }

    @Override
    public void update(Patient transientInstance) throws PersistenceException {
    }

    @Override
    public void delete(Patient transientInstance) throws PersistenceException {
    }

    @Override
    public Collection<Patient> getAll() {
        return null;
    }
}
