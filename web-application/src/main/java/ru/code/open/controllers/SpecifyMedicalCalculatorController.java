package ru.code.open.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.code.open.MedicalCalculatorFacade;
import ru.code.open.RepositoryFacade;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.AlgorithmException;
import ru.code.open.exceptions.PersistenceException;
import ru.code.open.service.QuestionnaireService;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SpecifyMedicalCalculatorController {

    @RequestMapping(path = "/result-loading", method = RequestMethod.POST)
    @ResponseBody
    public String getScoringResult(@RequestParam String title, @RequestParam(name = "answers") String answers) {
        try {
            MedicalCalculatorFacade medicalCalculatorFacade =
                    new MedicalCalculatorFacade(new RepositoryFacade("h2_entity_manager", Questionnaire.class));
            Questionnaire questionnaire =
                    ((QuestionnaireService) medicalCalculatorFacade.getRepositoryFacade().getService())
                            .getByTitle(title);
            String[] answersArray = answers.split(";");
            Map<String, Double> mapAnswers = new LinkedHashMap<>();
            for (String currentAnswer : answersArray) {
                String[] currentAnswerValues = currentAnswer.split("-");
                if (currentAnswerValues.length == 2) {
                    mapAnswers.put(currentAnswerValues[0], Double.valueOf(currentAnswerValues[1]));
                } else {
                    return null;
                }
            }
            return medicalCalculatorFacade.getMedicalCalculator().calculate(questionnaire, mapAnswers);
        } catch (AlgorithmException | PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }
}
