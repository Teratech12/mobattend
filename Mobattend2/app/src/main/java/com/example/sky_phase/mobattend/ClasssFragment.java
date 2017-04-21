package com.example.sky_phase.mobattend;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class ClasssFragment extends Fragment {
    ArrayList<DataModelforScreenTwo> dataModels;
    ListView listView;
    String date;
    private static CustomAdapterforScreenTwo adapter;
       static String mert = new String();

       Activity myactivity = this.getActivity();
    String usesomewhere;
    TextView me;

     static  String gblbalmert;



   // private static CustomAdapterRetrieval adapter;

    static   String eventid;
    static   String attendanceid;




    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.secondtab, container, false);
        listView = (ListView) rootView.findViewById(R.id.listsecond);
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        //MobattendDatabase db3 = new MobattendDatabase(getContext());

        registerForContextMenu(listView);



        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.emptyclasslist, null);
        ((ViewGroup)listView.getParent()).addView(emptyView);
        MobattendDatabase db = new MobattendDatabase(getActivity());
        Cursor sky2 = db.getListContents();
        if(sky2.getCount() == 0){

        }
        else{
            while (sky2.moveToNext()){
             int count = db.getCount(sky2.getString(0));
                dataModels.add(new DataModelforScreenTwo(sky2.getString(0),sky2.getString(1),String.valueOf(count)));
                adapter = new CustomAdapterforScreenTwo(dataModels,getContext());
                listView.setAdapter(adapter);
                listView.setEmptyView(emptyView);
            }
        }
       /* dataModels.add(new DataModelforScreenTwo("Linear Electronics", "COE 251","January 23, 2016"));
        dataModels.add(new DataModelforScreenTwo("Calculus", "MATH 151","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Embedded System", "COE 351","March 4, 2015"));
        dataModels.add(new DataModelforScreenTwo("Thermodynamics", "MATH 151","March 4, 2014"));
        dataModels.add(new DataModelforScreenTwo("Operating System", "COE 151","March 4, 2015"));
      */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                eventid = generate_Event_id();


                //GET THE ID FROM THE CREATE_CLASS USING DIFERENT INTENT
                mert = adapter.getItem(position).getName();//GETTING CLASS ID
                Intent intent = new Intent(getActivity(), Myattendance.class);
                intent.putExtra("classidname", adapter.getItem(position).getType());
                gblbalmert = mert;


                view.setSelected(true);

                eventid = generate_Event_id();
                attendanceid = generate_Attendance_id();




                //Intent intent1 = new Intent(getContext(),Myattendance.class);
                //startActivity(intent1);

                LayoutInflater factory = LayoutInflater.from(getContext());
                final View textEntryView = factory.inflate(R.layout.activity_event, null);


                final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

                String[] items = new String[]{"1","2","3", "4","5","6","7"} ;

                Spinner spin = (Spinner) textEntryView.findViewById(R.id.spin);
                ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, items);
                spin.setAdapter(adapter1);
                alert.setView(textEntryView);


                TextView one = (TextView) textEntryView.findViewById(R.id.eventnametext);
                TextView two = (TextView) textEntryView.findViewById(R.id.daytext);
                TextView three = (TextView) textEntryView.findViewById(R.id.weektext);
                EditText event_id = (EditText) textEntryView.findViewById(R.id.eventnamebox);
            final EditText week_edtxt = (EditText) textEntryView.findViewById(R.id.weekbox);
               final Spinner day_spinner = (Spinner) textEntryView.findViewById(R.id.spin);

                event_id.setText(eventid);


                alert.setPositiveButton("Take attendance ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        //  Toast.makeText(MainActivity.this,"this feature isnt added yet",Toast.LENGTH_LONG).show();



                        String eventName = "Week "+ week_edtxt.getText().toString()+" Day "+ day_spinner.getSelectedItem().toString();
                        MobattendDatabase db2 = new MobattendDatabase(getActivity());
                        MobattendDatabase db4 = new MobattendDatabase(getActivity());
                        boolean isCreated = db2.insertEvent(eventid,eventName);
                        boolean datetaken = db4.insertAttendanceDate(attendanceid);
                        if ((isCreated == true) && (datetaken == true)){

                           // Toast.makeText(getContext(), "Event Created", Toast.LENGTH_LONG).show();
                            Intent intent1 = new Intent(getContext(),Myattendance.class);
                            startActivity(intent1);
                        }
                       // else
                         //   Toast.makeText(getContext(), "Event not Created", Toast.LENGTH_LONG).show();









/*
                        Cursor data = db.getListContents();

                        if (data.getCount() == 0){
                            Toast.makeText(MainActivity.this, "database empty", Toast.LENGTH_SHORT).show();
                        }else{
                            while(data.moveToNext()){
                                dataModels.add(new DataModel(data.getString(1), data.getString(2),data.getString(3),data.getString(4),date));
                                adapter = new CustomAdapter(dataModels,getApplicationContext());

                                listView.setAdapter(adapter);

                            }
                        }*/

                        // dataModels.add(new DataModel("sky", "022","atlanta",date,date));
                        // adapter.notifyDataSetChanged();


                    }
                }).setNegativeButton("Cancel       ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {





                    }
                });
                AlertDialog alertDialog = alert.create();

                alertDialog.show();



            }




        });

            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                        @Override
                        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

                            menu.add(0,1,0, "add Person");
                            menu.add(0,2,0, "delete Person");
                            menu.add(0,3,0, "edit Class");
                            menu.add(0,4,0, "delete Class");

                        }
                    });
                    mert = adapter.getItem(position).getName();//GETTING CLASS ID
                    Intent intent = new Intent(getActivity(), Myattendance.class);
                    intent.putExtra("classidname", adapter.getItem(position).getType());
                    gblbalmert = mert;
                    return false;
                }
            });




             listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                 @Override
                 public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

                     menu.add(0,1,0, "add Person");
                     menu.add(0,2,0, "delete Person");
                     menu.add(0,3,0, "edit Class");
                     menu.add(0,4,0, "delete Class");

                 }
             });
        return rootView;
    }


                 public  boolean onContextItemSelected(MenuItem item){

                    MobattendDatabase db = new MobattendDatabase(getActivity());


                     AdapterView.AdapterContextMenuInfo menuInfo;

                     switch (item.getItemId()){

                         case 1:

                             Toast.makeText(getContext(),"add new person",Toast.LENGTH_LONG).show();

                             break;

                         case 2:

                             Toast.makeText(getContext(),"delete person",Toast.LENGTH_LONG).show();


                             break;


                         case 3:
                             Toast.makeText(getContext(),"edit",Toast.LENGTH_LONG).show();
                             break;


                         case 4:
                             db.getWritableDatabase();
                             boolean isdeleted = db.DeletingClassAll(gblbalmert);
                             if(isdeleted == true){
                                 Toast.makeText(getContext(), "Deleted", Toast.LENGTH_LONG).show();

                             }else {
                                 Toast.makeText(getContext(), "not Deleted", Toast.LENGTH_LONG).show();

                             }

                             dataModels = new ArrayList<>();


                             View emptyView = getActivity().getLayoutInflater().inflate(R.layout.emptyclasslist, null);
                             ((ViewGroup)listView.getParent()).addView(emptyView);
                            Cursor sky2 = db.getListContents();
                             if(sky2.getCount() == 0){

                                 listView.setEmptyView(emptyView);
                                 ClasssFragment.this.listView.start;
                             }
                             else{
                                 while (sky2.moveToNext()){
                                     int count = db.getCount(sky2.getString(0));
                                     dataModels.add(new DataModelforScreenTwo(sky2.getString(0),sky2.getString(1),String.valueOf(count)));
                                     adapter = new CustomAdapterforScreenTwo(dataModels,getContext());
                                     listView.setAdapter(adapter);
                                 }
                             }
                             break;


                         default:
                             return onContextItemSelected(item);


                     }
                    return true;
                 }






    public String generate_Event_id (){
        int alphaL=3, numL = 3;
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

    public String generate_Attendance_id (){
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




    @Override
    public void
    onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.listsecond);{
            ClasssFragment.super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getActivity().getMenuInflater();
            inflater.inflate(R.menu.mymenu,menu);

                         /*
                         AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
                         menu.setHeaderTitle("me");
                         String[] menuItems = getResources().getStringArray(R.array.menu);
                         for (int i =0; i<menuItems.length; i++){
                             menu.add(Menu.NONE, i, i, menuItems[i]);
                         }*/
        }


    }
/*
    @Override
    public  boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.add:

                Toast.makeText(getContext(),"add new person",Toast.LENGTH_LONG).show();

                return  true;

            case R.id.edit:
                Toast.makeText(getContext(),"edit",Toast.LENGTH_LONG).show();

                return true;

            case R.id.delete:



                Toast.makeText(getContext(),"delete",Toast.LENGTH_LONG).show();

                return  true;

            default:
                return ClasssFragment.super.onContextItemSelected(item);


        }


    }*/



}
