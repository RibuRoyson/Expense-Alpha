package com.example.ribu.expensealpha;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by ribu on 25-Sep-15.
 */
public class Monthwise extends Fragment {
    private BarChart mChart;
    Dbhandler dbh;
    int a,b,c,d,e,f,g,h,i,j,k,l,m;
    ArrayList<Integer> yData=new ArrayList<>();
    String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View rootView = inflater.inflate(R.layout.month_wise, container, false);
        dbh = new Dbhandler(getActivity());
        a = dbh.monthdatatotal(1);
        b = dbh.monthdatatotal(2);
        c = dbh.monthdatatotal(3);
        d = dbh.monthdatatotal(4);
        e = dbh.monthdatatotal(5);
        f = dbh.monthdatatotal(6);
        g = dbh.monthdatatotal(7);
        h = dbh.monthdatatotal(8);
        i = dbh.monthdatatotal(9);
        j = dbh.monthdatatotal(10);
        k = dbh.monthdatatotal(11);
        l = dbh.monthdatatotal(12);
        yData.add(a);
        yData.add(b);
        yData.add(c);
        yData.add(d);
        yData.add(e);
        yData.add(f);
        yData.add(g);
        yData.add(h);
        yData.add(i);
        yData.add(j);
        yData.add(k);
        yData.add(l);

        mChart = (BarChart)rootView.findViewById(R.id.chart1);

        mChart.setDescription("");

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setSpaceBetweenLabels(0);
        xAxis.setDrawGridLines(false);

        mChart.getAxisLeft().setDrawGridLines(false);

        // setting data


        // add a nice and smooth animation
        mChart.animateY(2500);

        mChart.getLegend().setEnabled(false);
        setData(11,100);
        // Legend l = mChart.getLegend();
        // l.setPosition(LegendPosition.BELOW_CHART_CENTER);
        // l.setFormSize(8f);
        // l.setFormToTextSpace(4f);
        // l.setXEntrySpace(6f);

        // mChart.setDrawLegend(false);
        return rootView;

    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        // IMPORTANT: In a PieChart, no values (Entry) should have the same
        // xIndex (even if from different DataSets), since no values can be
        // drawn above each other.
        for (int i = 0; i < count + 1; i++) {
            yVals1.add(new BarEntry(yData.get(i),i));

        }

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < count + 1; i++)
            xVals.add(mMonths[i % mMonths.length]);

        BarDataSet set1 = new BarDataSet(yVals1, "Data Set");
        set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
        set1.setDrawValues(false);

        ArrayList<BarDataSet> dataSets = new ArrayList<BarDataSet>();
        dataSets.add(set1);

        BarData data = new BarData(xVals, dataSets);

        mChart.setData(data);
        mChart.invalidate();
    }
}
