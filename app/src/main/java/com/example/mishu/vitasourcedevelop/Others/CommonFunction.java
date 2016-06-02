package com.example.mishu.vitasourcedevelop.Others;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Murtuza on 6/2/2016.
 */
public class CommonFunction {
    public CommonFunction(){}
    @SuppressLint("SimpleDateFormat")
    public String getFormattedDate(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }
}
