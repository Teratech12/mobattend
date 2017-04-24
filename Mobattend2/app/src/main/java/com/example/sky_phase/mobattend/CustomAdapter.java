package com.example.sky_phase.mobattend;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
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

public class CustomAdapter extends ArrayAdapter<DataModel>  {
    private ArrayList<DataModel> dataSet;
    Context mContext;
    ClasssFragment you = new ClasssFragment();
    DataModel dataModel;
    boolean checkAll_flag = false;
    boolean checkItem_flag = false;

    public static class viewHolder{
        TextView txtName;
        TextView txtType;
        TextView txtVersion;
        RadioGroup radioGroup;
        TextView status;
       RadioButton present;
        RadioButton permission;
        RadioButton absent;
       // ImageView present;
        //ImageView absent;
        ListView list;

        RadioButton checked;


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
    public int getCount() {
        return super.getCount();
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }


    @Override
    public int getPosition(DataModel item) {
        return super.getPosition(item);
    }


    private int lastPosition = -1;


    public View getView(final int position, View convertView, ViewGroup parent) {

        final MobattendDatabase db = new MobattendDatabase(getContext());
        String theclass = you.gblbalmert;
        final String event_id = you.eventid;
        final String attendance_id = you.attendanceid;
        //get data item for this position
        final DataModel dataModel = getItem(position);
         final viewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item, parent, false);
         //   viewHolder = getView(position,convertView,parent);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.type);
         View myview =   viewHolder.status = (TextView) convertView.findViewById(R.id.myststusfinal) ;

           // viewHolder.status.setText(dataSet.get(position).getStatus());
            viewHolder.mydate = (TextView) convertView.findViewById(R.id.type1) ;
            viewHolder.info = (ImageView)convertView.findViewById(R.id.item_info);
            viewHolder.radioGroup = (RadioGroup)convertView.findViewById(radiogroup);
            viewHolder.list =(ListView) convertView.findViewById(R.id.listmylist);
            viewHolder.present = (RadioButton) convertView.findViewById(R.id.present);
            viewHolder.permission = (RadioButton) convertView.findViewById(R.id.permission);
            viewHolder.absent = (RadioButton) convertView.findViewById(R.id.absent);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);
            viewHolder.editText = (EditText)convertView.findViewById(R.id.editText);
            final CustomAdapter.viewHolder finalViewHolder = viewHolder;


            final CustomAdapter.viewHolder finalViewHolder1 = viewHolder;

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

            convertView.setTag(viewHolder);



        } else {
           viewHolder = (viewHolder) convertView.getTag();


        }

        viewHolder.present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // finalViewHolder.status.setText("Present");
                // viewHolder.status.setText(dataSet.get(position).getPresent());
                viewHolder.status.setText(dataModel.getPresent());



                String st_attendance_id = generate_st_attendance_id();

                String student_id = dataModel.getType();
                db.getWritableDatabase();
                boolean isInseerted = db.insertStudentEvent(st_attendance_id,student_id,attendance_id,event_id );
                if(isInseerted== true){
                    Toast.makeText(getContext(), "inserted", Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(getContext(), "not inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        viewHolder.absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  finalViewHolder1.status.setText("Absent");
                //  viewHolder.status.setText(dataSet.get(position).getAbsent());
                viewHolder.status.setText(dataModel.getAbsent());



                String student_id1 = dataModel.getType();
                Integer delete = db.DeleteFromStudentEventTable(student_id1,attendance_id,event_id);

                if(delete > 0){
                    Toast.makeText(getContext(),"deleted",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(getContext(),"not deleted",Toast.LENGTH_LONG).show();
            }
        });

        viewHolder.permission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewHolder.status.setText("Permission");
            }
        });



       // Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
      //  result.startAnimation(animation);
        lastPosition = position;
        viewHolder.txtName.setText(dataModel.getName());
        viewHolder.txtType.setText(dataModel.getType());
       // viewHolder.status.setText(dataModel.getStatus());
       //viewHolder.status.setText(dataModel.getStatus());
        viewHolder.present.setTag(position);
        viewHolder.absent.setTag(position);
        viewHolder.status.setTag(position);

       //viewHolder.permission.setChecked(dataSet.get(position).isChecked());
       // viewHolder.present.setChecked(dataSet.get(position).isChecked());
        //viewHolder.absent.setChecked(dataSet.get(position).isChecked());
       /* if(viewHolder.absent.isChecked()== true){
            viewHolder.absent.setChecked(dataSet.get(position).isChecked());
        }else {
            viewHolder.absent.setChecked(false);
        }


        if (viewHolder.present.isChecked()==true){
            viewHolder.present.setChecked(dataSet.get(position).isChecked());
        }{
            viewHolder.present.setChecked(false);
        }

        if (viewHolder.permission.isChecked()){
            viewHolder.permission.setChecked(dataSet.get(position).isChecked());
        }{
            viewHolder.permission.setChecked(false);
        }*/




      //  viewHolder.info.setOnClickListener(this);

        viewHolder.info.setTag(position);

        viewHolder.absent.setTag(position);
      //  viewHolder.status.setOnClickListener(this);




       // viewHolder.absent.setOnClickListener(this);
     //   viewHolder.permission.setTag(position);
     //   viewHolder.permission.setOnClickListener(this);
        viewHolder.present.setTag(position);
       // viewHolder.present.setOnClickListener(this);
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



/*
    @Override
    public void onClick(View v) {
        TextView me = (TextView)v.findViewById(R.id.myststusfinal);
        viewHolder viewHolder = null;



     int position=(Integer)v.getTag();

        Object object = getItem(position);

        dataModel = (DataModel)object;

        String theclass = you.gblbalmert;
        String event_id = you.eventid;
        String attendance_id = you.attendanceid;
        MobattendDatabase db = new MobattendDatabase(getContext());

        String st_attendance_id = generate_st_attendance_id();

        switch (v.getId()){

            case R.id.myststusfinal:
                Toast.makeText(mContext, "PRESS ME", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_info:
                Snackbar.make(v, "Name : "+ dataModel.getName()+ "\nID : "+dataModel.getType()+ "                                 Class : "+theclass, Snackbar.LENGTH_LONG).setAction("No action", null).show();
                break;

            case R.id.present:
                try {


                }catch (Exception e){

                }


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
                try {  viewHolder.status.setText("Absent");

                }catch (Exception e){

                }



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


    }*/







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


