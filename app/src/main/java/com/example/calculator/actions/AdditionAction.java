package com.example.calculator.actions;

public class AdditionAction extends ArithmeticAction {

    public AdditionAction() {
        super(ActionType.ADDITION);
    }

    @Override
    public String getStringAction() {
        return "+";
    }

    @Override
    public Double doAction() {
        if (first != null && second != null) {
            return first.getValue() + second.getValue();
        }
        return Double.NaN;
    }

}
