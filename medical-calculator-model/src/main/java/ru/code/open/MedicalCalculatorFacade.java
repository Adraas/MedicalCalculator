package ru.code.open;

import lombok.Getter;
import ru.code.open.algorithm.MedicalCalculator;
import ru.code.open.functions.FunctionInitializer;

@Getter
public class MedicalCalculatorFacade {

    private MedicalCalculator medicalCalculator;

    public MedicalCalculatorFacade() {
        medicalCalculator = new MedicalCalculator();
        FunctionInitializer.initializeFunctions();
    }
}
