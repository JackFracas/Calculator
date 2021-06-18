package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity<decimalFormat> extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonAC;
    private Button buttonPlusMinus;
    private Button buttonPercent;
    private Button buttonDivision;
    private Button buttonMultiply;
    private Button buttonPoint;
    private Button buttonEquals;
    private Button buttonPlus;
    private Button buttonMinus;
    private TextView textView;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENTAGE = '%';
    private static final char NEGATIVE = '-';
    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;



    public MainActivity() {
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        decimalFormat = new DecimalFormat("#.##########");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
//        setOnClickListeners();
    }

    private void findViews() {

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        button0 = findViewById(R.id.button_0);
        buttonAC = findViewById(R.id.button_ac);
        buttonPlusMinus = findViewById(R.id.button_plus_minus);
        buttonPercent = findViewById(R.id.button_percent);
        buttonDivision = findViewById(R.id.button_division);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonPoint = findViewById(R.id.button_point);
        buttonEquals = findViewById(R.id.button_equals);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        textView = findViewById(R.id.textView);


        class ActionClickListener implements View.OnClickListener{
            private char current_action;
            ActionClickListener(char current_action){
                this.current_action = current_action;
            }
            public void onClick(View v){
                CURRENT_ACTION = current_action;
                Calculations();
                textView.setText(decimalFormat.format(valueOne));
                textView.setText(null);
            }
        }

        ActionClickListener division = new ActionClickListener(DIVISION);
        ActionClickListener multiplication = new ActionClickListener(MULTIPLICATION);
        ActionClickListener substraction = new ActionClickListener(SUBTRACTION);
        ActionClickListener addition = new ActionClickListener(ADDITION);
        ActionClickListener percantage = new ActionClickListener(PERCENTAGE);

        buttonPoint.setOnClickListener(v -> {
            String Point = textView.getText().toString();
            if (Point.contains(getString(R.string._point))) {
                v.setClickable(false);
            } else {
                textView.setText(textView.getText().toString() + getString(R.string._point));
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._1));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._2));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._3));
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._4));
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextDigitButton();
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._6));
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._7));
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._8));
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(textView.getText().toString() + getString(R.string._9));
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(decimalFormat.format(valueOne));
            }


        });
        buttonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                textView.setText("");
            }
        });


        buttonPercent.setOnClickListener(percantage);
        buttonMultiply.setOnClickListener(multiplication);
        buttonDivision.setOnClickListener(division);
        buttonPlus.setOnClickListener(addition);
        buttonMinus.setOnClickListener(substraction);
        /*{
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = NEGATIVE;
                Calculations();
                textView.setText(decimalFormat.format(valueOne));
                textView.setText(null);
            }
        });*/

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculations();
                textView.setText(decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';
            }

        });


        buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(MainActivity.this,
                        R.string.surpise,
                        duration);
                toast.setGravity(Gravity.TOP, 0, 0);
                toast.show();
            }
        });

    }

    private void TextDigitButton() {
        textView.setText(textView.getText().toString() + getString(R.string._5));
    }


    private void Calculations() {
        {
            if(!Double.isNaN(valueOne)) {
                valueTwo = Double.parseDouble(textView.getText().toString());
                textView.setText(null);
                if(CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if(CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if(CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if(CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;
                else if(CURRENT_ACTION == PERCENTAGE)
                    valueOne = (this.valueOne / valueTwo) /100;
            }
            else {
                try {
                    valueOne = Double.parseDouble(textView.getText().toString());
                }
                catch (Exception e){

                }
            }
        }

    }
}