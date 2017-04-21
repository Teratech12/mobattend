package com.example.sky_phase.mobattend;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class DataModel {String name;
    String type;
    String version_number;
    String feature;
    String date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
    String editText;
    private boolean checked;
    String status;
    String yes = "Present";
    String naa = "Absent";
    int mychart;
   //private boolean isnotChecked = false;



    public DataModel( String name, String type/* String mystatus String feature, String date*/){
        this.name = name;
        this.type = type;
       // this.status = mystatus;

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
    public  String getPresent(){return yes;}
    public  String getAbsent(){return naa;}
    public  String getStatus(){return  status;}
   public void  setChecked(boolean checked){this.checked=checked;}

  //  private boolean isIsnotChecked(){return isnotChecked;}


    public String getVersion_number(){
        return  version_number;
    }
    public String getFeature(){
        return feature;
    }
    public int getMychart(){return mychart;}

}
