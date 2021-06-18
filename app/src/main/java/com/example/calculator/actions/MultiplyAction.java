package com.example.calculator.actions;

public class MultiplyAction extends ArithmeticAction {

    public MultiplyAction() {
        super(ActionType.MULTIPLICATION);
    }

    @Override
    public Double doAction() {
        if (first != null && second != null) {
            return first.getValue() * second.getValue();
        }
        return Double.NaN;
    }

    @Override
    public String getStringAction() {
        return "*";
    }

}
