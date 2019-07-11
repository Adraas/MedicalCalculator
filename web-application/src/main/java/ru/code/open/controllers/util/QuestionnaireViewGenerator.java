package ru.code.open.controllers.util;

import ru.code.open.MedicalCalculatorFacade;
import ru.code.open.RepositoryFacade;
import ru.code.open.entities.Answer;
import ru.code.open.entities.Question;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.PersistenceException;
import ru.code.open.service.QuestionnaireService;

import java.util.Iterator;
import java.util.Set;

public class QuestionnaireViewGenerator {

    public static String getQuestionnaireData(String title) throws PersistenceException {
        Questionnaire questionnaire = getQuestionnaireDate(title);
        return getQuestionnaireData(questionnaire.getQuestions());
    }

    public static String getQuestionnaireData(String title, String index) throws PersistenceException {
        Questionnaire questionnaire = getQuestionnaireDate(title);
        String[] indexes = index.split("-");
        if (indexes.length == 2) {
            byte firstIndex = Byte.parseByte(indexes[0]);
            byte secondIndex = Byte.parseByte(indexes[1]);
            Iterator<Question> questionIterator = questionnaire.getQuestions().iterator();
            for (int i = 0; questionIterator.hasNext() && i < firstIndex; i++) {
                Question question = questionIterator.next();
                if (question.getAnswers() != null) {
                    Answer answer = null;
                    Iterator<Answer> answerIterator = question.getAnswers().iterator();
                    for (int j = 0; answerIterator.hasNext() && j < secondIndex; j++) {
                        answer = answerIterator.next();
                    }
                    if (answer != null && answer.getState() != null && answer.getState().getQuestions() != null) {
                        return getQuestionnaireData(answer.getState().getQuestions());
                    }
                }
            }
        }
        return null;
    }

    private static Questionnaire getQuestionnaireDate(String title) throws PersistenceException {
        MedicalCalculatorFacade medicalCalculatorFacade =
                new MedicalCalculatorFacade(new RepositoryFacade("h2_entity_manager", Questionnaire.class));
        return ((QuestionnaireService) medicalCalculatorFacade.getRepositoryFacade().getService()).getByTitle(title);
    }

    private static String getQuestionnaireData(Set<Question> questions) {
        byte firstIndex = 0;
        byte secondIndex = 0;
        String questionnaireData = "<div>";
        for (Question question : questions) {
            questionnaireData = questionnaireData.concat(question.getQuestionWording()).concat("<br/>");
            if (question.getAnswers() == null)
                questionnaireData = questionnaireData.concat("<input type='text' name='answer_")
                        .concat(String.valueOf(firstIndex)).concat("-").concat(String.valueOf(secondIndex))
                        .concat("' value=''/><br/><br/>");
            else {
                for (Answer answer : question.getAnswers()) {
                    questionnaireData = questionnaireData.concat("<input type='radio' name='answer_")
                            .concat(String.valueOf(firstIndex)).concat("-").concat(String.valueOf(secondIndex))
                            .concat("' value='")
                            .concat(answer.getAnswerWording()).concat("'/><br/>");
                    secondIndex++;
                }
                firstIndex++;
                secondIndex = 0;
                questionnaireData = questionnaireData.concat("<br/>");
            }
        }
        questionnaireData = questionnaireData.concat("</div>");
        return questionnaireData;
    }
}
