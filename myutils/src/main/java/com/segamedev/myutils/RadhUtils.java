package com.segamedev.myutils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//
// Created by Fathur Radhy 
// on June 2019-06-22.
//
public class RadhUtils {
    public String toRupiahFormat(String value) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String convertedValue = formatter.format(Double.parseDouble(value)).replaceAll(",", ".");
        convertedValue = "Rp"+convertedValue;

        return convertedValue;
    }

    @SuppressLint("SimpleDateFormat")
    public String dateFormatCustom(String time) {
        Date dateTime = null;
        Date dateTime2 = null;
        try {
            dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime);

        Calendar today = Calendar.getInstance();
        Calendar yesterday = Calendar.getInstance();
        yesterday.add(Calendar.DATE, -1);

        try {
            dateTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(dateTime2);

        if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
            return new SimpleDateFormat("HH:mm").format(dateTime);
        } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
            return "Kemarin, " + new SimpleDateFormat("HH:mm").format(dateTime) + " WIB";
        } else {
            return new SimpleDateFormat("dd/MM/yyyy").format(dateTime) + ", " + new SimpleDateFormat("HH:mm").format(dateTime) + " WIB";
        }
    }

    public void formValidation(Context context, ArrayList<RadhFormModel> formModel, FormValidationListener listener) {
        int x = 0;
        while (x < formModel.size()) {
            RadhFormModel fm = formModel.get(x);

            if (TextUtils.isEmpty(fm.getEditText().getText())) {
                Log.d("RadhLog", "${et.formName} isEmpty");
                listener.onInvalid(String.format(context.getResources().getString(R.string.radh_form_is_empty), fm.getFormName()));
                return;
            } else {
                if (fm.getFormLenght() > 0) {
                    if (fm.getEditText().length() < fm.getFormLenght()) {
                        listener.onInvalid(String.format(context.getResources().getString(R.string.radh_form_length), fm.getFormName(), Integer.toString(fm.getFormLenght())));
                        return;
                    }
                }
            }
        }
    }
}
