package ru.code.open.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "patient_condition")
public class PatientCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id", unique = true)
    private long id;
    @Column(name = "patient_condition", nullable = false)
    private String condition;
    @Column(name = "description", nullable = false)
    private String descriprion;

}