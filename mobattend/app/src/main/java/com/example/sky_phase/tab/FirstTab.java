package com.example.sky_phase.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by SKY-PHASE on 1/31/2017.
 */
public class FirstTab extends Fragment  {
    LinearLayout linear;
    ArrayList<DataModel> dataModels;
    ListView listView;
    String date;
    private static CustomAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.firsttab, container, false);
        listView = (ListView) rootView.findViewById(R.id.list);
        dataModels = new ArrayList<>();
        date = new SimpleDateFormat("MMMM d,yyyy").format(new Date());
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Afred Annor", "22752514"));
        dataModels.add(new DataModel("Obeng Richard", "2275714"));
        dataModels.add(new DataModel("Jephter Danso", "2248714"));
        dataModels.add(new DataModel("Prince Awuah", "224714"));
        dataModels.add(new DataModel("Michael Surname", "2275714"));
        dataModels.add(new DataModel("Andy Surname", "2275714"));
        dataModels.add(new DataModel("Akua Kobi", "2274554"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));
        dataModels.add(new DataModel("Gregory Aidoo", "22415714"));

        adapter = new CustomAdapter(dataModels,getActivity());

        listView.setAdapter(adapter);

        return rootView;



    }



}