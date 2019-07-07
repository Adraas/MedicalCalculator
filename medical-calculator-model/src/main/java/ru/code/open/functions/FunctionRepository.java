package ru.code.open.functions;

import lombok.Getter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class FunctionRepository {

    @Getter
    private static Set<ImmutablePair<Set<String>, Function<Map<String, Double>, Double>>> functions;

    public static Set<Function<Map<String, Double>, Double>> getFunctionsForGivenCalculator(String calculatorTitle) {
        Set<Function<Map<String, Double>, Double>> resultSet = new HashSet<>();
        for (ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> currentPair : functions) {
            if (currentPair.getCField().contains(calculatorTitle)) {
                resultSet.add(currentPair.getFField());
            }
        }
        return resultSet;
    }

    public static void addFunctionForGivenCalculator(String calculatorTitle,
                                                     Function<Map<String, Double>, Double> function) {
        if (!isContains(calculatorTitle, function)) {
            ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> immutablePair =
                    getImmutablePair(function);
            if (immutablePair == null) {
                Set<String> calculatorTitles = new HashSet<>();
                calculatorTitles.add(calculatorTitle);
                functions.add(new ImmutablePair<>(calculatorTitles, function));
            } else {
                functions.remove(immutablePair);
                immutablePair.getCField().add(calculatorTitle);
                functions.add(immutablePair);
            }
        }
    }

    private static boolean isContains(String calculatorTitle, Function<Map<String, Double>, Double> function) {
        for (ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> currentPair : functions) {
            if (currentPair.getFField().equals(function) && currentPair.getCField().contains(calculatorTitle)) {
                return true;
            }
        }
        return false;
    }

    private static ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> getImmutablePair(
            Function<Map<String, Double>, Double> function) {
        for (ImmutablePair<Set<String>, Function<Map<String, Double>, Double>> currentPair : functions) {
            if (currentPair.getFField().equals(function)) {
                return currentPair;
            }
        }
        return null;
    }
}
