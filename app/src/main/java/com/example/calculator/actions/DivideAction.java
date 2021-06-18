package com.example.calculator.actions;

public class DivideAction extends ArithmeticAction {

    public DivideAction() {
        super(ActionType.DIVISION);
    }

    @Override
    public String getStringAction() {
        return "/";
    }

    @Override
    public Double doAction() {
        if (first != null && second != null) {
            return first.getValue() / second.getValue();
        }
        return Double.NaN;
    }

}
