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
        initializeTinettiScale(service);
        initializeNIHSSScale(service);
        initializeHuntHessScale(service);
        initializeIndexBartel(service);
        initializeGlasgowComaScale(service);
        initializeGlasgowComaFOUR(service);
        // TODO: init all 3 missing questionnaires by different methods (3 calls)
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

    private static void initializeTinettiScale(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала Тинетти";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Прислоняется или соскальзывает со стула", 0, null);
            answers.add(answer);
            answer = new Answer("Уверенно сидит, устойчив", 1, null);
            answers.add(answer);
            Question question = new Question("Сидя", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Невозможно без посторонней помощи", 0, null);
            answers.add(answer);
            answer = new Answer("Возможно с помощью рук", 1, null);
            answers.add(answer);
            answer = new Answer("Возможно без помощи рук", 2, null);
            answers.add(answer);
            question = new Question("Вставание", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Безуспешны без посторонней помощи", 0, null);
            answers.add(answer);
            answer = new Answer("Успешны, но необходимо более 1 попытки", 1, null);
            answers.add(answer);
            answer = new Answer("Может встать с одной попытки", 2, null);
            answers.add(answer);
            question = new Question("Попытки встать", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Неустойчив (шатание, движения ногами, качание туловища)", 0, null);
            answers.add(answer);
            answer = new Answer("Стоит с помощью постороннего или другой опоры", 1, null);
            answers.add(answer);
            answer = new Answer("Стоит без опоры или посторонней помощи", 2, null);
            answers.add(answer);
            question = new Question("Устойчивость сразу после вставания в течении 5 сек", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Не устойчив", 0, null);
            answers.add(answer);
            answer = new Answer("Устойчив, но широко расставив ноги (>4 дюймов (10,16 см)), использует трость или другую опору", 1, null);
            answers.add(answer);
            answer = new Answer("Устойчив с близко поставленными ногами или без опоры", 2, null);
            answers.add(answer);
            question = new Question("Равновесие стоя (длительное стояние в течение 1 мин.)", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Падает", 0, null);
            answers.add(answer);
            answer = new Answer("Шатается, хватается за опору", 1, null);
            answers.add(answer);
            answer = new Answer("Устойчив", 2, null);
            answers.add(answer);
            question = new Question("Устойчивость при толчке в грудь", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Неустойчив", 0, null);
            answers.add(answer);
            answer = new Answer("Устойчив", 1, null);
            answers.add(answer);
            question = new Question("Стояние с закрытыми глазами", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Переступания, прерывающиеся шаги", 0, null);
            answers.add(answer);
            answer = new Answer("Непрерывные шаги", 1, null);
            answers.add(answer);
            answer = new Answer("Неустойчив", 0, null);
            answers.add(answer);
            answer = new Answer("Устойчив", 1, null);
            answers.add(answer);
            question = new Question("Поворот на 360 град:", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Неуверенно (промахивается, падает на стул)", 0, null);
            answers.add(answer);
            answer = new Answer("Использует руки, движения неплавные", 1, null);
            answers.add(answer);
            answer = new Answer("Уверенно, плавно", 2, null);
            answers.add(answer);
            question = new Question("Присаживание на стул", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Застывания или повторные попытки сделать первый шаг", 0, null);
            answers.add(answer);
            answer = new Answer("Не нарушена", 1, null);
            answers.add(answer);
            question = new Question("Инициация ходьбы", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Не переносит стопу далее правой стопы", 0, null);
            answers.add(answer);
            answer = new Answer("Переносит стопу далее правой стопы ", 1, null);
            answers.add(answer);
            question = new Question("Длина шага левой ноги", answers);
            questions.add(question);

            answer = new Answer("Нет промежутка между стопой и полом ", 0, null);
            answers.add(answer);
            answer = new Answer("Имеется явное расстояние между стопой и полом ", 1, null);
            answers.add(answer);
            question = new Question("Высота шага левой ноги", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Не переносит стопу далее левой стопы", 0, null);
            answers.add(answer);
            answer = new Answer("Переносит стопу далее левой стопы ", 1, null);
            answers.add(answer);
            question = new Question("Длина шага правой ноги", answers);
            questions.add(question);

            answer = new Answer("Нет промежутка между стопой и полом ", 0, null);
            answers.add(answer);
            answer = new Answer("Имеется явное расстояние между стопой и полом ", 1, null);
            answers.add(answer);
            question = new Question("Высота шага правой ноги", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Шаги правой и левой ноги неодинаковы ", 0, null);
            answers.add(answer);
            answer = new Answer("Шаги правой и левой ноги одинаковы", 1, null);
            answers.add(answer);
            question = new Question("Симметричность шага", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Остановки и паузы между шагами", 0, null);
            answers.add(answer);
            answer = new Answer("Непрерывные шаги", 1, null);
            answers.add(answer);
            question = new Question("Непрерывность ходьбы", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Выраженное отклонение от линии движения", 0, null);
            answers.add(answer);
            answer = new Answer("Незначительное или средней величины отклонение или ходьба с посторонней помощью", 1, null);
            answers.add(answer);
            answer = new Answer("Идет по прямой линии без посторонней помощи", 2, null);
            answers.add(answer);
            question = new Question("Отклонение от линии движения (оценивается с помощью линейки на полу длинной 12 дюймов (30.48 см), имеет значение отклонение на расстояние более одной стопы при прохождении расстояния в 5 м)", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Выраженное раскачивание туловища или необходимость в посторонней помощи", 0, null);
            answers.add(answer);
            answer = new Answer("Отсутствие раскачивание туловища, но сгибает ноги в коленях или размахивает руками", 1, null);
            answers.add(answer);
            answer = new Answer("Отсутствие раскачивания и сгибания туловища, не использует руки при ходьбе, не требует посторонней помощи", 2, null);
            answers.add(answer);
            question = new Question("Степень покачивания туловища", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Пятки порознь", 0, null);
            answers.add(answer);
            answer = new Answer("Пятки почти соприкасаются во время ходьбы", 1, null);
            answers.add(answer);
            question = new Question("Оцена походки", answers);
            questions.add(question);

            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeNIHSSScale(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала NIHSS";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("в сознании, активно реагирует", 0, null);
            answers.add(answer);
            answer = new Answer("Сомноленция, но можно разбудить при минимальном раздражении, выполняет команды, отвечает на вопросы", 1, null);
            answers.add(answer);
            answer = new Answer("Сопор - требуется повторная стимуляция для поддержания активности, или заторможен - требуется сильная и болезненная стимуляция для произведения нестереотипных движений", 2, null);
            answers.add(answer);
            answer = new Answer("Кома, реагирует только рефлекторными действиями или не реагирует на раздражители", 3, null);
            answers.add(answer);
            Question question = new Question("Уровень сознания", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Афазия или сопор", 2, null);
            answers.add(answer);
            answer = new Answer("Эндотрахеальная трубка, сильная дизартрия, языковой барьер", 1, null);
            answers.add(answer);
            answer = new Answer("Правильный ответ на оба вопроса", 0, null);
            answers.add(answer);
            answer = new Answer("Правильный ответ на один вопрос", 1, null);
            answers.add(answer);
            answer = new Answer("Не даны правильные ответы", 2, null);
            answers.add(answer);
            question = new Question("Уровень сознания - ответы на вопросы. Спросить у больного, какой сейчас месяц и его возраст. Записать первый ответ", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Правильно выполнены обе команды", 0, null);
            answers.add(answer);
            answer = new Answer("Правильно выполнена одна команда", 1, null);
            answers.add(answer);
            answer = new Answer("Ни одна команда не выполнена правильно", 2, null);
            answers.add(answer);
            question = new Question("Уровень сознания - выполнение команд. Пациента просят открыть и закрыть глаза, сжать и разжать непарализованную руку. Засчитывается только первая попытка", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Норма", 0, null);
            answers.add(answer);
            answer = new Answer("Частичный паралич взора", 1, null);
            answers.add(answer);
            answer = new Answer("Тоническое отведение глаз или полный паралич взора, не преодолеваемый вызыванием окулоцефалических рефлексов", 2, null);
            answers.add(answer);
            question = new Question("Движение глазных яблок. Учитываются только горизонтальные движения глаз", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Норма", 0, null);
            answers.add(answer);
            answer = new Answer("Частичный паралич взора", 1, null);
            answers.add(answer);
            answer = new Answer("Тоническое отведение глаз или полный паралич взора, не преодолеваемый вызыванием окулоцефалических рефлексов", 2, null);
            answers.add(answer);
            question = new Question("Движение глазных яблок. Учитываются только горизонтальные движения глаз", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Норма", 0, null);
            answers.add(answer);
            answer = new Answer("Частичная гемианопсия", 1, null);
            answers.add(answer);
            answer = new Answer("Полная гемианопсия", 2, null);
            answers.add(answer);
            question = new Question("Исследование полей зрения.", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Конечности удерживаются в течение 10 с", 0, null);
            answers.add(answer);
            answer = new Answer("Конечности удерживаются менее 10 с", 1, null);
            answers.add(answer);
            answer = new Answer("Конечности не поднимаются или не сохраняют заданного положения, но производят некоторое сопротивление силе тяжести", 2, null);
            answers.add(answer);
            answer = new Answer("Конечности падают без сопротивления силе тяжести", 3, null);
            answers.add(answer);
            answer = new Answer("Нет активных движений", 4, null);
            answers.add(answer);
            answer = new Answer("евозможно проверить (конечность ампутирована, искусственный сустав)", 5, null);
            answers.add(answer);
            question = new Question("Движение в верхних конечностях. Руки поднимаются под углом 45° в положении лежа, под углом 90° в положении сидя. Если больной не понимает задание, врач должен поместить руки в требуемое положение сам. Баллы записываются отдельно для правой и левой конечностей.", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Конечности удерживаются в течение 5 с", 0, null);
            answers.add(answer);
            answer = new Answer("Конечности удерживаются менее 5 с", 1, null);
            answers.add(answer);
            answer = new Answer("Конечности не поднимаются или не сохраняют поднятое положение, но производят некоторое сопротивление силе тяжести", 2, null);
            answers.add(answer);
            answer = new Answer("Конечности падают без сопротивления силе тяжести", 3, null);
            answers.add(answer);
            answer = new Answer("Нет активных движений", 4, null);
            answers.add(answer);
            answer = new Answer("Невозможно проверить (конечность ампутирована, искусственный сустав)", 5, null);
            answers.add(answer);
            question = new Question("Движение в нижних конечностях. В положении лежа поднять паретичную конечность на 5 секунд под углом 30°. Баллы записываются отдельно для правой и левой конечностей", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Отсутствует", 0, null);
            answers.add(answer);
            answer = new Answer("В одной конечности", 1, null);
            answers.add(answer);
            answer = new Answer("В двух конечностях", 2, null);
            answers.add(answer);
            question = new Question("Атаксия конечностей. Пальценосовая и пяточно-коленная пробы проводятся с двух сторон, атаксия засчитывается в том случае, если она не обусловлена парезом", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Норма", 0, null);
            answers.add(answer);
            answer = new Answer("Легкие или средние нарушения", 1, null);
            answers.add(answer);
            answer = new Answer("Значительное или полное нарушение чувствительности", 2, null);
            answers.add(answer);
            question = new Question("Чувствительность.Учитывается только расстройство по гемитипу", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Нет афазии", 0, null);
            answers.add(answer);
            answer = new Answer("Легкая афазия", 1, null);
            answers.add(answer);
            answer = new Answer("Выраженная афазия", 2, null);
            answers.add(answer);
            answer = new Answer("Полная афазия", 3, null);
            answers.add(answer);
            question = new Question("Афазия. Пациента просят описать картинку, назвать предмет, прочитать предложение", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Нормальная артикуляция", 0, null);
            answers.add(answer);
            answer = new Answer("Легкая или средняя дизартрия. Не выговаривает некоторые слова", 1, null);
            answers.add(answer);
            answer = new Answer("Выраженная дизартрия", 2, null);
            answers.add(answer);
            answer = new Answer("Интубирован или другой физический барьер", 3, null);
            answers.add(answer);
            question = new Question("Дизатрия", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Нет агнозии", 0, null);
            answers.add(answer);
            answer = new Answer("Игнорирование к двухсторонней последовательной стимуляции одной сенсорной модальности", 1, null);
            answers.add(answer);
            answer = new Answer("Выраженная гемиагнозия или гемиагнозия более чем в одной модальности", 2, null);
            answers.add(answer);
            question = new Question("Агнозия", answers);
            questions.add(question);

            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeHuntHessScale(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала Ханта-Хесса";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Неразорвавшаяся аневризма, бессимптомное течение", 0, null);
            answers.add(answer);
            answer = new Answer("Бессимптомное течение, возможна слабовыраженная головная боль или ригидность мышц затылка", 1, null);
            answers.add(answer);
            answer = new Answer("Головная боль умеренная или слабовыраженная; менингеальный синдром выражен; очаговая неврологическая симптоматика отсутствует за исключением возможного поражения глазодвигательных нервов", 2, null);
            answers.add(answer);
            answer = new Answer("Менингеальный синдром выражен; сознание расстроено до оглушения; очаговая симптоматика умеренно выражена", 3, null);
            answers.add(answer);
            answer = new Answer("Менингеальный синдром выражен; сознание расстроено до сопора; очаговая симптоматика выражена; имеются признаки нарушения витальных функций", 4, null);
            answers.add(answer);
            answer = new Answer("Кома различной глубины; акинетический мутизм, децеребрационная ригидность", 5, null);
            answers.add(answer);
            Question question = new Question("Состояние пацинета", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Да", 1, null);
            answers.add(answer);
            answer = new Answer("Нет", 0, null);
            answers.add(answer);
            question = new Question("Есть ли у пациента сопутствующие системные заболевания и состояния: артериальная гипертензия, сахарный диабет, атеросклероз, ХОБЛ, или вазоспазм при ангиографии.", answers);
            questions.add(question);

            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeIndexBartel(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Индекс Бартела";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Полностью несамостоятельно (зависимо от окружающих)", 0, null);
            answers.add(answer);
            answer = new Answer("Частично нуждается в помощи при разрезании, намазывании масла и т.д. или требует специальной диеты", 5, null);
            answers.add(answer);
            answer = new Answer("Независим (не нуждается в помощи)", 10, null);
            answers.add(answer);
            Question question = new Question("Приём пищи", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Зависим(нуждается в помощи)", 0, null);
            answers.add(answer);
            answer = new Answer("Принимает ванну без посторонней помощи (или при приеме душа", 5, null);
            answers.add(answer);
            question = new Question("Приём ванны", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Нуждается в помощи при выполнении процедур личной гигиены", 0, null);
            answers.add(answer);
            answer = new Answer("Самостоятельно чистит зубы, умывается, причесывается", 5, null);
            answers.add(answer);
            question = new Question("Гигиенические процедуры", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Полностью зависим", 0, null);
            answers.add(answer);
            answer = new Answer("Частично нуждается в помощи, но может выполнять примерно половину действий самостоятельно", 5, null);
            answers.add(answer);
            answer = new Answer("Не нуждается в помощи (в том числе при застегивании пуговиц, молний, завязывании шнурков и т.д.)", 10, null);
            answers.add(answer);
            question = new Question("Одевание", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Недержание (или необходимо применение клизмы)", 0, null);
            answers.add(answer);
            answer = new Answer("Периодическое недержание", 5, null);
            answers.add(answer);
            answer = new Answer("Полностью контролирует", 10, null);
            answers.add(answer);
            question = new Question("Акт дефекации", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Недержание, или катетеризация, или задержка мочеиспускания", 0, null);
            answers.add(answer);
            answer = new Answer("Периодическое недержание", 5, null);
            answers.add(answer);
            answer = new Answer("Полностью контролирует", 10, null);
            answers.add(answer);
            question = new Question("Акт мочеиспускания", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Полностью зависим от окружающих", 0, null);
            answers.add(answer);
            answer = new Answer("Нуждается в некоторой помощи, но часть действий может выполнять самостоятельно", 5, null);
            answers.add(answer);
            answer = new Answer("Не нуждается в помощи (одевается, осуществляет гигиенические процедуры)", 10, null);
            answers.add(answer);
            question = new Question("Пользование туалетом", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Перемещение невозможно, не удерживает равновесие сидя", 0, null);
            answers.add(answer);
            answer = new Answer("Нуждается в значительной помощи (физической, одного или двух человек), может сидеть", 5, null);
            answers.add(answer);
            answer = new Answer("Нуждается в незначительной помощи (вербальной или физической)", 10, null);
            answers.add(answer);
            answer = new Answer("Не нуждается в помощи", 15, null);
            answers.add(answer);
            question = new Question("Перемещение (с кровати на стул и обратно)", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Неспособен к передвижению, или < 50 м", 0, null);
            answers.add(answer);
            answer = new Answer("Самостоятельное перемещение в инвалидном кресле, включая углы, > 50 м", 5, null);
            answers.add(answer);
            answer = new Answer("Ходит с помощью одного лица (вербальной или физической), > 50 м", 10, null);
            answers.add(answer);
            answer = new Answer("Не нуждается в помощи (но может использовать вспомогательные средства, например, трость), > 50 м", 10, null);
            answers.add(answer);
            question = new Question("Передвижение (на ровной поверхности)", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Неспособен подниматься по лестнице даже с поддержкой", 0, null);
            answers.add(answer);
            answer = new Answer("Нуждается в помощи (вербальной, физической, вспомогательном средстве)", 5, null);
            answers.add(answer);
            answer = new Answer("Не нуждается в помощи", 10, null);
            answers.add(answer);
            question = new Question("Ходьба по лестнице", answers);
            questions.add(question);
            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeGlasgowComaScale(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала комы Глазко";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Не открывает", 1, null);
            answers.add(answer);
            answer = new Answer("Открывает, как реакция на болевое раздражение", 2, null);
            answers.add(answer);
            answer = new Answer("Открывает, в ответ на голос", 3, null);
            answers.add(answer);
            answer = new Answer("Открывает самопроизвольно, наблюдает", 4, null);
            answers.add(answer);
            Question question = new Question("Открывание глаз", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Никаких звуков", 1, null);
            answers.add(answer);
            answer = new Answer("Издаёт звуки, но не слова", 2, null);
            answers.add(answer);
            answer = new Answer("Произносит отдельные слова", 3, null);
            answers.add(answer);
            answer = new Answer("Произноит фразы, но речь бессвязная", 4, null);
            answers.add(answer);
            answer = new Answer("Ориентирован, быстрый и правильный ответ на заданный вопрос", 5, null);
            answers.add(answer);
            question = new Question("Речевая реакция", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Не двигается", 1, null);
            answers.add(answer);
            answer = new Answer("Патологическое разгибание в ответ на боль", 2, null);
            answers.add(answer);
            answer = new Answer("Патологическое сгибание в ответ на боль", 3, null);
            answers.add(answer);
            answer = new Answer("Бессмысленные движения в ответ на боль", 4, null);
            answers.add(answer);
            answer = new Answer("Локализует боль, пытается её избежать", 5, null);
            answers.add(answer);
            answer = new Answer("Выполнение движений по голосовой команде", 6, null);
            answers.add(answer);
            question = new Question("Двигательная реакция", answers);
            questions.add(question);

            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }

    private static void initializeGlasgowComaFOUR(IService<Questionnaire, Long> service)
            throws PersistenceException {
        String title = "Шкала комы FOUR";
        Questionnaire questionnaire = ((QuestionnaireService) service).getByTitle(title);
        if (questionnaire == null) {
            Set<PatientCondition> patientConditions = new LinkedHashSet<>();
            Set<Question> questions = new LinkedHashSet<>();
            Set<Answer> answers = new LinkedHashSet<>();

            Answer answer = new Answer("Глаза остаются закрытыми в ответ на боль", 0, null);
            answers.add(answer);
            answer = new Answer("Глаза закрыты, открываются на боль, но слежения нет", 1, null);
            answers.add(answer);
            answer = new Answer("Глаза закрыты, открываются на громкий звук, но слежения нет", 2, null);
            answers.add(answer);
            answer = new Answer("Глаза открыты, но нет слежения", 3, null);
            answers.add(answer);
            answer = new Answer("Глаза открыты, слежение и мигание по команде", 4, null);
            answers.add(answer);
            Question question = new Question("Глазные реакции", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Нет ответа на боль или генерализованный миоклонический эпистатус", 0, null);
            answers.add(answer);
            answer = new Answer("Разгибательная поза на боль", 1, null);
            answers.add(answer);
            answer = new Answer("Сгибательный ответ на боль", 2, null);
            answers.add(answer);
            answer = new Answer("Локализует боль", 3, null);
            answers.add(answer);
            answer = new Answer("Выполняет команды (знак отлично, кулак, знак мира).", 4, null);
            answers.add(answer);
            question = new Question("Двигательные реакции", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Отсутствуют зрачковый, роговичный и кашлевой рефлексы", 0, null);
            answers.add(answer);
            answer = new Answer("Зрачковый и роговичный рефлексы отсутствуют", 1, null);
            answers.add(answer);
            answer = new Answer("Зрачковый ИЛИ роговичный ", 2, null);
            answers.add(answer);
            answer = new Answer("Один зрачок расширен и не реагирует на свет", 3, null);
            answers.add(answer);
            answer = new Answer("Зрачковый и роговичный рефлексы сохранены", 4, null);
            answers.add(answer);
            question = new Question("Стволовые рефлексы", answers);
            questions.add(question);

            answers = new LinkedHashSet<>();
            answer = new Answer("Полностью синхронен с аппаратом ИВЛ", 0, null);
            answers.add(answer);
            answer = new Answer("У интубированных: больной сопротивляется аппарату ИВЛ", 1, null);
            answers.add(answer);
            answer = new Answer("Нерегулярный ритм", 2, null);
            answers.add(answer);
            answer = new Answer("дыхание Чейна-Стокса", 3, null);
            answers.add(answer);
            answer = new Answer("Регулярный ритм", 4, null);
            answers.add(answer);
            question = new Question("Дыхательный паттерн", answers);
            questions.add(question);

            questionnaire = new Questionnaire(title, questions, patientConditions,
                    MedicalQuestionnaireType.FORMULA_CALCULATOR);
            service.create(questionnaire);
        }
    }
}
