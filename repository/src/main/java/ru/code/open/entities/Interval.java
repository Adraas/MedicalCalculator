package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.code.open.exceptions.PersistenceException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The class {@code Interval} is an embeddable type for the {@code PatientCondition} entity. This embeddable type
 * represents a value or an interval for the scoring patient answers.
 *
 * @param <N> this parameter represents type of the interval limits and extends a {@code Number} type
 */
@Data
@NoArgsConstructor
@Embeddable
public class Interval<N extends Number> {

    @Column(name = "left_limit", nullable = false)
    private N leftLimit;
    @Column(name = "right_limit", nullable = false)
    private N rightLimit;

    /**
     * Initializes a newly created {@code Interval} object, with the initialization of the fields with the given
     * values and plausibility checking (i.e. the left limit must be less than the right limit).
     *
     * @param leftLimit  {@link #leftLimit}
     * @param rightLimit {@link #rightLimit}
     * @throws PersistenceException thrown if the left limit is greater than or equal to the right
     */
    public Interval(N leftLimit, N rightLimit) throws PersistenceException {
        if (leftLimit.doubleValue() > rightLimit.doubleValue()) {
            throw new PersistenceException("the left limit is greater than or equal to the right",
                    new IllegalArgumentException());
        }
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    /**
     * Initializes a newly created {@code Interval} object as a pinpoint single value, with the initialization of the
     * fields with the given value.
     *
     * @param singleValue the single pinpoint value for the interval initializing.
     */
    public Interval(N singleValue) {
        leftLimit = singleValue;
        rightLimit = singleValue;
    }

    /**
     * The method for the checking to the value containing in this interval.
     *
     * @param value the value for the checking
     * @return {@code true} if the given value is in this interval, else - {@code false}
     */
    public boolean contains(N value) {
        return value.doubleValue() >= leftLimit.doubleValue()
                && value.doubleValue() <= rightLimit.doubleValue();
    }
}
