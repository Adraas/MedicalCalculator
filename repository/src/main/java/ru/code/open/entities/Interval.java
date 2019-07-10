package ru.code.open.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.code.open.exceptions.PersistenceException;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@Embeddable
public class Interval<N extends Number> {

    @Column(name = "left_limit", nullable = false)
    private N leftLimit;
    @Column(name = "right_limit", nullable = false)
    private N rightLimit;

    public Interval(N leftLimit, N rightLimit) throws PersistenceException {
        if (leftLimit.doubleValue() > rightLimit.doubleValue()) {
            throw new PersistenceException("the left limit is greater than or equal to the right",
                    new IllegalArgumentException());
        }
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public Interval(N singleValue) {
        leftLimit = singleValue;
        rightLimit = singleValue;
    }

    public boolean contains(N value) {
        return value.doubleValue() >= leftLimit.doubleValue()
                && value.doubleValue() <= rightLimit.doubleValue();
    }
}
