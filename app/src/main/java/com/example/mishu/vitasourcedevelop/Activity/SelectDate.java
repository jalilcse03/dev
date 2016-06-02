package com.example.mishu.vitasourcedevelop.Activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.example.mishu.vitasourcedevelop.Others.CommonFunction;
import com.example.mishu.vitasourcedevelop.R;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

/**
 * Created by Murtuza on 6/2/2016.
 */
public class SelectDate extends AppCompatActivity implements OnClickListener, OnDateSetListener {
    TextView txtFromDate, txtFromMonth, txtFromYear, txtToDate, txtToMonth, txtToYear,txtTo,txtFrom;
    Calendar mCalendarTo, mCalenderFrom;
    CommonFunction commonFunction;
    private boolean isDateTo = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCalendarTo = Calendar.getInstance();
        mCalenderFrom = Calendar.getInstance();
        commonFunction = new CommonFunction();

        mCalenderFrom.setTimeInMillis(getIntent().getLongExtra("calendarFrom", 0l));
        mCalendarTo.setTimeInMillis(getIntent().getLongExtra("calendarTo", 0l));

        setContentView(R.layout.activity_select_date);
        initUI();
        updateText();
    }

    private void initUI() {
        txtFromDate = (TextView) findViewById(R.id.txt_from_date);
        txtFromMonth = (TextView) findViewById(R.id.txt_from_month);
        txtFromYear = (TextView) findViewById(R.id.txt_from_year);
        txtToDate = (TextView) findViewById(R.id.txt_to_date);
        txtToMonth = (TextView) findViewById(R.id.txt_to_month);
        txtToYear = (TextView) findViewById(R.id.txt_to_year);
        txtFrom= (TextView) findViewById(R.id.txtFrom);

        txtTo = (TextView) findViewById(R.id.txtTo);

        findViewById(R.id.txt_ok).setOnClickListener(this);
        findViewById(R.id.txt_cancel).setOnClickListener(this);
        findViewById(R.id.ll_date_from).setOnClickListener(this);
        findViewById(R.id.ll_date_to).setOnClickListener(this);
    }
    private void updateText() {
        txtToDate.setText(mCalendarTo.get(Calendar.DAY_OF_MONTH) + "");
        txtToYear.setText(mCalendarTo.get(Calendar.YEAR) + "");
        txtToMonth.setText(commonFunction.getFormattedDate(mCalendarTo.getTimeInMillis(), "MMM"));
        txtFromDate.setText(mCalenderFrom.get(Calendar.DAY_OF_MONTH) + "");
        txtFromYear.setText(mCalenderFrom.get(Calendar.YEAR) + "");
        txtFromMonth.setText(commonFunction.getFormattedDate(mCalenderFrom.getTimeInMillis(), "MMM"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_date_to:
                isDateTo = true;
                com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialogTo = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.newInstance(this, mCalendarTo.get(Calendar.YEAR),
                        mCalendarTo.get(Calendar.MONTH), mCalendarTo.get(Calendar.DAY_OF_MONTH));
                datePickerDialogTo.setMaxDate(Calendar.getInstance());
                datePickerDialogTo.show(getFragmentManager(), "datepicker_to");
                break;
            case R.id.ll_date_from:
                isDateTo = false;
                DatePickerDialog datePickerDialogFrom = DatePickerDialog.newInstance(this, mCalenderFrom.get(Calendar.YEAR),
                        mCalenderFrom.get(Calendar.MONTH), mCalenderFrom.get(Calendar.DAY_OF_MONTH));
                datePickerDialogFrom.setMaxDate(Calendar.getInstance());

                datePickerDialogFrom.show(getFragmentManager(), "datepicker_to");
                break;
            case R.id.txt_ok:
                finish();
                break;
            case R.id.txt_cancel:
                finish();
                break;
        }
    }


    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {

        if (isDateTo) {
            mCalendarTo.set(Calendar.YEAR, year);
            mCalendarTo.set(Calendar.MONTH, monthOfYear);
            mCalendarTo.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateText();
        } else {
            mCalenderFrom.set(Calendar.YEAR, year);
            mCalenderFrom.set(Calendar.MONTH, monthOfYear);
            mCalenderFrom.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateText();
        }
    }
}
