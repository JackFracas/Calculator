package com.example.calculator.actions;

import com.example.calculator.Operand;

public abstract class ArithmeticAction extends Action<Double>  {

    protected Operand first;
    protected Operand second;

    protected ArithmeticAction(final ActionType actionType) {
        super(actionType);
    }

    public Operand getFirst() {
        return first;
    }

    public void setFirst(final Operand first) {
        this.first = first;
    }

    public Operand getSecond() {
        return second;
    }

    public void setSecond(final Operand second) {
        this.second = second;
    }

}
