package ru.code.open.entities;

/**
 * The enum {@code MedicalQuestionnaireType} is an embeddable type for the {@code Questionnaire} entity. This enum
 * represents a medical calculator questionnaire type.
 */
public enum MedicalQuestionnaireType {

    /**
     * The calculator type with the simple summation scores.
     */
    POINTS_SUMMATION_CALCULATOR,

    /**
     * The calculator type with the specific formulas.
     */
    FORMULA_CALCULATOR
}