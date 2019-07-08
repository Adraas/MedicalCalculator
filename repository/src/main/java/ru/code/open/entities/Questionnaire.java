package ru.code.open.entities;

import lombok.Data;
import ru.code.open.embeddables.Question;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id", unique = true)
    private long id;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "question", nullable = false)
    @OneToMany(mappedBy = "questionnaire", cascade=CascadeType.ALL, orphanRemoval=true)
    private Collection<Question> questions;
    @OneToMany(mappedBy = "questionnaire", cascade=CascadeType.ALL, orphanRemoval=true)
    private Collection<PatientCondition> patientCondition;

}