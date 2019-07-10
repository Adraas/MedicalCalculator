package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.Set;

@Data
@NoArgsConstructor
@Embeddable
public class Question {

    @Column(name = "question", nullable = false)
    private String questionWording;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Answer> answers;

    public Question(String questionWording, Set<Answer> answers) {
        this.questionWording = questionWording;
        this.answers = answers;
    }
}