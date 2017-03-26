package com.example.sky_phase.mobattend;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */
public class FirstTab extends Fragment {
    LinearLayout linear;
    ArrayList<DataModelRetrieval> DataModelRetrievals;
    ListView listView;
    String date;
    private static CustomAdapterRetrieval adapter;
    ImageView imageView;
    Spinner spinner1;
    Spinner spinner2;
    DatePicker datePicker;
    Button search;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.firsttab, container, false);
      search = (Button)rootView.findViewById(R.id.searchButton);
        listView = (ListView) rootView.findViewById(R.id.list);
        DataModelRetrievals = new ArrayList<>();
        datePicker =(DatePicker)rootView.findViewById(R.id.querydatepicker);
        spinner1 = (Spinner)rootView.findViewById(R.id.spinner1);
        String[] items = new String[]{"COE 124","COE 257","COE 214", "COE 364","COE 597"} ;

        //  spinner1.getSolidColor(Color.GREEN);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_dropdown_item, items);
        spinner1.setAdapter(adapter1);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater factory = LayoutInflater.from(getContext());
                final View textEntryView = factory.inflate(R.layout.activity_query_page, null);

                ListView list = (ListView) textEntryView.findViewById(R.id.list);







                final AlertDialog.Builder alert = new AlertDialog.Builder(getContext());


                alert.setIcon(R.drawable.myappicon).setTitle("COE 251 CLASS ON 22/02/2017").setMessage("choose class and date").setView(textEntryView);


                alert.setNegativeButton("Cancel       ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // Intent intent = new Intent(getContext(),QueryPage.class);
                        //startActivity(intent);
                        // Toast.makeText(MainActivity.this,"this feature isnt added yet",Toast.LENGTH_LONG).show();
                              dialog.cancel();

                    }
                });
                AlertDialog alertDialog = alert.create();

                alertDialog.show();

            }
        });

        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        DataModelRetrievals.add(new DataModelRetrieval("Afred Annor", "1"));
        DataModelRetrievals.add(new DataModelRetrieval("Obeng Richard", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Jephter Danso", "1"));
        DataModelRetrievals.add(new DataModelRetrieval("Prince Awuah", "224714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Michael Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Andy Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Akua Kobi", "2274554"));
        DataModelRetrievals.add(new DataModelRetrieval("Gregory Aidoo", "1"));
        DataModelRetrievals.add(new DataModelRetrieval("Afred Annor", "22752514"));
        DataModelRetrievals.add(new DataModelRetrieval("Obeng Richard", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Jephter Danso", "2248714"));
        DataModelRetrievals.add(new DataModelRetrieval("Prince Awuah", "224714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Michael Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Andy Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Akua Kobi", "2274554"));
        DataModelRetrievals.add(new DataModelRetrieval("Gregory Aidoo", "22415714"));
        DataModelRetrievals.add(new DataModelRetrieval("Afred Annor", "22752514"));
        DataModelRetrievals.add(new DataModelRetrieval("Obeng Richard", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Jephter Danso", "2248714"));
        DataModelRetrievals.add(new DataModelRetrieval("Prince Awuah", "224714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Michael Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Andy Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Akua Kobi", "2274554"));
        DataModelRetrievals.add(new DataModelRetrieval("Gregory Aidoo", "22415714"));
        DataModelRetrievals.add(new DataModelRetrieval("Afred Annor", "22752514"));
        DataModelRetrievals.add(new DataModelRetrieval("Obeng Richard", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Jephter Danso", "2248714"));
        DataModelRetrievals.add(new DataModelRetrieval("Prince Awuah", "224714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Michael Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Andy Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Akua Kobi", "2274554"));
        DataModelRetrievals.add(new DataModelRetrieval("Gregory Aidoo", "22415714"));
        DataModelRetrievals.add(new DataModelRetrieval("Afred Annor", "22752514"));
        DataModelRetrievals.add(new DataModelRetrieval("Obeng Richard", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Jephter Danso", "2248714"));
        DataModelRetrievals.add(new DataModelRetrieval("Prince Awuah", "224714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Michael Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Andy Surname", "2275714"));
        DataModelRetrievals.add(new DataModelRetrieval( "Akua Kobi", "2274554"));
        DataModelRetrievals.add(new DataModelRetrieval("Gregory Aidoo", "22415714"));


        adapter = new CustomAdapterRetrieval(DataModelRetrievals,getActivity());

        listView.setAdapter(adapter);


        return rootView;



    }



}