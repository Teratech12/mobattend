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

public class CustomAdapterforStats extends ArrayAdapter<DataModelForStats> implements View.OnClickListener {
    private ArrayList<DataModelForStats> dataSet;
    Context mContext;
    ModifiedSecondTab you = new ModifiedSecondTab();
    DataModelForStats dataModel;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;




    }

    public CustomAdapterforStats(ArrayList<DataModelForStats> data, Context context){
        super(context, R.layout.row_item_for_stats,data);
        this.dataSet = data;
        this.mContext = context;


    }

    @Override
    public void onClick(View v) {
        int position = (Integer) v.getTag();
        Object object = getItem(position);
        dataModel = (DataModelForStats) object;
        String theclass = you.gblbalmert;
        String event_id = you.eventid;
        String attendance_id = you.attendanceid;
        MobattendDatabase db = new MobattendDatabase(getContext());
    }

        private int lastPosition = -1;
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModelForStats dataModel = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_for_stats, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);






            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());

        return convertView;
    }




    }


