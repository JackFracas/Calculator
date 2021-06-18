package com.example.calculator.actions;

import com.example.calculator.Operand;

public class NegativeAction extends Action<Double> {

    private Operand value;

    public NegativeAction(Operand value) {
        super(ActionType.NEGATIVE);
        this.value = value;
    }

    @Override
    public Double doAction() {
        return -1 * value.getValue();
    }

    @Override
    public String getStringAction() {
        if (value.getValue() < 0) {
            return "-";
        } else {
            return "";
        }
    }
}
