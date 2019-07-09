package ru.code.open.functions.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Interval<N extends Number> implements Comparable<Interval<N>> {

    private N leftLimit;
    private N rightLimit;

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
