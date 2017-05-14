package com.example.sky_phase.mobattend;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */

public class ReminderFragment extends Fragment {
    ImageView reminder;
    ArrayList<DataModelForGrid> dataModels;
    ListView listView;
    String date;
    ReminderDatabaseOriginal db = new ReminderDatabaseOriginal(getActivity());
    TextView remindermessage;
    Switch myswitch;

    private static CustomAdapterforGrid adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.reminderxml, container, false);

        listView = (ListView) rootView.findViewById(R.id.grid);
        myswitch = (Switch)rootView.findViewById(R.id.switch1);




        reminder = (ImageView)rootView.findViewById(R.id.reminder);
        remindermessage = (TextView)rootView.findViewById(R.id.remindermessage);


        View emptyView = getActivity().getLayoutInflater().inflate(R.layout.emptyreminder, null);
        ((ViewGroup)listView.getParent()).addView(emptyView);
        Animation shake = AnimationUtils.loadAnimation(getActivity(), R.anim.shakewell);
       // reminder.startAnimation(shake);


        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),ReminderActivity.class);
                startActivity(intent);
            }
        });
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("mm dd,yyyy").format(new Date());

        ReminderDatabaseOriginal db = new ReminderDatabaseOriginal(getActivity());
        Cursor datareminder = db.getReminder();
       if (datareminder.getCount() == 0){

        }

        else{
            datareminder.moveToLast();
                dataModels.add(new DataModelForGrid(datareminder.getString(2), datareminder.getString(3)));
                adapter = new CustomAdapterforGrid(dataModels,getContext());

                listView.setAdapter(adapter);
                listView.setEmptyView(emptyView);


           StringBuilder remindme = new StringBuilder().append(datareminder.getString(1));
             remindermessage.setText(remindme);


        }
       // date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
       // dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));
       /* dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));
        dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));
        dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));
        dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));
        dataModels.add2(new DataModelForGrid( "COE CLASS AT 2", "12/02/2015"));*/

/*
      adapter = new CustomAdapterforGrid(dataModels,getActivity());

        listView.setAdapter(adapter);
        listView.setEmptyView(emptyView); */








        listView.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() {
            @Override
            public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                if(v.getId() == R.id.grid);{
                    ReminderFragment.super.onCreateContextMenu(menu, v, menuInfo);
                    MenuInflater inflater = getActivity().getMenuInflater();
                    inflater.inflate(R.menu.mymenu2,menu);

                         /*
                         AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
                         menu.setHeaderTitle("me");
                         String[] menuItems = getResources().getStringArray(R.array.menu);
                         for (int i =0; i<menuItems.length; i++){
                             menu.add22(Menu.NONE, i, i, menuItems[i]);
                         }*/
                }


            }

            public  boolean onContextItemSelected(MenuItem item){


                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                if (info.targetView.getParent() != getView().findViewById(android.R.id.list))
                    return ReminderFragment.super.onContextItemSelected(item);



                switch (item.getItemId()){
                    case R.id.add2:

                        Toast.makeText(getContext(),"add2 new person",Toast.LENGTH_LONG).show();

                        return  true;

                    case R.id.edit2:
                        Toast.makeText(getContext(),"edit2",Toast.LENGTH_LONG).show();

                        return true;

                    case R.id.delete2:

                        ReminderDatabaseOriginal db1 = new ReminderDatabaseOriginal(getContext());
                       Integer delete2drows = db1.deleteData("1");
                        if(delete2drows > 0){
                            Toast.makeText(getContext(),"delete2D",Toast.LENGTH_LONG).show();

                        }
                        else
                            Toast.makeText(getContext(),"not delete2d",Toast.LENGTH_LONG).show();


                        return  true;

                    default:
                        return onContextItemSelected(item);


                }

            }

        });


        return rootView;


    }

    @Override
    public void
    onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v.getId() == R.id.grid);{
            ReminderFragment.super.onCreateContextMenu(menu, v, menuInfo);
            MenuInflater inflater = getActivity().getMenuInflater();
            inflater.inflate(R.menu.mymenu2,menu);

                         /*
                         AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
                         menu.setHeaderTitle("me");
                         String[] menuItems = getResources().getStringArray(R.array.menu);
                         for (int i =0; i<menuItems.length; i++){
                             menu.add2(Menu.NONE, i, i, menuItems[i]);
                         }*/
        }


    }

    @Override
    public  boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.add2:

                Toast.makeText(getContext(),"add2 new person",Toast.LENGTH_LONG).show();

                return  true;

            case R.id.edit2:
                Toast.makeText(getContext(),"edit2",Toast.LENGTH_LONG).show();

                return true;

            case R.id.delete2:



                ReminderDatabaseOriginal db1 = new ReminderDatabaseOriginal(getContext());
                Integer delete2drows = db1.deleteData("1");
                if(delete2drows > 0){
                    Toast.makeText(getContext(),"delete2D",Toast.LENGTH_LONG).show();

                }
                else
                    Toast.makeText(getContext(),"not delete2d",Toast.LENGTH_LONG).show();

                return  true;

            default:
                return ReminderFragment.super.onContextItemSelected(item);


        }


    }
}
