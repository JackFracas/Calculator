package com.example.calculator.actions;

public class CalculationAction extends Action<Double> {

    private ArithmeticAction actionToCalc;

    public CalculationAction(ArithmeticAction action) {
        super(ActionType.CALCULATION);
        actionToCalc = action;
    }

    @Override
    public String getStringAction() {
        return "+";
    }

    @Override
    public Double doAction() {
        if (actionToCalc != null) {
            return actionToCalc.doAction();
        }
        return Double.NaN;
    }
}
