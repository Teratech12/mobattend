package com.example.sky_phase.mobattend;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import static com.example.sky_phase.mobattend.R.id.radiogroup;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapterForDateSearch extends ArrayAdapter<DataModelForDateSearch> implements View.OnClickListener {
    private ArrayList<DataModelForDateSearch> dataSet;
    Context mContext;
    ClasssFragment you = new ClasssFragment();
    DataModel dataModel;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        RadioGroup radioGroup;
        RadioButton present;
        RadioButton permission;
        RadioButton absent;


        ImageView info, call,message;
        TextView mydate;
        EditText editText;


    }

    public CustomAdapterForDateSearch(ArrayList<DataModelForDateSearch> data, Context context){
        super(context, R.layout.row_item_for_date_search,data);
        this.dataSet = data;
        this.mContext = context;


    }

    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
         dataModel = (DataModel)object;
        String theclass = you.gblbalmert;
        String event_id = you.eventid;
        String attendance_id = you.attendanceid;
        MobattendDatabase db = new MobattendDatabase(getContext());
        String st_attendance_id = generate_st_attendance_id();

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Name : "+ dataModel.getName()+ "\nID : "+dataModel.getType()+ "                                 Class : "+theclass, Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;

            case R.id.present:
                 String student_id = dataModel.getType();
                db.getWritableDatabase();
                boolean isInseerted = db.insertStudentEvent(st_attendance_id,student_id,attendance_id,event_id );
                if(isInseerted== true){
                    Toast.makeText(getContext(), "inserted", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getContext(), "not inserted", Toast.LENGTH_LONG).show();
                }

                       break;



            case R.id.permission:
                Toast.makeText(getContext(),dataModel.getType()+" permission",Toast.LENGTH_LONG).show();
                break;

            case R.id.absent:
                String student_id1 = dataModel.getType();
                Integer delete = db.DeleteFromStudentEventTable(student_id1,attendance_id,event_id);
                if(delete > 0){
                    Toast.makeText(getContext(),"deleted",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(getContext(),"not deleted",Toast.LENGTH_LONG).show();


               // Toast.makeText(getContext(),dataModel.getType()+" absent",Toast.LENGTH_LONG).show();
                break;




        }

        switch (v.getId()){
            case R.id.radiogroup:








        }

    }



    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModelForDateSearch dataModel = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_for_date_search, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.mydate = (TextView) convertView.findViewById(R.id.type1) ;
            viewHolder.info = (ImageView)convertView.findViewById(R.id.item_info);
            viewHolder.radioGroup = (RadioGroup)convertView.findViewById(radiogroup);
            viewHolder.present = (RadioButton) convertView.findViewById(R.id.present);
            viewHolder.permission = (RadioButton) convertView.findViewById(R.id.permission);
            viewHolder.absent = (RadioButton) convertView.findViewById(R.id.absent);

          //  viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
            // viewHolder.call = (ImageView)convertView.findViewById(R.id.makecall);
            /*
            viewHolder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Integer pos = (Integer)group.getTag();
                    switch (checkedId){

                        case  R.id.present:
                            Toast.makeText(getContext(),"present",Toast.LENGTH_LONG).show();

                            break;
                        case R.id.permission:
                            Toast.makeText(getContext(),"permision",Toast.LENGTH_LONG).show();
                            break;

                        case R.id.absent:
                            Toast.makeText(getContext(),"absent",Toast.LENGTH_LONG).show();
                            break;
                        default:




                    }
                }
            });*/




            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }


       // Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
      //  result.startAnimation(animation);
        lastPosition = position;
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
//        viewHolder.txtVersion.setText(dataModel.getVersion_number());
//        viewHolder.mydate.setText(dataModel.getFeature())
        ;        viewHolder.info.setOnClickListener(this);

        viewHolder.info.setTag(position);
//        viewHolder.absent.setTag(position);
       // viewHolder.absent.setOnClickListener(this);
       // viewHolder.permission.setTag(position);
      //  viewHolder.permission.setOnClickListener(this);
      //  viewHolder.present.setTag(position);
      //  viewHolder.present.setOnClickListener(this);
       // String firstLetter = String.valueOf(String.valueOf(getItem(position)).charAt(0));
        String firstLetter = String.valueOf(viewHolder.txtName.getText().toString().charAt(0));
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        int randomColor = Color.rgb(r,b,g);
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(firstLetter, randomColor);

        viewHolder.info.setImageDrawable(drawable);



        //Return the comple view render on screen
        return convertView;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if(charText.length()==0){
            dataSet.addAll(dataSet);
        }
        else{
            for(DataModelForDateSearch postDetails: dataSet){
                if(charText.length()!=0&& postDetails.getName().toLowerCase(Locale.getDefault()).contains(charText)){
                    dataSet.add(postDetails);

                }
                else if (charText.length()!= 0 && postDetails.getType().toLowerCase(Locale.getDefault()).contains(charText)){
                    dataSet.add(postDetails);
                }
            }
        }

        notifyDataSetChanged();

    }

    public String generate_st_attendance_id (){
        int alphaL=2, numL = 2;
        Random rand = new Random();
        String alphab = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numb = "123456789";
        StringBuilder result = new StringBuilder();
        for (int i=0; i<alphaL; i++){
            result.append(alphab.charAt(rand.nextInt(alphab.length())));
        }
        for (int i=0; i<numL; i++){
            result.append(numb.charAt(rand.nextInt(numb.length())));
        }

        return result.toString();
    }


    }


