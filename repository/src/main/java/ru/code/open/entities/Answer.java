package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import java.util.Map;

@Data
@NoArgsConstructor
@Embeddable
public class Answer {

    @Column(name = "answer", nullable = false, length = 100)
    private String answerWording;
    @Column(name = "grade", nullable = false)
    @MapKeyColumn(name = "criteria", unique = true, length = 20)
    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    private Map<String, Long> grades;

    public Answer(String answerWording, Map<String, Long> grades) {
        this.answerWording = answerWording;
        this.grades = grades;
    }
}