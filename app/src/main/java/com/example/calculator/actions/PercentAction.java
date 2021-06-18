package com.example.calculator.actions;

public class PercentAction extends ArithmeticAction {

    public PercentAction() {
        super(ActionType.PERCENTAGE);
    }

    @Override
    public Double doAction() {
        if (first != null && second != null) {
            return (first.getValue() * second.getValue()) / 100;
        }
        return Double.NaN;
    }

    @Override
    public String getStringAction() {
        return "%";
    }

}
