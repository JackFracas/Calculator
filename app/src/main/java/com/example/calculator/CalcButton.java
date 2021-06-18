package com.example.calculator;

class CalcButton {

    private int viewId;
    private int labelId;

    public CalcButton(int id, int label) {
        viewId = id;
        labelId = label;
    }

    public int getViewId() {
        return viewId;
    }

    public int getLabelId() {
        return labelId;
    }

}
