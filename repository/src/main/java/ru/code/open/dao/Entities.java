package ru.code.open.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.code.open.entities.Patient;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Questionnaire;

import javax.persistence.Table;

@AllArgsConstructor
@Getter
public enum Entities {

    PATIENT(Patient.class.getAnnotation(Table.class).name()),
    PATIENT_CONDITION(PatientCondition.class.getAnnotation(Table.class).name()),
    QUESTIONNAIRE(Questionnaire.class.getAnnotation(Table.class).name());

    private String tableName;
}
