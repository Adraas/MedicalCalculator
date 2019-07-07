package ru.code.open.functions;

import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class FunctionRepository {

    @Getter
    private static Set<ImmutablePair<Set<String>, Function<Double, Double>>> functions;

    public static Set<Function<Double, Double>> getFunctionsForGivenCalculator(String calculatorTitle) {
        Set<Function<Double, Double>> resultSet = new HashSet<>();
        for (ImmutablePair<Set<String>, Function<Double, Double>> currentPair : functions) {
            if (currentPair.getCField().contains(calculatorTitle)) {
                resultSet.add(currentPair.getFField());
            }
        }
        return resultSet;
    }
}
