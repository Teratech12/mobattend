package com.example.sky_phase.mobattend;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */
public class WhenStatisticsIsSelected extends Fragment {
    LinearLayout linear;
    ArrayList<DataModel> dataModels;
    ListView listView;
    String date;
    private static CustomAdapter adapter;
    ArrayList<DataModelforScreenTwo> dataModels2;
    ListView listView2;
    String date2;
    MobattendDatabase db1 = new MobattendDatabase(getContext());
    TextView text1, text2, text3;

    private static CustomAdapterforScreenTwo adapter2;
    String randonName,  randomId, randomClass, randomName2, randomId2, randomClass2;

    PieChart mChart;
    // we're going to display pie chart for school attendance
    private int[] yValues = {10, 7, 8};
    private String[] xValues = {"Present", "Absent", "Permission"};

    // colors for different sections in pieChart
    public static final int[] MY_COLORS = {
            Color.GREEN, Color.RED, Color.BLUE,
            Color.CYAN, Color.GREEN
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.whenstatisticsisselected, container, false);
        mChart = (PieChart)rootView.findViewById(R.id.chart1);

        mChart.setUsePercentValues(true);
        mChart.setDescription("");

        text1 = (TextView)rootView.findViewById(R.id.text1);

        Toast.makeText(getContext(), randomClass2,Toast.LENGTH_LONG).show();



        mChart.setRotationEnabled(true);

        mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {

            @Override
            public void onValueSelected(Entry e, int dataSetIndex, Highlight h) {
                // display msg when value selected
                if (e == null)
                    return;

                Toast.makeText(getContext(),
                        xValues[e.getXIndex()] + " is " + e.getVal() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected() {

            }
        });

        // setting sample Data for Pie Chart
        setDataForPieChart();


/*
        Cursor sky = db1.getRandomInfo();
        if(sky.getCount() == 0){

        }
        else{
            while (sky.moveToFirst()){
                randonName = sky.getString(1);  randomId = sky.getString(2);  randomClass = sky.getString(3);


            }
        }*/


/*
        Cursor sky1 = db1.getRandomInfo();
        if(sky1.moveToFirst()){
            randomName2 = sky1.getString(1);  randomId2 = sky1.getString(2);  randomClass2 = sky1.getString(3);

        }
*/





/*
        Cursor skyhe = db1.getListContents();
        if(skyhe.getCount() == 0){

        }
        else{
            while (skyhe.moveToNext()){
                randomName2 = sky1.getString(1);  randomId2 = sky1.getString(2);  randomClass2 = sky1.getString(3);
                text1.setText(randonName);
                text2.setText(randomName2);
                text3.setText(randomClass2);
            }

        }*/




        return rootView;



    }

    public void setDataForPieChart() {
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < yValues.length; i++)
            yVals1.add(new Entry(yValues[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < xValues.length; i++)
            xVals.add(xValues[i]);

        // create pieDataSet
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(3);
        dataSet.setSelectionShift(5);

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);

        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);
        //   data.setValueFormatter(new DefaultValueFormatter());
        //   data.setValueFormatter(new PercentFormatter());

        data.setValueFormatter(new MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

        mChart.setData(data);

        // undo all highlights
        mChart.highlightValues(null);

        // refresh/update pie chart
        mChart.invalidate();

        // animate piechart
        mChart.animateXY(1400, 1400);


        // Legends to show on bottom of the graph
        Legend l = mChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);
    }
    public class MyValueFormatter implements ValueFormatter {

        private DecimalFormat mFormat;

        public MyValueFormatter() {
            mFormat = new DecimalFormat("###,###,##0"); // use one decimal if needed
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // write your logic here
            return mFormat.format(value) + ""; // e.g. append a dollar-sign
        }
    }

}