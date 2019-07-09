package ru.code.open.functions;

import ru.code.open.functions.util.Interval;
import ru.code.open.functions.util.MeasureGRACEFunctionUtil;

import java.util.Map;
import java.util.function.Function;

public class FunctionInitializer {

    public static void initializeFunctions() {
        FunctionRepository.addFunctionForGivenCalculator("Оценка клиренса креатинина по Cockcroft - Gault",
                creatinineClearanceFunctionInit());
        FunctionRepository.addFunctionForGivenCalculator("Шкала GRACE", measureGRACEFunctionInit());
        FunctionRepository.addFunctionForGivenCalculator("Скорость клубочковой фильтрации по формулам "
                .concat("MDRD и Schwartz"), explorationMDRDFunctionInit());
        FunctionRepository.addFunctionForGivenCalculator("Скорость клубочковой фильтрации по формулам "
                .concat("MDRD и Schwartz"), measureBySchwartzGJFunctionInit());
        FunctionRepository.addFunctionForGivenCalculator("Расчет скорости внутривенного капельного "
                .concat("введения препарата"), drugAdministrationRateFunctionInit());
    }

    private static Function<Map<String, Double>, Double> creatinineClearanceFunctionInit() {
        return (parametersByNames) -> {
            int age = parametersByNames.get("age").intValue();
            double weight = parametersByNames.get("weight");
            double genderCoefficient = parametersByNames.get("gender").longValue() == 0 ? 1 : 0.85;
            double creatinine = parametersByNames.get("creatinine");
            return ((140 - age) * weight * genderCoefficient) / (72 * creatinine);
        };
    }

    private static Function<Map<String, Double>, Double> measureGRACEFunctionInit() {
        return (parametersByNames) -> {
            Map<Interval<Integer>, Integer> age = MeasureGRACEFunctionUtil.getAge();
            Map<Interval<Integer>, Integer> heartRate = MeasureGRACEFunctionUtil.getHeartRate();
            Map<Interval<Integer>, Integer> systolicBloodPressure = MeasureGRACEFunctionUtil.getSystolicBloodPressure();
            Map<Interval<Double>, Integer> serumCreatinine = MeasureGRACEFunctionUtil.getSerumCreatinine();
            Map<String, Integer> heartFailureSeverity = MeasureGRACEFunctionUtil.getHeartFailureSeverity();
            int ageScore = parametersByNames.get("ageScore").intValue();
            ageScore = age.get(MeasureGRACEFunctionUtil.getInterval(ageScore, age));
            int heartRateScore = parametersByNames.get("heartRateScore").intValue();
            heartRateScore = heartRate.get(MeasureGRACEFunctionUtil.getInterval(heartRateScore, age));
            int systolicBloodPressureScore = parametersByNames.get("systolicBloodPressureScore").intValue();
            systolicBloodPressureScore = systolicBloodPressure.get(MeasureGRACEFunctionUtil
                    .getInterval(systolicBloodPressureScore, age));
            int serumCreatinineScore = parametersByNames.get("serumCreatinineScore").intValue();
            serumCreatinineScore = serumCreatinine.get(MeasureGRACEFunctionUtil.getInterval(serumCreatinineScore, age));
            byte heartFailureSeverityType = parametersByNames.get("heartFailureSeverityType").byteValue();
            int heartFailureSeverityScore = heartFailureSeverityType == 0
                    ? heartFailureSeverity.get("Кардиогенный шок (IV)")
                    : heartFailureSeverityType == 1
                    ? heartFailureSeverity.get("Острый отек легких (III)")
                    : heartFailureSeverityType == 2
                    ? heartFailureSeverity
                    .get("Наличие хрипов в легких и/или повышенного давления в югулярных венах (II)")
                    : heartFailureSeverity.get("Отсутствие признаков застойной сердечной недостаточности (I)");
            byte cardiacArrest = (byte) (parametersByNames.get("cardiacArrest").byteValue() == 0 ? 39 : 0);
            byte stSegmentDeviation = (byte) (parametersByNames.get("stSegmentDeviation").byteValue() == 0 ? 28 : 0);
            byte cardiospecificEnzymesLevelIncrease = (byte) (parametersByNames
                    .get("cardiospecificEnzymesLevelIncrease").byteValue() == 0 ? 14 : 0);
            return (double) (ageScore + heartRateScore + systolicBloodPressureScore + serumCreatinineScore
                    + heartFailureSeverityScore + cardiacArrest + stSegmentDeviation
                    + cardiospecificEnzymesLevelIncrease);
        };
    }

    private static Function<Map<String, Double>, Double> explorationMDRDFunctionInit() {
        return (parametersByNames) -> {
            double scr = parametersByNames.get("scr");
            double idms = parametersByNames.get("idms").byteValue() == 0 ? 0.95 : 1;
            int age = parametersByNames.get("age").intValue();
            double genderCoefficient = parametersByNames.get("gender").byteValue() == 0 ? 1 : 0.742;
            double raceCoefficient = parametersByNames.get("race").byteValue() == 0 ? 1 : 1.212;
            return 175 * Math.pow((scr * idms) / 88.4, -1.154) * Math.pow(age, -0.203) * genderCoefficient
                    * raceCoefficient;
        };
    }

    private static Function<Map<String, Double>, Double> measureBySchwartzGJFunctionInit() {
        return (parametersByNames) -> {
            double growth = parametersByNames.get("growth");
            double scr = parametersByNames.get("scr");
            return (36.2 * growth) / scr;
        };
    }

    private static Function<Map<String, Double>, Double> drugAdministrationRateFunctionInit() {
        return (parametersByNames) -> {
            double volume = parametersByNames.get("volume");
            double time = parametersByNames.get("time");
            return (volume * 20) / time;
        };
    }
}
