package com.example.sky_phase.mobattend;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class ModifiedSecondTab extends Fragment {
    ArrayList<DataModelforScreenTwo> dataModels;
    ListView listView;
    private static CustomAdapterforScreenTwo adapter;
       static String mert = new String();
    static String mert1 = new String();
       Activity myactivity = this.getActivity();

     static  String gblbalmert;
    static  String gblbalmert1;


    static   String eventid;
    static   String attendanceid;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.modifiedsecondtab, container, false);
        listView = (ListView) rootView.findViewById(R.id.listsecond);
        dataModels = new ArrayList<>();

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


     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             mert = adapter.getItem(position).getType();//GETTING CLASS NAME
             mert1 = adapter.getItem(position).getName();//GETTING CLASS ID
             Intent intent = new Intent(getActivity(), Stats.class);

             intent.putExtra("classidname", adapter.getItem(position).getType());
             gblbalmert = mert;
             gblbalmert1 = mert1;

             Intent intent1 = new Intent(getActivity(), Stats.class);
             startActivity(intent1);
         }
     });






             listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
                 @Override
                 public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                     if(v.getId() == R.id.listsecond){
                       ModifiedSecondTab.super.onCreateContextMenu(menu, v, menuInfo);
                         MenuInflater inflater = getActivity().getMenuInflater();
                         inflater.inflate(R.menu.mymenu,menu);
                     }


                 }

                 public  boolean onContextItemSelected(MenuItem item){


                     AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                     if (info.targetView.getParent() != getView().findViewById(android.R.id.list))
                         return ModifiedSecondTab.super.onContextItemSelected(item);



                     switch (item.getItemId()){
                         case R.id.add:

                             Toast.makeText(getContext(),"add new person",Toast.LENGTH_LONG).show();

                             return  true;

                         case R.id.edit:
                             Toast.makeText(getContext(),"edit",Toast.LENGTH_LONG).show();

                             return true;

                         case R.id.delete:




                             return  true;

                         default:
                             return onContextItemSelected(item);


                     }

                 }

             });







        //adapter = new CustomAdapterforScreenTwo(this.dataModels, this.getActivity());
       // listView.setAdapter(adapter);

        return rootView;

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
            ModifiedSecondTab.super.onCreateContextMenu(menu, v, menuInfo);
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
