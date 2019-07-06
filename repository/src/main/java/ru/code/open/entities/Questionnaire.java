package ru.code.open.entities;

import ru.code.open.embeddables.Question;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="questionnaire")
public class Questionnaire {
    public Questionnaire () {}


    @Column(name = "patientId")
    private long id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Question")
    private Collection <Question> questions;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title;}

    public void setTitle(String title) { this.title = title; }

    private Collection<Question> getQuestions() { return questions;}

    public void setQuestions(Collection<Question> questions) { this.questions = questions; }

    @Override
    public String toString(){
        return "Questionnaire{ " + "id = " + id + ", title = '" + title + '\'' + ", question = '" + getQuestions() + '\'' + '}';
    }

}
