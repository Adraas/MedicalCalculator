package ru.code.open.embeddables;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collection;

@Data
@Embeddable
public class Question {

    @Column(name = "question", nullable = false)
    private String questionWording;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Collection <Answer> answers;
}