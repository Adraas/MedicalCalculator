package ru.code.open.functions;

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

    // TODO: implement this method
    private static Function<Map<String, Double>, Double> measureGRACEFunctionInit() {
        return (parametersByNames) -> null;
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
