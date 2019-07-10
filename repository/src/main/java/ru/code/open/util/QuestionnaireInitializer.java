package ru.code.open.util;

import lombok.Getter;
import ru.code.open.entities.Answer;
import ru.code.open.entities.MedicalQuestionnaireType;
import ru.code.open.entities.PatientCondition;
import ru.code.open.entities.Question;
import ru.code.open.entities.Questionnaire;
import ru.code.open.exceptions.PersistenceException;
import ru.code.open.service.IService;
import ru.code.open.service.QuestionnaireService;

import java.util.LinkedHashSet;
import java.util.Set;

public class QuestionnaireInitializer {

    @Getter
    private static boolean isInitialized;

    public static void initializeAllQuestionnaire(IService<Questionnaire, Long> service) throws PersistenceException {
        initializeDrugAdministrationRateQuestionnaire(service);
        // TODO: init all 14 questionnaires by different methods (14 calls)
        isInitialized = true;
    }

    private static void initializeDrugAdministrationRateQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Расчет скорости внутривенного капельного введения препарата";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();
            Question question = new Question("Объем раствора, мл", answers);
            questions.add(question);
            question = new Question("Желаемое время введения, минут", answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }
}
