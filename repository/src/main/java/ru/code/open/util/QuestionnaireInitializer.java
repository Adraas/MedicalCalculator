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
        initializeCreatineLevelQuestionnaire(service);
        initializeRivermideQuestionnaire(service);
        initializeGlomerularFiltrationRateQuestionnaire(service);
        initializeRichmondQuestionnaire(service);
        initializeGraceQuestionnaire(service);
        // TODO: init all 9 questionnaires by different methods (9 calls)
        isInitialized = true;
    }

    private static void initializeDrugAdministrationRateQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Расчет скорости внутривенного капельного введения препарата";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Question question = new Question("Объем раствора, мл", null);
            questions.add(question);
            question = new Question("Желаемое время введения, минут", null);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeCreatineLevelQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Оценка клиренса креатинина по Cockcroft - Gault для мужчин";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Question question = new Question("Возраст, лет", null);
            questions.add(question);
            question = new Question("Вес, кг", null);
            questions.add(question);
            question = new Question("Креатинин,мкмоль/л", null);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeRivermideQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Оценочная шкала индекса мобильности пациента Ривермид";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();
            Answer answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);

            Question question = new Question("Можете ли вы повернуться со спины "
                    .concat("на бок без посторонней помощи?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы из положения лежа "
                    .concat("самостоятельно сесть на край постели?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы сидеть на краю постели "
                    .concat("без поддержки в течение 10 секунд?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы встать (с любого стула) менее чем "
                    .concat("за 15 секунд и удерживаться в положении стоя около стула 15 секунд?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы стоять без опоры 10 секунд?", answers);
            questions.add(question);
            question = new Question("Можете ли вы переместиться с постели "
                    .concat("на стул и обратно без какой-либо помощи?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы пройти 10 метров, используя, при необходимости, "
                    .concat("вспомогательные средства, но без помощи постороннего лица?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы подняться по лестнице "
                    .concat("на один пролет без посторонней помощи?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы ходить за пределами квартиры "
                    .concat("(по тротуару) без посторонней помощи?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы пройти 10 метров в пределах квартиры "
                    .concat("без подручных средств и помощи постороннего лица?"), answers);
            questions.add(question);
            question = new Question("Если вы уронили что-то на пол, можете ли вы пройти 5 метров, "
                    .concat("поднять предмет, который вы уронили, и вернуться обратно?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы ходить за пределами квартиры без посторонней помощи "
                    .concat("по неровной поверхности (трава, гравий, снег)?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы войти в ванну (душевую кабину) и "
                    .concat("выйти из нее без присмотра, вымыться самостоятельно?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы подняться на 4 ступени и спуститься обратно, не опираясь на перила,"
                    .concat("но, при необходимости, используя вспомогательные средства?"), answers);
            questions.add(question);
            question = new Question("Можете ли вы пробежать 10 метров, не прихрамывая, "
                    .concat("за 4 секунды (допускается быстрая ходьба)"), answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeGlomerularFiltrationRateQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Скорость клубочковой фильтрации по формулам MDRD и Schwartz";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Мужской", 2, null);
            answers.add(answer);
            answer = new Answer("Женский", 1, null);
            answers.add(answer);
            Question question = new Question("Возраст, лет", answers);
            questions.add(question);

            question = new Question("Возраст, лет", null);
            questions.add(question);
            question = new Question("Креатинин сыворотки, мкмоль/л", null);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Белые", 2, null);
            answers.add(answer);
            answer = new Answer("Чёрные", 1, null);
            answers.add(answer);
            question = new Question("Раса", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Да", 2, null);
            answers.add(answer);
            answer = new Answer("Нет", 1, null);
            answers.add(answer);
            question = new Question("Соответствие IDMS", answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeRichmondQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала возбуждения-седации Ричмонда";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            Question question = new Question("Пациен бодрствует, спокоен и внимателен", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Да", 2, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Пациент беспокоен, испытывает волнение", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Да", 3, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Пациент сонлив, но реагирует на голос", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Да", 4, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Пациент не реагирует на голос", answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeGraceQuestionnaire(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала GRACE";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Question question = new Question("Возраст, лет", null);
            questions.add(question);
            question = new Question("ЧСС, уд/мин", null);
            questions.add(question);
            question = new Question("Систолическое АД, мм. рт. ст.", null);
            questions.add(question);
            question = new Question("Креатинин, мкмоль/л", null);
            questions.add(question);

            Set<Answer> answers = new LinkedHashSet<>();
            Answer answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Остановка сердца", answers);
            questions.add(question);
            answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Отклонение сегмента ST", answers);
            questions.add(question);
            answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Высокий уровень сердечных ферментов", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Отсутствие признаков застойной сердечной недостаточности",
                    1, null);
            answers.add(answer);
            answer = new Answer("Наличие хрипа лёгких", 2, null);
            answers.add(answer);
            answer = new Answer("Наличие отёка лёгких", 3, null);
            answers.add(answer);
            answer = new Answer("Наличие кардиогенного шока", 4, null);
            answers.add(answer);
            question = new Question("Класс сердечной недостаточности "
                    .concat("(по классификации Killip)"), answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }
}
