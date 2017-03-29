package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ADDING_STUDENTS extends AppCompatActivity {
    EditText studentName, studentID, classNameStudent;
    Button anotherStudent, finish;
    CREATE_CLASS myclass = new CREATE_CLASS();
    String classIdFK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // classIdFK = myclass.classId;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding__students);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        studentName = (EditText)findViewById(R.id.studentNameEditBox);
       // final String student = studentName.getText().toString();
        studentID = (EditText)findViewById(R.id.studentIdEditBox);
      // final String id = studentID.getText().toString();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        Intent intent = getIntent();
        final String setname = intent.getStringExtra("classidname");
        Toast.makeText(ADDING_STUDENTS.this,setname,Toast.LENGTH_LONG).show();

        classNameStudent = (EditText)findViewById(R.id.classNameUnedit);

        final String holdclass = myclass.className;
        classNameStudent.setText(setname);
        anotherStudent = (Button) findViewById(R.id.AddAnotherStudentText);
        finish = (Button) findViewById(R.id.FinishText);

        anotherStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentName.length() ==0 || studentID.length() ==0){
                    Toast.makeText(getApplicationContext(),"Specify Student name and Student Id",Toast.LENGTH_LONG).show();
                }
                else{
                    MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());
                    db1.getWritableDatabase();
                    boolean isInseerted = db1.insertStudent(studentName.getText().toString(),studentID.getText().toString(),setname);
                    if(isInseerted== true){
                        Toast.makeText(ADDING_STUDENTS.this, "inserted", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(ADDING_STUDENTS.this, "not inserted", Toast.LENGTH_LONG).show();
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
                    boolean isInseerted = db1.insertStudent(studentName.getText().toString(),studentID.getText().toString(),setname);
                    if(isInseerted== true){
                        Toast.makeText(ADDING_STUDENTS.this, "inserted", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(ADDING_STUDENTS.this, "not inserted", Toast.LENGTH_LONG).show();

                    }

                    Intent intent = new Intent(ADDING_STUDENTS.this,MainActivity.class);
                    startActivity(intent);
                }




            }
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);




    }
    @Override
    public  boolean onSupportNavigateUp(){
        //Intent intent = new Intent(ADDING_STUDENTS.this,MainActivity.class);
       // startActivity(intent);
        finish();

        return true;
    }


}
