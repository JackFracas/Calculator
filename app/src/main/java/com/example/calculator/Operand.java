package com.example.calculator;

public class Operand {

    private Double value = Double.NaN;
    private String stringValue = "";

    public String getStringValue() {
        return stringValue;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(final Double value) {
        this.value = value;
        if (Double.isNaN(value)) {
            stringValue = "";
        } else if (value % 1 == 0) {
            stringValue = String.valueOf(value.intValue());
        } else {
            stringValue = String.valueOf(value);
        }
    }

    public void addDigit(char digit) {
        if (digit == '0' && !stringValue.contains(".") && value == 0) {
            return;
        }
        if (Character.isDigit(digit)) {
            int number = Character.getNumericValue(digit);
            if (Double.isNaN(value)) {
                value = (double)number;
                stringValue = String.valueOf(value.intValue());
            } else {
                stringValue = stringValue + number;
                value = Double.parseDouble(stringValue);
            }
        } else if (digit == '.') {
            setEmptyDecimal();
        }
    }

    public boolean isEmpty() {
        return stringValue.isEmpty();
    }

    private void setEmptyDecimal() {
        if (!stringValue.contains(".")) {
            if (Double.isNaN(value)) {
                stringValue ="0.";
                value = 0.0;
            } else if (value % 1 == 0){
                stringValue = String.valueOf(value.intValue()) + '.';
            }
        }
    }

}
