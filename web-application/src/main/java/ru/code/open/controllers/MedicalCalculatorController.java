package ru.code.open.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.code.open.controllers.util.QuestionnaireViewGenerator;

@Controller
public class MedicalCalculatorController {

    @RequestMapping(path = "/questionnaire-loading", method = RequestMethod.GET)
    @ResponseBody
    public String getQuestionnaireData(@RequestParam(name = "message-type") String requestMessage,
                                       @RequestParam(name = "questionnaire-title") String title) {
        if (requestMessage.equals("get-questionnaire-data")) {
            return QuestionnaireViewGenerator.getQuestionnaireData(title);
        } else {
            return null;
        }
    }
}
