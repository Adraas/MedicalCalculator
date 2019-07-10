package ru.code.open.controllers.util;

import ru.code.open.MedicalCalculatorFacade;
import ru.code.open.RepositoryFacade;
import ru.code.open.entities.Answer;
import ru.code.open.entities.Question;
import ru.code.open.entities.Questionnaire;
import ru.code.open.service.QuestionnaireService;

public class QuestionnaireViewGenerator {

    public static String getQuestionnaireData(String title) {
        MedicalCalculatorFacade medicalCalculatorFacade =
                new MedicalCalculatorFacade(new RepositoryFacade("h2_entity_manager", Questionnaire.class));
        Questionnaire questionnaire =
                ((QuestionnaireService) medicalCalculatorFacade.getRepositoryFacade().getService()).getByTitle(title);
        String questionnaireData = "<div>";
        for (Question question : questionnaire.getQuestions()) {
            questionnaireData = questionnaireData.concat(question.getQuestionWording()).concat("<br/>");
            if (question.getAnswers().isEmpty())
                questionnaireData = questionnaireData.concat("<input type='text' name='answer' value=''/><br/><br/>");
            else {
                for (Answer answer : question.getAnswers()) {
                    questionnaireData = questionnaireData.concat("<input type='radio' name='answer'/>")
                            .concat(answer.getAnswerWording()).concat("<br/>");
                }
                questionnaireData = questionnaireData.concat("<br/>");
            }
        }
        questionnaireData = questionnaireData.concat("<input type='submit' name='calculationButton' value='Вычислить'>")
                .concat("</div>");
        return questionnaireData;
    }
}
