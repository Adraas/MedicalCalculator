package ru.code.open.embeddables;

import javax.persistence.Embeddable;
import java.util.Map;

@Embeddable
public class Answer {
    public Answer (){}

    private String answerWording;
    private Map<String,Long> criteria;

    public Map<String,Long> getCriteria() { return criteria; }

    public void setCriteria (Map<String,Long> criteria) { this.criteria = criteria;}

    public String getAnswerWording() { return answerWording;}

    public void setAnswerWording(String answerWording) { this.answerWording = answerWording; }
}
