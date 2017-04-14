package com.example.sky_phase.mobattend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class DataModelForStudentSearch {String name;
    String type;
    String version_number;
    String feature;
    String date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
    String editText;


    public DataModelForStudentSearch(String name, String type /*String version_number, String feature, String date*/){
        this.name = name;
        this.type = type;
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
    public String getDate(){return date;}
    public String getEditText(){return editText;}



    public String getVersion_number(){
        return  version_number;
    }
    public String getFeature(){
        return feature;
    }

}
