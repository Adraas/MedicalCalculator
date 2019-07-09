package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "patient_condition")
public class PatientCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;
    @Column(name = "condition", nullable = false)
    private String condition;
    @Column(name = "description", nullable = false)
    private String description;

    public PatientCondition(String condition, String description) {
        this.condition = condition;
        this.description = description;
    }
}