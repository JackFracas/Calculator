package com.example.calculator;

import android.view.View;

class DigitButtonClickListener implements View.OnClickListener {

    private Calculator calculator;
    private char buttonLabel;

    public DigitButtonClickListener(char label, Calculator calculator) {
        this.calculator = calculator;
        buttonLabel = label;
    }

    @Override
    public void onClick(final View v) {
        if (calculator != null) {
            calculator.enterDigit(buttonLabel);
        }
    }

}
