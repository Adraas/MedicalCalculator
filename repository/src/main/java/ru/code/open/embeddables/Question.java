package ru.code.open.embeddables;

import javax.persistence.Embeddable;
import java.util.Collection;

@Embeddable
public class Question {
    public Question (){}

    private String questionWording;
    private Collection<Answer> answers;

    public String getQuestionWording() { return questionWording;}

    public void setQuestionWording(String questionWording) { this.questionWording = questionWording; }

    public Collection<Answer> getAnswers() { return answers;}

    public void setAnswers(Collection<Answer> answers) { this.answers = answers; }

}
