package ru.code.open.functions;

import java.util.Map;
import java.util.function.Function;

// TODO: implement Function objects initializing methods
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
        return (parametersByNames) -> null;
    }

    private static Function<Map<String, Double>, Double> measureGRACEFunctionInit() {
        return (parametersByNames) -> null;
    }

    private static Function<Map<String, Double>, Double> explorationMDRDFunctionInit() {
        return (parametersByNames) -> null;
    }

    private static Function<Map<String, Double>, Double> measureBySchwartzGJFunctionInit() {
        return (parametersByNames) -> null;
    }

    private static Function<Map<String, Double>, Double> drugAdministrationRateFunctionInit() {
        return (parametersByNames) -> null;
    }
}
