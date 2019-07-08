package ru.code.open.embeddables;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Data
@Embeddable
@Table(name = "question")
public class Question {

    @Column(name = "question", nullable = false)
    private String questionWording;
    @Column(name = "answer", nullable = false)
    @OneToMany(mappedBy = "question", cascade= CascadeType.ALL, orphanRemoval=true)
    private Collection <Answer> answers;

}