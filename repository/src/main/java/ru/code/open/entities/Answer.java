package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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
     * Initializes a newly created {@code Answer} object, with the initialization of the fields with the given
     * values.
     *
     * @param answerWording {@link #answerWording}
     * @param grade         {@link #grade}
     */
    public Answer(String answerWording, long grade) {
        this.answerWording = answerWording;
        this.grade = grade;
    }
}