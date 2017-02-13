package com.example.sky_phase.tab;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class DataModelforScreenTwo {String name;
    String type;
    String version_number;
    String feature;
    String date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
    String editText;
    String mydate;


    public DataModelforScreenTwo(String name, String type, String mydate /*String version_number, String feature, String date*/){
        this.name = name;
        this.type = type;
        this.mydate = mydate;
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
    public String getMydate(){return mydate;}



    public String getVersion_number(){
        return  version_number;
    }
    public String getFeature(){
        return feature;
    }

}
