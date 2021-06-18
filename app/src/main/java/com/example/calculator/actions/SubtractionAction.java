package com.example.calculator.actions;

public class SubtractionAction extends ArithmeticAction {

    public SubtractionAction() {
        super(ActionType.SUBTRACTION);
    }

    @Override
    public Double doAction() {
        if (first != null && second != null) {
            return first.getValue() - second.getValue();
        }
        return Double.NaN;
    }

    @Override
    public String getStringAction() {
        return "-";
    }

}
