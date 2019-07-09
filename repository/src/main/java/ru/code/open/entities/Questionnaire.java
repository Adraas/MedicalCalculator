package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

import static javax.persistence.EnumType.STRING;

@Data
@NoArgsConstructor
@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;
    @Column(name = "title", nullable = false)
    private String title;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Collection<Question> questions;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<PatientCondition> patientCondition;
    @Column(name = "medical_questionnaire_type", nullable = false)
    @Enumerated(STRING)
    private MedicalQuestionnaireType medicalQuestionnaireType;

    public Questionnaire(String title, Collection<Question> questions, Collection<PatientCondition> patientCondition,
                         MedicalQuestionnaireType medicalQuestionnaireType) {
        this.title = title;
        this.questions = questions;
        this.patientCondition = patientCondition;
        this.medicalQuestionnaireType = medicalQuestionnaireType;
    }
}