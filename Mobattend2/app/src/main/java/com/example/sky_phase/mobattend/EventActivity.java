package com.example.sky_phase.mobattend;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {
    Spinner spin;
    TextView tex1, text2, text3;
    EditText edit1, edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
         tex1 = (TextView)findViewById(R.id.eventnametext);
        text2 = (TextView)findViewById(R.id.daytext);
        text3 = (TextView)findViewById(R.id.weektext);
        edit1 = (EditText)findViewById(R.id.eventnamebox);
        edit2 = (EditText)findViewById(R.id.weekbox);
        spin = (Spinner)findViewById(R.id.spin);
        String[] items = new String[]{"1","2","3", "4","5","6","7"} ;


        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, items);
        spin.setAdapter(adapter1);
    }
}
