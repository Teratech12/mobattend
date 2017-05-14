package com.example.sky_phase.mobattend;

import com.github.mikephil.charting.data.BarDataSet;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class DataModelForStats {String name;
    String type;
    String string;
    String version_number;
    String feature;
    String date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
    String editText;
    String lastseen;
            String hpp;
    String hpa;
    float mychart;
    boolean entries;
            BarDataSet dataSet;
    ArrayList<String> labels;
   // boolean add;



    public DataModelForStats(String name , String type, String hpp, String hpa /*, boolean entries, BarDataSet dataSet, ArrayList<String> labels /*, String feature, String date*/){
        this.name = name;
        this.type = type;
        this.hpp = hpp;
        this.hpa = hpa;
        this.entries = entries;
        this.dataSet  = dataSet;
        this.labels= labels;
        this.mychart = mychart;
        this.version_number = version_number;
        this.feature = feature;
        this.date = date;
        this.editText = editText;

    }



    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public String getHpp(){return  hpp;}
    public String getLastseen(){return  lastseen;}
    public String getHpa(){return hpa;}
    public String getDate(){return date;}
    public String getEditText(){return editText;}
    public BarDataSet getEntry(){return  dataSet;}
    public BarDataSet getDataSet(){return dataSet;}
    public ArrayList<String> getLabels(){return  labels;}


    public String getVersion_number(){
        return  version_number;
    }
    public String getFeature(){
        return feature;
    }


}
