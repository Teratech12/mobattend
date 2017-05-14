package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Adding_Student_From_Context extends AppCompatActivity {
    EditText studentName, studentID, classNameStudent;
    Button anotherStudent, finish;
    ClasssFragment myclass = new ClasssFragment();
    String getclass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding__students);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        studentName = (EditText)findViewById(R.id.studentNameEditBox);
        // final String student = studentName.getText().toString();
        studentID = (EditText)findViewById(R.id.studentIdEditBox);
        anotherStudent = (Button) findViewById(R.id.AddAnotherStudentText);
        finish = (Button) findViewById(R.id.FinishText);
        classNameStudent = (EditText)findViewById(R.id.classNameUnedit);
        getclass = myclass.mert;
        classNameStudent.setText(getclass);



        anotherStudent.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(studentName.length() ==0 || studentID.length() ==0){
                    Toast.makeText(getApplicationContext(),"Specify Student name and Student Id",Toast.LENGTH_LONG).show();
                }
                else{
                    MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());
                    db1.getWritableDatabase();
                    boolean isInseerted = db1.insertStudent(studentName.getText().toString(),studentID.getText().toString(),getclass.toString());
                    if(isInseerted== true){
                        Toast.makeText(Adding_Student_From_Context.this, "inserted", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(Adding_Student_From_Context.this, "not inserted", Toast.LENGTH_LONG).show();
                    }

                }

                studentName.setText("");
                studentID.setText("");

            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(studentName.length() ==0 || studentID.length() ==0){
                    Toast.makeText(getApplicationContext(),"Specify Student name and Student Id",Toast.LENGTH_LONG).show();
                }
                else{
                    MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());
                    db1.getWritableDatabase();
                    boolean isInseerted = db1.insertStudent(studentName.getText().toString(),studentID.getText().toString(),getclass);
                    if(isInseerted== true){
                        Toast.makeText(Adding_Student_From_Context.this, "inserted", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(Adding_Student_From_Context.this, "not inserted", Toast.LENGTH_LONG).show();

                    }

                    Intent intent = new Intent(Adding_Student_From_Context.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }




            }
        });
    }
}
