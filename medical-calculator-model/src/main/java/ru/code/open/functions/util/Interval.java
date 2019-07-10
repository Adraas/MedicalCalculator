package ru.code.open.functions.util;

import lombok.Getter;
import ru.code.open.exceptions.AlgorithmException;

@Getter
public class Interval<N extends Number> implements Comparable<Interval<N>> {

    private N leftLimit;
    private N rightLimit;

    public Interval(N leftLimit, N rightLimit) throws AlgorithmException {
        if (leftLimit.doubleValue() >= rightLimit.doubleValue()) {
            throw new AlgorithmException("the left limit is greater than or equal to the right");
        }
        this.leftLimit = leftLimit;
        this.rightLimit = rightLimit;
    }

    public boolean contains(N value) {
        return value.doubleValue() >= leftLimit.doubleValue()
                && value.doubleValue() <= rightLimit.doubleValue();
    }

    @Override
    public int compareTo(Interval<N> o) {
        return this.rightLimit.doubleValue() <= o.leftLimit.doubleValue() ? -1
                : this.leftLimit.doubleValue() == o.leftLimit.doubleValue()
                && this.rightLimit.doubleValue() == o.rightLimit.doubleValue() ? 0
                : 1;
    }
}
