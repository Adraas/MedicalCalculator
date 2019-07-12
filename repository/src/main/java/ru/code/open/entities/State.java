package ru.code.open.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.Set;

/**
 * The class {@code State} is an embeddable type for the {@code Answer} embeddable type. This embeddable type
 * represents a some startState which the system arrives by the selected answer.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class State {

    /**
     * The new questions collection of this startState (optionally).
     */
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Question> questions;
}
