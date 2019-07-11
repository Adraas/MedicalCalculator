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

/**
 * The class {@code Patient} is an entity for the ORM to a database. This entity represents a patient personal data
 * with his questionnaire survey results.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {

    /**
     * The unique identifier of this entity. The value for this field is generated by database's sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long id;

    /**
     * The patient name.
     */
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    /**
     * The patient surname.
     */
    @Column(name = "surname", length = 30, nullable = false)
    private String surname;

    /**
     * The patient patronymic.
     */
    @Column(name = "patronymic", length = 30)
    private String patronymic;

    /**
     * The patient conditions identified during a questionnaire survey.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private Set<PatientCondition> patientCondition;

    /**
     * Initializes a newly created {@code Patient} object, with the initialization of the fields with the given
     * values.
     *
     * @param name             {@link #name}
     * @param surname          {@link #surname}
     * @param patronymic       {@link #patronymic}
     * @param patientCondition {@link #patientCondition}
     */
    public Patient(String name, String surname, String patronymic, Set<PatientCondition> patientCondition) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.patientCondition = patientCondition;
    }
}