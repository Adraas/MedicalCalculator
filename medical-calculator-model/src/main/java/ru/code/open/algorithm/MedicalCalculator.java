package ru.code.open.algorithm;

import ru.code.open.entities.Answer;
import ru.code.open.entities.MedicalQuestionnaireType;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Question;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.AlgorithmException;
import ru.code.open.functions.FunctionRepository;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class MedicalCalculator {

    public String calculate(Questionnaire questionnaire, Map<String, Double> answers)
            throws AlgorithmException {
        MedicalQuestionnaireType type = questionnaire.getMedicalQuestionnaireType();
        if (hasAllRequiredAnswers(questionnaire.getStartState().getQuestions(), answers.size(), 0)) {
            switch (type) {
                case POINTS_SUMMATION_CALCULATOR:
                    return totalScoreCalculate(questionnaire, answers.values());
                case FORMULA_CALCULATOR:
                    return calculateByFormulas(questionnaire, answers);
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

    private String totalScoreCalculate(Questionnaire questionnaire, Collection<Double> indicatedAnswers) {
        int score = 0;
        for (Number number : indicatedAnswers) {
            score += number.longValue();
        }
        for (PatientCondition patientCondition : questionnaire.getPatientConditions()) {
            if (patientCondition.getInterval().contains(score)) {
                return patientCondition.getCondition()
                        .concat("::").concat(patientCondition.getDescription()).concat(";");
            }
        }
        return String.valueOf(score).concat(";");
    }

    private String calculateByFormulas(Questionnaire questionnaire, Map<String, Double> indicatedAnswers)
            throws AlgorithmException {
        Function<Map<String, Double>, Double> function =
                FunctionRepository.getFunctionForGivenCalculator(questionnaire.getTitle(), indicatedAnswers.keySet());
        if (function != null) {
            double score = function.apply(indicatedAnswers);
            String result = "";
            for (PatientCondition patientCondition : questionnaire.getPatientConditions()) {
                if (patientCondition.getInterval().contains((int) score)) {
                    result = result.concat(patientCondition.getCondition()
                            .concat("::").concat(patientCondition.getDescription())).concat(";");
                } else {
                    result = result.concat(String.valueOf(score)).concat(";");
                }
            }
            return result;
        }
        throw new AlgorithmException("required function not found");
    }
}