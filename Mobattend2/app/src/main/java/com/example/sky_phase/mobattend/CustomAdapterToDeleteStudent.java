package com.example.sky_phase.mobattend;

import android.content.Context;
import android.graphics.Color;
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

import com.amulyakhare.textdrawable.TextDrawable;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapterToDeleteStudent extends ArrayAdapter<DataModelForDeleteList> implements View.OnClickListener {
    private ArrayList<DataModelForDeleteList> dataSet;
    Context mContext;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        TextView Date;

        ImageView info, call,message;
        TextView mydate;
        EditText editText;
      //  ImageView displaycount;
        static  String keep;

    }

    public CustomAdapterToDeleteStudent(ArrayList<DataModelForDeleteList> data, Context context){
        super(context, R.layout.row_itemfordeletelist,data);
        this.dataSet = data;
        this.mContext = context;

    }


    @Override
    public int getViewTypeCount() {


        return 2;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getPosition(DataModelForDeleteList item) {
        return super.getPosition(item);
    }

    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
        DataModelForDeleteList DataModelForDeleteList = (DataModelForDeleteList)object;

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Date saved "+ DataModelForDeleteList.getDate()+ " ", Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;
        }

    }

    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {

        String keep;
        //get data item for this position
        DataModelForDeleteList DataModelForDeleteList = getItem(position);
        String GETID = DataModelForDeleteList.getType();
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_itemfordeletelist, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.mydate = (TextView) convertView.findViewById(R.id.type1) ;
           // viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            //viewHolder.displaycount = (ImageView) convertView.findViewById(R.id.displaycount);
            viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
            viewHolder.Date = (TextView)convertView.findViewById(R.id.type) ;
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
        viewHolder.txtName.setText(DataModelForDeleteList.getName());
        //viewHolder.txtName.setText((CharSequence) getItem(position));
        // viewHolder.txtName.setText( getItem(position).toString());
       // String firstLetter = String.valueOf(String.valueOf(getItem(position)).charAt(0));
        String firstLetter = String.valueOf(viewHolder.txtName.getText().toString().charAt(0));
        viewHolder.txtType.setText(DataModelForDeleteList.getType());
       // viewHolder.mydate.setText(DataModelForDeleteList.getDate());
        Random rand = new Random();
        int r = rand.nextInt(255);
        int g = rand.nextInt(255);
        int b = rand.nextInt(255);
        int mycolor = Color.RED;
        int randomColor = Color.rgb(r,b,g);
        TextDrawable drawable = TextDrawable.builder()
                .buildRoundRect("X", mycolor, 20);

        viewHolder.info.setImageDrawable(drawable);















        viewHolder.mydate.setText(DataModelForDeleteList.getMydate());

        keep = viewHolder.mydate.getText().toString();

        ;        viewHolder.info.setOnClickListener(this);

        viewHolder.info.setTag(position);
        //viewHolder.displaycount.setTag(position);
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
            for(DataModelForDeleteList postDetails: dataSet){
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


