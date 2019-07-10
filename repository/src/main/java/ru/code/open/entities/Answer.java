package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Answer {

    @Column(name = "answer", nullable = false, length = 100)
    private String answerWording;
    @Column(name = "grade", nullable = false)
    private long grade;

    public Answer(String answerWording, long grade) {
        this.answerWording = answerWording;
        this.grade = grade;
    }
}