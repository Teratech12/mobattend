package com.example.sky_phase.mobattend;

import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class DataModelRetrieval {String student_name;
    String student_id;
    String version_number;
    ImageView changingImage;
    String feature;
    String date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
    String editText;
    private static CustomAdapterRetrieval adapter;;


    public DataModelRetrieval(String student_name, String student_id /*ImageView changingImage*/){
        this.student_name = student_name;
        this.student_id = student_id;
        String my = student_name.toString();
        //this.changingImage = changingImage;
        this.version_number = version_number;
        this.feature = feature;
        this.date = date;
        this.editText = editText;

    }
    public String getstudent_name(){
        return student_name;
    }
    public String getstudent_id(){
        return student_id;
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
