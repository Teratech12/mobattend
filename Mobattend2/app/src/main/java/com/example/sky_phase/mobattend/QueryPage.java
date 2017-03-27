package com.example.sky_phase.mobattend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class QueryPage extends AppCompatActivity {

    ListView list;

    ArrayList<DataModelRetrieval> DataModelRetrievals;

    String date;
    private static CustomAdapterRetrieval adapter;

    Button search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_page);
        list = (ListView)findViewById(R.id.list);
        DataModelRetrievals = new ArrayList<>();
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


        adapter = new CustomAdapterRetrieval(DataModelRetrievals,getApplicationContext());

        list.setAdapter(adapter);















    }
}
