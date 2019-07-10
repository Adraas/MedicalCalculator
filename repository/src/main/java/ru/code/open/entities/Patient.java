package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;
    @Column(name = "name", length = 30, nullable = false)
    private String name;
    @Column(name = "surname", length = 30, nullable = false)
    private String surname;
    @Column(name = "patronymic", length = 30)
    private String patronymic;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<PatientCondition> patientCondition;

    public Patient(String name, String surname, String patronymic, Set<PatientCondition> patientCondition) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.patientCondition = patientCondition;
    }
}