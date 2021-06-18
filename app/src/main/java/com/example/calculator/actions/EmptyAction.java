package com.example.calculator.actions;

public class EmptyAction extends ArithmeticAction {

    public EmptyAction() {
        super(ActionType.NONE);
    }

    @Override
    public Double doAction() {
        return Double.NaN;
    }

    @Override
    public String getStringAction() {
        return "";
    }

}
