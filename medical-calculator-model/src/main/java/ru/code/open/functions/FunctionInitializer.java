package ru.code.open.functions;

import ru.code.open.exceptions.AlgorithmException;
import ru.code.open.functions.util.Interval;
import ru.code.open.functions.util.MeasureGRACEFunctionUtil;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class FunctionInitializer {

    public static void initializeFunctions() {
        Set<String> possibleValues = new HashSet<>();

        possibleValues.add("age");
        possibleValues.add("weight");
        possibleValues.add("gender");
        possibleValues.add("serumCreatinine");
        FunctionRepository.addFunctionForGivenCalculator("Оценка клиренса креатинина по Cockcroft - Gault",
                possibleValues, creatinineClearanceFunctionInit());
        possibleValues.clear();

        possibleValues.add("age");
        possibleValues.add("heartRate");
        possibleValues.add("systolicBloodPressure");
        possibleValues.add("serumCreatinine");
        possibleValues.add("heartFailureSeverityType");
        possibleValues.add("cardiacArrest");
        possibleValues.add("stSegmentDeviation");
        possibleValues.add("cardiospecificEnzymesLevelIncrease");
        FunctionRepository.addFunctionForGivenCalculator("Шкала GRACE", possibleValues,
                measureGRACEFunctionInit());
        possibleValues.clear();

        possibleValues.add("scr");
        possibleValues.add("idms");
        possibleValues.add("age");
        possibleValues.add("gender");
        possibleValues.add("race");
        FunctionRepository.addFunctionForGivenCalculator("Скорость клубочковой фильтрации по формулам "
                .concat("MDRD и Schwartz"), possibleValues, explorationMDRDFunctionInit());
        possibleValues.clear();

        possibleValues.add("growth");
        possibleValues.add("scr");
        FunctionRepository.addFunctionForGivenCalculator("Скорость клубочковой фильтрации по формулам "
                .concat("MDRD и Schwartz"), possibleValues, measureBySchwartzGJFunctionInit());
        possibleValues.clear();

        possibleValues.add("volume");
        possibleValues.add("time");
        FunctionRepository.addFunctionForGivenCalculator("Расчет скорости внутривенного капельного "
                .concat("введения препарата"), possibleValues, drugAdministrationRateFunctionInit());
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
            try {
                Map<Interval<Integer>, Integer> ageMap;
                ageMap = MeasureGRACEFunctionUtil.getAge();
                Map<Interval<Integer>, Integer> heartRateMap = MeasureGRACEFunctionUtil.getHeartRate();
                Map<Interval<Integer>, Integer> systolicBloodPressureMap =
                        MeasureGRACEFunctionUtil.getSystolicBloodPressure();
                Map<Interval<Double>, Integer> serumCreatinineMap = MeasureGRACEFunctionUtil.getSerumCreatinine();
                Map<String, Integer> heartFailureSeverityMap = MeasureGRACEFunctionUtil.getHeartFailureSeverity();
                int age = parametersByNames.get("age").intValue();
                age = ageMap.get(MeasureGRACEFunctionUtil.getInterval(age, ageMap));
                int heartRate = parametersByNames.get("heartRate").intValue();
                heartRate = heartRateMap.get(MeasureGRACEFunctionUtil.getInterval(heartRate, ageMap));
                int systolicBloodPressure = parametersByNames.get("systolicBloodPressure").intValue();
                systolicBloodPressure = systolicBloodPressureMap.get(MeasureGRACEFunctionUtil
                        .getInterval(systolicBloodPressure, ageMap));
                int serumCreatinine = parametersByNames.get("serumCreatinine").intValue();
                serumCreatinine =
                        serumCreatinineMap.get(MeasureGRACEFunctionUtil.getInterval(serumCreatinine, ageMap));
                byte heartFailureSeverityType = parametersByNames.get("heartFailureSeverityType").byteValue();
                int heartFailureSeverity = heartFailureSeverityType == 0
                        ? heartFailureSeverityMap.get("Кардиогенный шок (IV)")
                        : heartFailureSeverityType == 1
                        ? heartFailureSeverityMap.get("Острый отек легких (III)")
                        : heartFailureSeverityType == 2
                        ? heartFailureSeverityMap
                        .get("Наличие хрипов в легких и/или повышенного давления в югулярных венах (II)")
                        : heartFailureSeverityMap.get("Отсутствие признаков застойной сердечной недостаточности (I)");
                byte cardiacArrest = (byte) (parametersByNames.get("cardiacArrest").byteValue() == 0 ? 39 : 0);
                byte stSegmentDeviation = (byte) (parametersByNames.get("stSegmentDeviation").byteValue() == 0 ? 28 : 0);
                byte cardiospecificEnzymesLevelIncrease = (byte) (parametersByNames
                        .get("cardiospecificEnzymesLevelIncrease").byteValue() == 0 ? 14 : 0);
                return (double) (age + heartRate + systolicBloodPressure + serumCreatinine
                        + heartFailureSeverity + cardiacArrest + stSegmentDeviation
                        + cardiospecificEnzymesLevelIncrease);
            } catch (AlgorithmException e) {
                e.printStackTrace();
            }
            return Double.NaN;
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
