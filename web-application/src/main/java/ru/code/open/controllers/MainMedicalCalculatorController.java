package ru.code.open.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.code.open.controllers.util.QuestionnaireViewGenerator;
import ru.code.open.controllers.util.QuestionnairesViewGenerator;
import ru.code.open.exceptions.PersistenceException;

@Controller
public class MainMedicalCalculatorController {

    @RequestMapping(path = "/questionnaires-loading", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnairesData(@RequestParam(name = "message-type") String requestMessage) {
        if (requestMessage.equals("get-all-questionnaires")) {
            try {
                return QuestionnairesViewGenerator.getQuestionnairesData();
            } catch (PersistenceException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @RequestMapping(path = "/questionnaire-loading", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireData(@RequestParam(name = "message-type") String requestMessage,
                                       @RequestParam(name = "questionnaire-title") String title) {
        if (requestMessage.equals("get-questionnaire-data")) {
            try {
                return QuestionnaireViewGenerator.getQuestionnaireData(title);
            } catch (PersistenceException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
