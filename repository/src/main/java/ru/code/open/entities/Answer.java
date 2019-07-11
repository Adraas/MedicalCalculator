package ru.code.open.entities;

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

    /**
     * Initializes a newly created {@code Answer} object, with the initialization of the fields with the given
     * values.
     *
     * @param answerWording {@link #answerWording}
     * @param grade         {@link #grade}
     * @param state         {@link #state}
     */
    public Answer(String answerWording, long grade, State state) {
        this.answerWording = answerWording;
        this.grade = grade;
        this.state = state;
    }
}