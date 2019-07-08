package ru.code.open.entities;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "patient_id", unique = true)
    private Long id;
    @Column(name = "patient_name", length = 30, nullable = false)
    private String name;
    @Column(name = "patient_surname", length = 30, nullable = false)
    private String surname;
    @Column(name = "patient_patronymic", length = 30)
    private String patronymic;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<PatientCondition> patientCondition;

}