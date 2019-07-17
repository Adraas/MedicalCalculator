package ru.code.open.functions;

import ru.code.open.util.ImmutablePair;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class FunctionRepository {

    private static Set<SingleFunctionContainer> functions;

    static {
        functions = new HashSet<>();
    }

    public static Function<Map<String, Double>, Double> getFunctionForGivenCalculator(String calculatorTitle,
                                                                                      Set<String> possibleValues) {
        for (SingleFunctionContainer singleFunctionContainer : functions) {
            if (singleFunctionContainer.getFunctions().getCField().contains(calculatorTitle)
                    && singleFunctionContainer.getPossibleValues().equals(possibleValues)) {
                return singleFunctionContainer.getFunctions().getFField();
            }
        }
        return null;
    }

    public static void addFunctionForGivenCalculator(String calculatorTitle, Set<String> possibleValues,
                                                     Function<Map<String, Double>, Double> function) {
        if (!isContains(calculatorTitle, function)) {
            SingleFunctionContainer singleFunctionContainer =
                    getSingleFunctionContainer(function);
            if (singleFunctionContainer == null) {
                Set<String> calculatorTitles = new HashSet<>();
                calculatorTitles.add(calculatorTitle);
                functions.add(new SingleFunctionContainer(new ImmutablePair<>(calculatorTitles, function),
                        possibleValues));
            } else {
                functions.remove(singleFunctionContainer);
                singleFunctionContainer.getFunctions().getCField().add(calculatorTitle);
                functions.add(singleFunctionContainer);
            }
        }
    }

    private static boolean isContains(String calculatorTitle, Function<Map<String, Double>, Double> function) {
        for (SingleFunctionContainer singleFunctionContainer : functions) {
            if (singleFunctionContainer.getFunctions().getFField().equals(function)
                    && singleFunctionContainer.getFunctions().getCField().contains(calculatorTitle)) {
                return true;
            }
        }
        return false;
    }

    private static SingleFunctionContainer getSingleFunctionContainer(
            Function<Map<String, Double>, Double> function) {
        for (SingleFunctionContainer singleFunctionContainer : functions) {
            if (singleFunctionContainer.getFunctions().getFField().equals(function)) {
                return singleFunctionContainer;
            }
        }
        return null;
    }
}
