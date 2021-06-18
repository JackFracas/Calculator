package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.calculator.actions.ActionType;

public class MainActivity extends AppCompatActivity implements CalculatorCallback {

    private TextView textView;
    private Calculator calculator = new Calculator(this);

    private static final CalcButton[] DIGIT_BUTTONS = {
            new CalcButton(R.id.button_1, R.string._1),
            new CalcButton(R.id.button_2, R.string._2),
            new CalcButton(R.id.button_3, R.string._3),
            new CalcButton(R.id.button_4, R.string._4),
            new CalcButton(R.id.button_5, R.string._5),
            new CalcButton(R.id.button_6, R.string._6),
            new CalcButton(R.id.button_7, R.string._7),
            new CalcButton(R.id.button_8, R.string._8),
            new CalcButton(R.id.button_9, R.string._9),
            new CalcButton(R.id.button_0, R.string._0),
            new CalcButton(R.id.button_point, R.string._point)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public void onActionComplete(final String result) {
        textView.setText(result);
    }

    @SuppressWarnings("ObjectAllocationInLoop")
    private void initDigitButtons(TextView valueTextView) {
        for(CalcButton calcButton : DIGIT_BUTTONS) {
            View button = findViewById(calcButton.getViewId());
            if (button != null) {
                button.setOnClickListener(
                        new DigitButtonClickListener(
                                getString(calcButton.getLabelId()).charAt(0),
                                calculator
                        )
                );
            }
        }
    }

    private void initActionButtons() {
        findViewById(R.id.button_ac).setOnClickListener(v -> calculator.clear());
        findViewById(R.id.button_plus_minus).setOnClickListener(v -> calculator.doAction(ActionType.NEGATIVE));
        findViewById(R.id.button_percent).setOnClickListener(v -> calculator.doAction(ActionType.PERCENTAGE));
        findViewById(R.id.button_division).setOnClickListener(v -> calculator.doAction(ActionType.DIVISION));
        findViewById(R.id.button_multiply).setOnClickListener(v -> calculator.doAction(ActionType.MULTIPLICATION));
        findViewById(R.id.button_equals).setOnClickListener(v -> calculator.doAction(ActionType.CALCULATION));
        findViewById(R.id.button_plus).setOnClickListener(v -> calculator.doAction(ActionType.ADDITION));
        findViewById(R.id.button_minus).setOnClickListener(v -> calculator.doAction(ActionType.SUBTRACTION));
    }

    private void initViews() {
        textView = findViewById(R.id.textView);
        initDigitButtons(textView);
        initActionButtons();
    }

}