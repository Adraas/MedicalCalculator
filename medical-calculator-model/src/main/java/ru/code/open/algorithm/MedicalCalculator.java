package ru.code.open.algorithm;

import ru.code.open.entities.MedicalQuestionnaireType;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MedicalCalculator {

    public Collection<Double> calculate(String calculatorType, Map<String, Double> answers) {
        MedicalQuestionnaireType type = MedicalQuestionnaireType.valueOf(calculatorType);
        switch (type) {
            case POINTS_SUMMATION_CALCUATOR:
                return totalScoreCalculate(answers.values());
            case FORMULA_CALCULATOR:
                return calculateByFormulas(answers);
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

    private Collection<Double> calculateByFormulas(Map<String, Double> answers) {
        // TODO: add work with formulas
        return null;
    }
}