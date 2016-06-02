package com.example.mishu.vitasourcedevelop.Fragment;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mishu.vitasourcedevelop.R;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.filter.Approximator;
import com.github.mikephil.charting.data.filter.Approximator.ApproximatorType;
import com.github.mikephil.charting.formatter.FillFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;


import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AdminDashBoard extends Fragment {


    private CombinedChart mChart,incomeChart,costChart;
    private final int itemcount = 4;
    protected String[] mMonths = new String[] {"Project1", "Project2", "Project3", "Project4"};
    private Typeface tf;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_admin_dash_board, container, false);

        runningProjectPerformance(view);
        income(view);
        cost(view);


        return view;
    }



    private void runningProjectPerformance(View view) {
        mChart = (CombinedChart)view.findViewById(R.id.chartProject);
        mChart.setDescription("");
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);


        // draw bars behind lines
        mChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        CombinedData data = new CombinedData(mMonths);
        data.setData(generateBarData());

        mChart.setData(data);
        mChart.invalidate();

    }


    private BarData generateBarData() {

        BarData d = new BarData();

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

//        for (int index = 0; index < itemcount; index++)
//            entries.add(new BarEntry(getRandom(15, 30), index));
        entries.add(new BarEntry(10, 0));
        entries.add(new BarEntry(40, 1));
        entries.add(new BarEntry(50, 2));
        entries.add(new BarEntry(15, 3));

        BarDataSet set = new BarDataSet(entries, "Project preformance");
        set.setColor(Color.rgb(60, 220, 78));
        set.setValueTextColor(Color.rgb(60, 220, 78));
        set.setValueTextSize(10f);
        d.addDataSet(set);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        return d;
    }

    private void income(View view) {
        incomeChart = (CombinedChart)view.findViewById(R.id.chartIncome);
        incomeChart.setDescription("");
        incomeChart.setBackgroundColor(Color.alpha(50));
        mChart.setDrawGridBackground(false);
        incomeChart.setDrawBarShadow(false);


        // draw bars behind lines
        incomeChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });

        YAxis rightAxis = incomeChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = incomeChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = incomeChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        CombinedData data = new CombinedData(mMonths);
        data.setData(generateBarData1());

        incomeChart.setData(data);
        incomeChart.invalidate();

    }

    private BarData generateBarData1() {

        BarData d = new BarData();

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

//        for (int index = 0; index < itemcount; index++)
//            entries.add(new BarEntry(getRandom(15, 30), index));
        entries.add(new BarEntry(10, 0));
        entries.add(new BarEntry(40, 1));
        entries.add(new BarEntry(50, 2));
        entries.add(new BarEntry(15, 3));

        BarDataSet set = new BarDataSet(entries, "Income");
        set.setColor(Color.rgb(60, 220, 78));
        set.setValueTextColor(Color.rgb(60, 220, 78));
        set.setValueTextSize(10f);
        d.addDataSet(set);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        return d;
    }

    private void cost(View view) {
        costChart = (CombinedChart)view.findViewById(R.id.chartCost);
        costChart.setDescription("");
        costChart.setBackgroundColor(Color.alpha(50));
        costChart.setDrawGridBackground(false);
        costChart.setDrawBarShadow(false);


        // draw bars behind lines
        costChart.setDrawOrder(new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.BUBBLE, CombinedChart.DrawOrder.CANDLE, CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
        });

        YAxis rightAxis = costChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis leftAxis = costChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        XAxis xAxis = costChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        CombinedData data = new CombinedData(mMonths);
        data.setData(generateBarData1());

        costChart.setData(data);
        costChart.invalidate();

    }

    private BarData generateBarData2() {

        BarData d = new BarData();

        ArrayList<BarEntry> entries = new ArrayList<BarEntry>();

//        for (int index = 0; index < itemcount; index++)
//            entries.add(new BarEntry(getRandom(15, 30), index));
        entries.add(new BarEntry(10, 0));
        entries.add(new BarEntry(40, 1));
        entries.add(new BarEntry(50, 2));
        entries.add(new BarEntry(15, 3));

        BarDataSet set = new BarDataSet(entries, "Cost");
        set.setColor(Color.rgb(60, 220, 78));
        set.setValueTextColor(Color.rgb(60, 220, 78));
        set.setValueTextSize(10f);
        d.addDataSet(set);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);

        return d;
    }

}
