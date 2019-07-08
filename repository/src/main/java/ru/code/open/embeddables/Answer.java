package ru.code.open.embeddables;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.util.Map;

@Data
@Embeddable
@Table(name = "answer")
public class Answer {

    @Column(name = "answer", nullable = false)
    private String answerWording;
    @Column(name = "criteria", nullable = false)
    private Map<String, Long> criteria;

}