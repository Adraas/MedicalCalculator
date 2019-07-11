package ru.code.open.entities;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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
}