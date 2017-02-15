package com.example.sky_phase.tab;

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

public class CustomAdapterforGrid extends ArrayAdapter<DataModelForGrid> implements View.OnClickListener {
    private ArrayList<DataModelForGrid> dataSet;
    Context mContext;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;

        ImageView info, imageView,message;
        TextView mydate;
        EditText editText;

    }

    public CustomAdapterforGrid(ArrayList<DataModelForGrid> data, Context context){
        super(context, R.layout.row_itemforgrid,data);
        this.dataSet = data;
        this.mContext = context;
    }




    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
        DataModelForGrid DataModelForGrid = (DataModelForGrid)object;

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Date saved "+ DataModelForGrid.getDate()+ " ", Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;
        }

    }

    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModelForGrid DataModelForGrid = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_itemforgrid, parent, false);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
           // viewHolder.mydate = (TextView) convertView.findViewById(R.id.date) ;
          //  viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
           // viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
           // viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
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
//        viewHolder.txtName.setText(DataModelForGrid.getName());
       // viewHolder.txtType.setText(DataModelForGrid.getType());
       // viewHolder.txtVersion.setText(DataModelForGrid.getVersion_number());
       // viewHolder.imageView.(DataModelForGrid.getImage());
       // viewHolder.mydate.setText(DataModelForGrid.getFeature())
       // ;        viewHolder.info.setOnClickListener(this);
       // viewHolder.info.setTag(position);
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
            for(DataModelForGrid postDetails: dataSet){
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


