package com.example.sky_phase.mobattend;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapterforStats extends ArrayAdapter<DataModelForStats> implements View.OnClickListener {
    private ArrayList<DataModelForStats> dataSet;
    Context mContext;
    ModifiedSecondTab you = new ModifiedSecondTab();
    DataModelForStats dataModel;
    MobattendDatabase db = new MobattendDatabase(getContext());

    float numb;



    public static class viewHolder{
       int[] numbers;// = {7,1,2,1,15,9,9,47,23,4,0,10,14,15,19,10,25,14,19,20};
        int z = 25;
        int x;









        public  int[] yValues;





        TextView txtName;
        TextView txtType;
        HorizontalBarChart mychart;
        TextView hpa;
        TextView hpp;
        ImageView displaycount;
        TextView lastseen;

        private  String[] xValues = {"present","absent"};
        public static final int[] MY_COLORS = {
                Color.GREEN, Color.RED, Color.BLUE,
                Color.CYAN, Color.GREEN
        };





    }

    public CustomAdapterforStats(ArrayList<DataModelForStats> data, Context context){
        super(context, R.layout.row_item_for_stats,data);
        this.dataSet = data;
        this.mContext = context;


    }
    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }




    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        dataModel = (DataModelForStats) object;
        String theclass = you.gblbalmert;
        String event_id = you.eventid;
        String attendance_id = you.attendanceid;
    //    MobattendDatabase db = new MobattendDatabase(getContext());

    }

        private int lastPosition = -1;
    public View getView(int position, View convertView, ViewGroup parent) {
        String keep;
        System.out.println("getView " + position + " " + convertView);
        //get data item for this position
        DataModelForStats dataModel = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_for_stats, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.hpp =(TextView)convertView.findViewById(R.id.holdpercentageP);
            viewHolder.hpa =(TextView)convertView.findViewById(R.id.holdpercentageA);
            viewHolder.displaycount = (ImageView) convertView.findViewById(R.id.displaycount);
            viewHolder.lastseen = (TextView) convertView.findViewById(R.id.lastSeenhold);


            String CLID = you.gblbalmert1;
            Cursor cursor = db.getAllStudentsofClass(CLID);
            float getmycount = 0;











            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }

          //viewHolder.yValues = new int[]{10, 25};


        viewHolder.txtName.setText(dataModel.getName());
       viewHolder.txtType.setText(dataModel.getType());
        viewHolder.hpp.setText(dataModel.getHpp());
        viewHolder.hpa.setText(dataModel.getHpa());
        viewHolder.lastseen.setText(dataModel.getLastseen());
       // BarData data = new BarData(dataModel.getLabels(),dataModel.getDataSet());
        //viewHolder.mychart.setData(data);



      /*  BarData data = new BarData(getXAxisValues(),getDataSet());
        viewHolder.mychart.setData(data);
        viewHolder.mychart.animateXY(200,200);
        viewHolder.mychart.invalidate();
        viewHolder.mychart.getXAxis().setDrawGridLines(false);
        viewHolder.mychart.getAxisLeft().setDrawGridLines(false);*/

        //viewHolder.mychart.setUsePercentValues(true);



     //   viewHolder.mychart.setRotationEnabled(true);
     /*   ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        for (int i = 0; i < viewHolder.yValues.length; i++)
            yVals1.add(new Entry(viewHolder.yValues[i], i));

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i < viewHolder.xValues.length; i++)
            xVals.add(viewHolder.xValues[i]);

        // create pieDataSet
        PieDataSet dataSet = new PieDataSet(yVals1, "");
        dataSet.setSliceSpace(2);
        dataSet.setSelectionShift(5);

        // adding colors
        ArrayList<Integer> colors = new ArrayList<Integer>();

        // Added My Own colors
        for (int c : viewHolder.MY_COLORS)
            colors.add(c);


        dataSet.setColors(colors);

        //  create pie data object and set xValues and yValues and set it to the pieChart
        PieData data = new PieData(xVals, dataSet);
        //  data.setValueFormatter(new DefaultValueFormatter());
        // data.setValueFormatter(new PercentFormatter());

        data.setValueFormatter(new CustomAdapterforStats.MyValueFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);

       // viewHolder.mychart.setData(data);

        // undo all highlights
        viewHolder.mychart.highlightValues(null);

        // refresh/update pie chart
        viewHolder.mychart.invalidate();

        // animate piechart
        viewHolder.mychart.animateXY(1400, 1400);


        // Legends to show on bottom of the graph
        Legend l = viewHolder.mychart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(7);
        l.setYEntrySpace(5);*/




      //  viewHolder.mychart.setTag(getPosition(dataModel.mychart));


     keep = viewHolder.txtType.getText().toString();
        int getcolor = Color.DKGRAY;
        TextDrawable mydrawable = TextDrawable.builder().buildRound(keep,getcolor);
        viewHolder.displaycount.setImageDrawable(mydrawable);
        viewHolder.displaycount.setTag(position);
        return convertView;
    }

    private Object getPosition(HorizontalBarChart mychart) {

        return mychart;
    }


    private BarDataSet getDataSet(){
        viewHolder viewHolder = new viewHolder();


             ArrayList<BarEntry> entries = new ArrayList<>();






;


              BarDataSet dataset = new BarDataSet(entries, "hi");
              return dataset;
          }

      private  ArrayList<String> getXAxisValues(){
          ArrayList<String> labels = new ArrayList<>();
          labels.add("ME");

          return labels;
      }
    public  void AddValuesToBARENTRY(){



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


