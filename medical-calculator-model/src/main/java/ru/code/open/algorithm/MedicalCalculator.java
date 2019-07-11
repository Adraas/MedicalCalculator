package ru.code.open.algorithm;

import ru.code.open.entities.MedicalQuestionnaireType;
import ru.code.open.functions.FunctionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MedicalCalculator {

    public Collection<Double> calculate(String calculatorTitle, String calculatorType, Map<String, Double> answers) {
        MedicalQuestionnaireType type = MedicalQuestionnaireType.valueOf(calculatorType);
        switch (type) {
            case POINTS_SUMMATION_CALCULATOR:
                return totalScoreCalculate(answers.values());
            case FORMULA_CALCULATOR:
                return calculateByFormulas(calculatorTitle, answers);
            default:
                return null;
        }
    }

    private Collection<Double> totalScoreCalculate(Collection<Double> answers) {
        double score = 0;
        for (Number number : answers) {
            score += number.longValue();
        }
        return Collections.singletonList(score);
    }

    private Collection<Double> calculateByFormulas(String calculatorTitle, Map<String, Double> answers) {
        Collection<Double> result = new ArrayList<>();
        Set<Function<Map<String, Double>, Double>> resultSet = FunctionRepository.getFunctionsForGivenCalculator(calculatorTitle);
        for (Function<Map<String, Double>, Double> item : resultSet) {
            result.add(item.apply(answers));
        }
        return result;
    }
}