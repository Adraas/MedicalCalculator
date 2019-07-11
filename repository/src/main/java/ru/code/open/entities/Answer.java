package ru.code.open.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * The class {@code Answer} is an embeddable type for the {@code Question} embeddable type. This embeddable type
 * represents a some answer data.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Answer {

    /**
     * The answer wording as a simple {@code String} object.
     */
    @Column(name = "answer", nullable = false, length = 100)
    private String answerWording;

    /**
     * The grade of this answer.
     */
    @Column(name = "grade", nullable = false)
    private long grade;

    /**
     * The state which the system arrives by this answer.
     */
    @Embedded
    private State state;
}