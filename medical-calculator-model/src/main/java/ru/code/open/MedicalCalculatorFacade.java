package ru.code.open;

import lombok.Getter;
import ru.code.open.algorithm.MedicalCalculator;
import ru.code.open.functions.FunctionInitializer;

@Getter
public class MedicalCalculatorFacade {

    private MedicalCalculator medicalCalculator;
    private RepositoryFacade repositoryFacade;

    public MedicalCalculatorFacade(RepositoryFacade repositoryFacade) {
        medicalCalculator = new MedicalCalculator();
        FunctionInitializer.initializeFunctions();
        this.repositoryFacade = repositoryFacade;
    }
}
