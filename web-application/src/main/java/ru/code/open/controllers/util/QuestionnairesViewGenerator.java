package ru.code.open.controllers.util;

import ru.code.open.MedicalCalculatorFacade;
import ru.code.open.RepositoryFacade;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.PersistenceException;

import java.util.Collection;

public class QuestionnairesViewGenerator {

    public static String getQuestionnairesData() throws PersistenceException {
        String questionnairesData = "<div>";
        Collection<Questionnaire> questionnaires = getQuestionnaires();
        for (Questionnaire questionnaire : questionnaires) {
            String input = "<input type='button' onclick='MedicalCalculator.receiveQuestionnaires(questionnaires)' "
                    .concat("value='").concat(questionnaire.getTitle()).concat("'/>");
            questionnairesData = questionnairesData.concat(input).concat("<br/>");
        }
        questionnairesData = questionnairesData.concat("</div>");
        return questionnairesData;
    }

    @SuppressWarnings(value = {"unchecked"})
    private static Collection<Questionnaire> getQuestionnaires() throws PersistenceException {
        MedicalCalculatorFacade medicalCalculatorFacade =
                new MedicalCalculatorFacade(new RepositoryFacade("h2_entity_manager", Questionnaire.class));
        return (Collection<Questionnaire>) medicalCalculatorFacade.getRepositoryFacade().getService().getAll();
    }
}
