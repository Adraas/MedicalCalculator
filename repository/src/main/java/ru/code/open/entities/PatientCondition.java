package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The class {@code PatientCondition} is an entity for the ORM to a database. This entity represents a patient's
 * some condition.
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "patient_condition")
public class PatientCondition {

    /**
     * The unique identifier of this entity. The value for this field is generated by database's sequence.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The condition title.
     */
    @Column(name = "condition", nullable = false)
    private String condition;

    /**
     * The condition description (optionally).
     */
    @Column(name = "description")
    private String description;

    /**
     * The value or an interval for the scoring patient answers.
     */
    @Embedded
    private Interval<Integer> interval;

    /**
     * Initializes a newly created {@code PatientCondition} object, with the initialization of the fields with the given
     * values.
     *
     * @param condition   {@link #condition}
     * @param description {@link #description}
     * @param interval    {@link #interval}
     */
    public PatientCondition(String condition, String description, Interval<Integer> interval) {
        this.condition = condition;
        this.description = description;
        this.interval = interval;
    }
}