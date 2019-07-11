package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.Set;

/**
 * The class {@code Question} is an embeddable type for the {@code Questionnaire} entity. This embeddable type
 * represents a some question data.
 */
@Data
@NoArgsConstructor
@Embeddable
public class Question {

    /**
     * The question wording as a simple {@code String} object.
     */
    @Column(name = "question", nullable = false)
    private String questionWording;

    /**
     * The predefined possible answers collection of this question.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Answer> answers;

    /**
     * Initializes a newly created {@code Question} object, with the initialization of the fields with the given
     * values.
     *
     * @param questionWording {@link #questionWording}
     * @param answers         {@link #answers}
     */
    public Question(String questionWording, Set<Answer> answers) {
        this.questionWording = questionWording;
        this.answers = answers;
    }
}