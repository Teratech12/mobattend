package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.amulyakhare.textdrawable.TextDrawable;

public class ChooseSearch extends AppCompatActivity {
    ImageView search_by_date, student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_search);
        search_by_date = (ImageView) findViewById(R.id.search_by_date);
        student = (ImageView) findViewById(R.id.student_name);

       String keep = "Search  by  date";
        String keep2 = "Search using student name";
        int getcolor = Color.DKGRAY;
        TextDrawable mydrawable = TextDrawable.builder().buildRoundRect(keep,getcolor,20);
        TextDrawable mydrawable1 = TextDrawable.builder().buildRoundRect(keep2,getcolor,20);
        search_by_date.setImageDrawable(mydrawable);
        student.setImageDrawable(mydrawable1);

        search_by_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseSearch.this,Display_Search_By_Date.class);
                startActivity(intent);
            }
        });

        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseSearch.this,Display_Search_By_Students.class);
                startActivity(intent);
            }
        });

    }
}
