package com.example.sky_phase.mobattend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ListView;

import java.util.ArrayList;

public class ListForData extends AppCompatActivity {

    ArrayList<DataModelForListForData> dataModels;
    private static CustomAdapterforListData adapter;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_for_data);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        listView = (ListView)findViewById(R.id.listfordata);
        dataModels = new ArrayList<>();
        dataModels.add(new DataModelForListForData( ));
        dataModels.add(new DataModelForListForData( ));
        dataModels.add(new DataModelForListForData( ));
        dataModels.add(new DataModelForListForData( ));dataModels.add(new DataModelForListForData( ));
        dataModels.add(new DataModelForListForData( ));
        adapter = new CustomAdapterforListData(dataModels,ListForData.this);

        listView.setAdapter(adapter);

    }
}
