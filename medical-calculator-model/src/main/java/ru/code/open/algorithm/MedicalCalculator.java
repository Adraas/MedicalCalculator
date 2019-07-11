package ru.code.open.algorithm;

import ru.code.open.entities.Answer;
import ru.code.open.entities.MedicalQuestionnaireType;
import ru.code.open.entities.Question;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.AlgorithmException;
import ru.code.open.functions.FunctionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MedicalCalculator {

    public Collection<Double> calculate(Questionnaire questionnaire, Map<String, Double> answers)
            throws AlgorithmException {
        String calculatorTitle = questionnaire.getTitle();
        MedicalQuestionnaireType type = questionnaire.getMedicalQuestionnaireType();
        if (hasAllRequiredAnswers(questionnaire.getQuestions(), answers.size(), 0)) {
            switch (type) {
                case POINTS_SUMMATION_CALCULATOR:
                    return totalScoreCalculate(answers.values());
                case FORMULA_CALCULATOR:
                    return calculateByFormulas(calculatorTitle, answers);
                default:
                    return null;
            }
        } else {
            throw new AlgorithmException("not all required values");
        }
    }

    private boolean hasAllRequiredAnswers(Set<Question> questions, int numberAnswers, int currentValue) {
        for (Question question : questions) {
            if (question.getAnswers() != null) {
                for (Answer answer : question.getAnswers()) {
                    currentValue++;
                    if (answer.getState() != null) {
                        if (hasAllRequiredAnswers(answer.getState().getQuestions(), numberAnswers, currentValue)) {
                            return true;
                        }
                    } else {
                        return numberAnswers == currentValue;
                    }
                }
            } else {
                currentValue++;
            }
        }
        return numberAnswers == currentValue;
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