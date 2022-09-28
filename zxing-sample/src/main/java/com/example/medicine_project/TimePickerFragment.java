package com.example.medicine_project;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    public static final String FRAGMENT_TAG = "TimePickerFragment";

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Calendar mCalendar = Calendar.getInstance();
        int hour = mCalendar.get(Calendar.HOUR_OF_DAY);
        int min = mCalendar.get(Calendar.MINUTE);

        TimePickerDialog mTimePickerDialog = new TimePickerDialog(
                getContext(), this, hour, min, DateFormat.is24HourFormat(getContext())
        );
        return mTimePickerDialog;
    }
}
