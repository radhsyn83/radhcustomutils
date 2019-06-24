package com.segamedev.myutils;

import android.widget.EditText;

import androidx.annotation.Nullable;

//
// Created by Fathur Radhy 
// on June 2019-06-22.
//
public class FormValidationModel {
    private EditText editText;
    private String formName;
    private int formLenght;

    public FormValidationModel(EditText editText, String formName, int formLenght) {
        this.editText = editText;
        this.formName = formName;
        this.formLenght = formLenght;
    }

    public EditText getEditText() {
        return editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public int getFormLenght() {
        return formLenght;
    }

    public void setFormLenght(int formLenght) {
        this.formLenght = formLenght;
    }
}
