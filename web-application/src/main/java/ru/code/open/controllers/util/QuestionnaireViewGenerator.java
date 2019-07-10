package ru.code.open.controllers.util;

import ru.code.open.MedicalCalculatorFacade;
import ru.code.open.RepositoryFacade;
import ru.code.open.entities.Questionnaire;
import ru.code.open.service.QuestionnaireService;

public class QuestionnaireViewGenerator {

    public static String getQuestionnaireData(String title) {
        MedicalCalculatorFacade medicalCalculatorFacade =
                new MedicalCalculatorFacade(new RepositoryFacade("h2_entity_manager", Questionnaire.class));
        Questionnaire questionnaire =
                ((QuestionnaireService) medicalCalculatorFacade.getRepositoryFacade().getService()).getByTitle(title);
        String questionnaireData = "";
        //
        return questionnaireData;
    }
}
