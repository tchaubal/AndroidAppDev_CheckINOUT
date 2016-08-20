package com.example.tanushreechaubal.check_in_out_feature;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by TanushreeChaubal on 7/31/16.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{


    EditText txtDate1,txtDate2;

    public DateDialog(View view){
        txtDate1 = (EditText)view;
        txtDate2 = (EditText)view;
    }

    public DateDialog(){

    }

    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

        String date1 = day+"-"+(month+1)+"-"+year;
        txtDate1.setText(date1);

        String date2 = day+"-"+(month+1)+"-"+year;
        txtDate2.setText(date2);
    }
}
