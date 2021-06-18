package com.example.calculator;

import com.example.calculator.actions.Action;
import com.example.calculator.actions.ActionType;
import com.example.calculator.actions.ArithmeticAction;
import com.example.calculator.actions.AdditionAction;
import com.example.calculator.actions.CalculationAction;
import com.example.calculator.actions.DivideAction;
import com.example.calculator.actions.EmptyAction;
import com.example.calculator.actions.MultiplyAction;
import com.example.calculator.actions.NegativeAction;
import com.example.calculator.actions.PercentAction;
import com.example.calculator.actions.SubtractionAction;

class Calculator {

    private CalculatorCallback listener;
    private Operand firstOperand = new Operand();
    private Operand secondOperand = new Operand();
    private Action currentAction = new EmptyAction();

    public Calculator(CalculatorCallback listener) {
        this.listener = listener;
    }

    public void enterDigit(char digit) {
        try {
            if (isFirstOperandEditing()) {
                firstOperand.addDigit(digit);
            } else if (isSecondOperandEditing()) {
                secondOperand.addDigit(digit);
            }
        } catch (NumberFormatException ignored) {
        }
        notifyCallback(getFormulaText());
    }

    public void doAction(ActionType type) {
        if (type == ActionType.CALCULATION) {
            if (isBothOperandEntered()) {
                ((ArithmeticAction)currentAction).setSecond(secondOperand);
                doCalculations();
                return;
            }
        }
        if (type == ActionType.NEGATIVE && isFirstOperandEditing()) {
            NegativeAction action = new NegativeAction(firstOperand);
            firstOperand.setValue(action.doAction());
            notifyCallback(getFormulaText());
            return;
        }

        if (ActionType.isArithmetic(type)) {
            if (isBothOperandEntered()) {
                ((ArithmeticAction)currentAction).setSecond(secondOperand);
                doCalculations();
            }

            if (isFirstOperandEditing()) {
                currentAction = getArithmeticAction(type);
                ((ArithmeticAction)currentAction).setFirst(firstOperand);
            }
            notifyCallback(getFormulaText());
        }
    }

    public void clear() {
        firstOperand = new Operand();
        secondOperand = new Operand();
        currentAction = new EmptyAction();
        notifyCallback(getFormulaText());
    }

    private void doCalculations() {
        CalculationAction calculationAction = new CalculationAction((ArithmeticAction) currentAction);
        firstOperand.setValue(calculationAction.doAction());
        secondOperand = new Operand();
        currentAction = new EmptyAction();
        notifyCallback(getFormulaText());
    }

    private String getFormulaText() {
        return firstOperand.getStringValue()
                + currentAction.getStringAction()
                + secondOperand.getStringValue();
    }

    private void notifyCallback(String text) {
        if (listener != null) {
            listener.onActionComplete(text);
        }
    }

    private boolean isFirstOperandEditing() {
        return firstOperand.isEmpty() || currentAction.getType() == ActionType.NONE;
    }

    private boolean isSecondOperandEditing() {
        return !firstOperand.isEmpty() && ActionType.isArithmetic(currentAction.getType());
    }

    private boolean isBothOperandEntered() {
        return !firstOperand.isEmpty() && !secondOperand.isEmpty();
    }

    private ArithmeticAction getArithmeticAction(ActionType type) {
        switch (type) {
            case ADDITION: return new AdditionAction();
            case SUBTRACTION: return new SubtractionAction();
            case MULTIPLICATION: return new MultiplyAction();
            case DIVISION: return new DivideAction();
            case PERCENTAGE: return new PercentAction();
            case NONE:
            default:
                return new EmptyAction();
        }
    }
}
