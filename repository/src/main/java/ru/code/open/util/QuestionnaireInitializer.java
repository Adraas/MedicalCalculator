package ru.code.open.util;

import lombok.Getter;
import ru.code.open.entities.Questionnaire;
import ru.code.open.service.IService;

public class QuestionnaireInitializer {

    @Getter
    private static boolean isInitialized;

    public static void initializeAllQuestionnaire(IService<Questionnaire, Long> service) {
        // TODO: init all 15 questionnaires by different methods (15 calls)
        isInitialized = true;
    }
}
