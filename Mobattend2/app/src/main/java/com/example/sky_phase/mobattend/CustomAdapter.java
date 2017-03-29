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

/**
 * Created by SKY-PHASE on 1/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener {
    private ArrayList<DataModel> dataSet;
    Context mContext;
    ClasssFragment you = new ClasssFragment();

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

    public CustomAdapter(ArrayList<DataModel> data, Context context){
        super(context, R.layout.row_item,data);
        this.dataSet = data;
        this.mContext = context;
    }

    @Override
    public void onClick(View v) {
        int position=(Integer)v.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel)object;
        String theclass = you.gblbalmert;

        switch (v.getId()){
            case R.id.item_info:
                Snackbar.make(v, "Name : "+ dataModel.getName()+ "\nID : "+dataModel.getType()+ "                                 Class : "+theclass, Snackbar.LENGTH_INDEFINITE).setAction("No action", null).show();
                break;

            case R.id.present:
                Toast.makeText(getContext()," present",Toast.LENGTH_LONG).show();

               /* boolean checked = ((RadioButton) v).isChecked();

                switch(v.getId()) {
                    case R.id.present:
                        if (checked)
                            Toast.makeText(getContext()," present",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.permission:
                        if (checked)
                            Toast.makeText(getContext()," permission",Toast.LENGTH_LONG).show();*/
                        break;




        }

    }

    private int lastPosition = -1;


    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for this position
        DataModel dataModel = getItem(position);
        //check if an existing view is being reused
        viewHolder viewHolder;
        //view lookup cache
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
            viewHolder.mydate = (TextView) convertView.findViewById(R.id.type) ;
            viewHolder.info = (ImageView)convertView.findViewById(R.id.item_info);
            viewHolder.radioGroup = (RadioGroup)convertView.findViewById(R.id.radiogroup);
            viewHolder.present = (RadioButton) convertView.findViewById(R.id.present);
            viewHolder.permission = (RadioButton) convertView.findViewById(R.id.permission);
            viewHolder.absent = (RadioButton) convertView.findViewById(R.id.absent);

          //  viewHolder.txtVersion = (TextView) convertView.findViewById(R.id.version_number);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
            // viewHolder.call = (ImageView)convertView.findViewById(R.id.makecall);
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
            });




            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();

                switch (v.getId()) {
                    case R.id.present:
                        if (checked)
                            Toast.makeText(getContext(), " present", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.permission:
                        if (checked)
                            Toast.makeText(getContext(), " permission", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
       // Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
      //  result.startAnimation(animation);
        lastPosition = position;
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
//        viewHolder.txtVersion.setText(dataModel.getVersion_number());
//        viewHolder.mydate.setText(dataModel.getFeature())
        ;        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
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
            for(DataModel postDetails: dataSet){
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


