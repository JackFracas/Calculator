package com.example.calculator.actions;

public enum ActionType {
    ADDITION,
    SUBTRACTION,
    MULTIPLICATION,
    DIVISION,
    PERCENTAGE,
    CALCULATION,
    NEGATIVE,
    DIGIT,
    NONE;

    public static boolean isArithmetic(ActionType type) {
        switch (type) {
            case ADDITION:
            case SUBTRACTION:
            case MULTIPLICATION:
            case DIVISION:
            case PERCENTAGE: return true;
            case NEGATIVE:
            case CALCULATION:
            case DIGIT:
            case NONE:
            default:
                return false;
        }
    }
}
