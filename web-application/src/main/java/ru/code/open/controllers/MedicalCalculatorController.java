package ru.code.open.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.code.open.controllers.util.QuestionnaireViewGenerator;
import ru.code.open.exceptions.PersistenceException;

@Controller
public class MedicalCalculatorController {

    @RequestMapping(path = "/questionnaire-loading", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireData(@RequestParam(name = "message-type") String requestMessage,
                                       @RequestParam(name = "questionnaire-title") String title) {
        if (requestMessage.equals("get-questionnaire-data")) {
            try {
                return QuestionnaireViewGenerator.getQuestionnaireData(title);
            } catch (PersistenceException e) {
                e.printStackTrace();
                return e.getMessage();
            }
        }
        return null;
    }
}
