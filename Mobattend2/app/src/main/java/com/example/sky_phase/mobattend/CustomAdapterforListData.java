package com.example.sky_phase.mobattend;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapterforListData extends ArrayAdapter<DataModelForListForData> implements View.OnClickListener {
    private ArrayList<DataModelForListForData> dataSet;
    Context mContext;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        TextView Date;

        ImageView info, call,message;
        TextView mydate;
        EditText editText;

    }

    public CustomAdapterforListData(ArrayList<DataModelForListForData> data, Context context){
        super(context, R.layout.enter_student_info,data);
        this.dataSet = data;
        this.mContext = context;
    }




    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
        DataModelForListForData DataModelForListForData = (DataModelForListForData)object;

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Date saved "+ DataModelForListForData.getDate()+ " ", Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;
        }

    }

    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModelForListForData DataModelForListForData = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.enter_student_info, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
          //  viewHolder.mydate = (TextView) convertView.findViewById(R.id.type1) ;
           // viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
          //  viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
          //  viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
           // viewHolder.Date = (TextView)convertView.findViewById(R.id.type) ;
            // viewHolder.call = (ImageView)convertView.findViewById(R.id.makecall);




            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }
        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;
        viewHolder.txtName.setText(DataModelForListForData.getName());
        viewHolder.txtType.setText(DataModelForListForData.getType());
        viewHolder.mydate.setText(DataModelForListForData.getDate());


       // viewHolder.mydate.setText(DataModelForListForData.getMydate())
//        ;        viewHolder.info.setOnClickListener(this);
      //  viewHolder.info.setTag(position);
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
            for(DataModelForListForData postDetails: dataSet){
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


    }


