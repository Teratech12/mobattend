package com.example.sky_phase.mobattend;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;


public class HorizontalBarChatPage extends AppCompatActivity {
    HorizontalBarChart mychat;
    ModifiedSecondTab you = new ModifiedSecondTab();
    MobattendDatabase mydb = new MobattendDatabase(this);
    String ClassId;
   static ArrayList<Float> getnumbers = new ArrayList<>();
    List<BarEntry> myentries = new List<BarEntry>() {
        @Override
        public void add(int location, BarEntry object) {

        }

        @Override
        public boolean add(BarEntry object) {
            return false;
        }

        @Override
        public boolean addAll(int location, Collection<? extends BarEntry> collection) {
            return false;
        }

        @Override
        public boolean addAll(Collection<? extends BarEntry> collection) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public boolean contains(Object object) {
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> collection) {
            return false;
        }

        @Override
        public BarEntry get(int location) {
            return null;
        }

        @Override
        public int indexOf(Object object) {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @NonNull
        @Override
        public Iterator<BarEntry> iterator() {
            return null;
        }

        @Override
        public int lastIndexOf(Object object) {
            return 0;
        }

        @Override
        public ListIterator<BarEntry> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<BarEntry> listIterator(int location) {
            return null;
        }

        @Override
        public BarEntry remove(int location) {
            return null;
        }

        @Override
        public boolean remove(Object object) {
            return false;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            return false;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            return false;
        }

        @Override
        public BarEntry set(int location, BarEntry object) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }

        @NonNull
        @Override
        public List<BarEntry> subList(int start, int end) {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(T[] array) {
            return null;
        }
    };

  static   List<String> labels1 = new ArrayList<>(50);
    ArrayList<Float> getme = new ArrayList<>();
    BarData data = new BarData();
    ArrayList<BarEntry> data1new = new ArrayList<>();
    ArrayList<String> data2new = new ArrayList<String>();
   static ArrayList<String> values2 = new ArrayList<>();


    private BarDataSet getDataSet( List<BarEntry> entries){
        entries = new ArrayList<>();
        // Random rand = new Random();
        // float r = rand.nextFloat();


        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        if (cursor.moveToFirst()){
            do {
                float count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
                getme.add(count1);
            }while (cursor.moveToNext());
        }



       int i = 0;
        for (int y = 0; y < 36; y++){
            Random rand = new Random();
            int r = rand.nextInt();

            entries.add(new BarEntry(r,i++));

        }
        i = 0;
     /*   entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(10f, 2));
        entries.add(new BarEntry(2f, 3));
        entries.add(new BarEntry(6f, 4));
        entries.add(new BarEntry(4f, 5));
        entries.add(new BarEntry(9f, 6));
        entries.add(new BarEntry(9f, 7));
        entries.add(new BarEntry(12f, 8));
        entries.add(new BarEntry(20f, 9));
        entries.add(new BarEntry(7f, 10));
        entries.add(new BarEntry(2f, 11));
        entries.add(new BarEntry(4f, 12));
        entries.add(new BarEntry(8f, 13));
        entries.add(new BarEntry(10f, 14));
        entries.add(new BarEntry(2f, 15));
        entries.add(new BarEntry(6f, 16));
        entries.add(new BarEntry(4f, 17));
        entries.add(new BarEntry(9f, 18));
        entries.add(new BarEntry(9f, 19));
        entries.add(new BarEntry(12f, 20));
        entries.add(new BarEntry(20f, 21));
        entries.add(new BarEntry(7f, 22));
        entries.add(new BarEntry(2f, 23));
        entries.add(new BarEntry(4f, 24));
        entries.add(new BarEntry(8f, 25));
        entries.add(new BarEntry(10f, 26));
        entries.add(new BarEntry(2f, 27));
        entries.add(new BarEntry(6f, 28));
        entries.add(new BarEntry(4f, 29));
        entries.add(new BarEntry(9f, 30));
        entries.add(new BarEntry(9f, 31));
        entries.add(new BarEntry(12f, 32));
        entries.add(new BarEntry(20f, 33));
        entries.add(new BarEntry(7f, 34));
        entries.add(new BarEntry(2f, 35));*/

        BarDataSet dataset = new BarDataSet(entries, "hi");
        return dataset;

    }


public ArrayList<String> getmynumber(ArrayList<String> data2){
    data2 = new ArrayList<String>();
    Cursor cursor = mydb.getAllStudentsofClass(ClassId);
    String fieldtoadd = null;
    while (cursor.moveToNext()){
        fieldtoadd = cursor.getString(1);
        data2.add(fieldtoadd);
    }
    cursor.close();


    Log.e("tag", "getmynumber is "+String.valueOf(data2.size()));
    return data2;






}

  /*  public ArrayList<String> Entrynumbers(){
        ArrayList<BarEntry> data = new ArrayList<>();
        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        String fieldtoadd = null;
        while (cursor.moveToNext()){
            int i =0;
            float count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
            fieldtoadd = String.valueOf(count1);
            data.add(new BarEntry(count1,i++));
        }
        cursor.close();


        Log.e("tag", String.valueOf(data.size()));
        return data;






    }*/

    private BarDataSet getDataSet1(ArrayList<String> values){
        values = new ArrayList<>();
      List<BarEntry>  data1 = new ArrayList<>();
        float count1;
        float getattendancecount;
        float myfinal = 0;
        Cursor cursor = mydb.getAllStudentsofClass(ClassId);
        // values = new String[cursor.getCount()];
        int i = 0;
        while (cursor.moveToNext()){
            String uname = String.valueOf(mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0)));

                for (int me = 0; me <cursor.getCount();me++){
                    values.add(me,uname);
                }
                values.add(uname);


//            Log.e("SKYPHASE", "out out "+values.get(i));


             count1 = mydb.getNumbOfTimesOfStd(ClassId, cursor.getString(0));
           // String string = cursor.getString(0);
           // Log.e("tag","cursor is "+string);
           // fieldtoadd = String.valueOf(count1);
             getattendancecount = mydb.getAttendanceCount(ClassId);
          //  myfinal = count1/getattendancecount;



              


            Log.e("tag", "count is "+String.valueOf(count1));
            for (int c = 0; c <cursor.getCount(); c++ ){
               // data1.add(new BarEntry(c++, (int) myfinal));
            }

            Log.e("SKYPHASE","count is "+ count1);
            Log.e("SKYPHASE","attendance count is "+ getattendancecount);
            Log.e("SKYPHASE","myfinal is "+ myfinal);
            i++;
        }


        Log.e("SKYPHASE", "value size is "+values.size());
        Log.e("SKYPHASE", "value size is "+values.get(5));

           for (int k = 0; k < values.size(); ++k){
             //  data1.add(new BarEntry(Float.parseFloat(values.get(k)),k));

           }

        BarDataSet dataset = new BarDataSet(data1, "hi");
        return dataset;
    }
    public class MyValueFormatterb implements ValueFormatter{

        @Override
        public String getFormattedValue(float v, Entry entry, int i, ViewPortHandler viewPortHandler) {
            return Math.round(v)+"";
        }
    }




    private List<String> getXAxisValues(List<String> labels) {
         labels = new ArrayList<>();

        String names;


        List<String> array1 = new ArrayList<>();
        String[] one = {"me","me","me","me","me","me","me","me","me","me","me","me","me","you","me","me","me","him","me","me","yes","me","me","me","me","me","me","me","me","me","me","me","me","me","me","ama"};


        for (int c = 0; c < 36; c++){
            labels.add(one[c]);
        }
       /* labels.add("me");
        labels.add("you");
        labels.add("ME");
        labels.add("ME");*/


        return labels;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_bar_chat);
        mychat = (HorizontalBarChart) findViewById(R.id.mychart);
    //  BarData data = new BarData(getXAxisValues(),getDataSet());
        data = new BarData(getXAxisValues(labels1),getDataSet(myentries));
        data.setValueFormatter(new MyValueFormatterb());
       mychat.setData(data);
        mychat.animateXY(2000,200);
        mychat.invalidate();

        mychat.getXAxis().setDrawGridLines(false);
        mychat.getAxisLeft().setDrawGridLines(false);
        YAxis yAxis = mychat.getAxisLeft();
        yAxis.setDrawGridLines(false);
        yAxis =mychat.getAxisRight();
        yAxis.setDrawGridLines(false);
        mychat.getAxisLeft().setStartAtZero(true);
        mychat.getAxisRight().setStartAtZero(true);
         ClassId = you.gblbalmert1;





         getmynumber(data2new);
        getDataSet1(values2);


    }





}