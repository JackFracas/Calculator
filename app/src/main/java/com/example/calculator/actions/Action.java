package com.example.calculator.actions;

public abstract class Action<T> {

    private ActionType type;

    protected Action(ActionType actionType) {
        type = actionType;
    }

    public abstract T doAction();

    public ActionType getType() {
        return type;
    }

    public abstract String getStringAction();

}
