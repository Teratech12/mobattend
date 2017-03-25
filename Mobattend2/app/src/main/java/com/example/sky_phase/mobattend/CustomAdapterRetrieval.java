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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapterRetrieval extends ArrayAdapter<DataModelRetrieval> implements View.OnClickListener {
    private ArrayList<DataModelRetrieval> dataSet;
    Context mContext;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;

        ImageView info, call,message;
        TextView mydate;
        EditText editText;

    }

    public CustomAdapterRetrieval(ArrayList<DataModelRetrieval> data, Context context){
        super(context, R.layout.row_item_retrieval,data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
        DataModelRetrieval DataModelRetrieval = (DataModelRetrieval)object;

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Date saved "+ DataModelRetrieval.getDate()+ " ", Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;
        }

    }

    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModelRetrieval DataModelRetrieval = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;
        TextView txt;



        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_retrieval, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.student_name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.student_id);
                String me = viewHolder.txtType.getText().toString();
            viewHolder.mydate = (TextView) convertView.findViewById(R.id.type) ;
            viewHolder.info = (ImageView) convertView.findViewById(R.id.changingImage);
          //  viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);

           // viewHolder.info = (ImageView) convertView.findViewById(R.id.changingImage);
            viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
            // viewHolder.call = (ImageView)convertView.findViewById(R.id.makecall);




            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }
       // Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
      //  result.startAnimation(animation);
        lastPosition = position;
        viewHolder.txtName.setText(DataModelRetrieval.getstudent_name());
        viewHolder.txtType.setText(DataModelRetrieval.getstudent_id());
        String me = DataModelRetrieval.getstudent_id().toString();
      viewHolder.txtType.setText(DataModelRetrieval.getstudent_id());
        if(me=="1"){
            viewHolder.info.setImageResource(R.drawable.ic_menu_send);
            viewHolder.txtName.setTextColor(Color.BLUE);

        }
        else{
            viewHolder.info.setImageResource(R.drawable.ic_menu_share);
            viewHolder.txtName.setTextColor(Color.RED);
        }
//        viewHolder.txtVersion.setText(DataModelRetrieval.getVersion_number());
//        viewHolder.mydate.setText(DataModelRetrieval.getFeature())
        ;        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
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
            for(DataModelRetrieval postDetails: dataSet){
                if(charText.length()!=0&& postDetails.getstudent_name().toLowerCase(Locale.getDefault()).contains(charText)){
                    dataSet.add(postDetails);

                }
                else if (charText.length()!= 0 && postDetails.getstudent_id().toLowerCase(Locale.getDefault()).contains(charText)){
                    dataSet.add(postDetails);
                }
            }
        }

        notifyDataSetChanged();

    }


    }


