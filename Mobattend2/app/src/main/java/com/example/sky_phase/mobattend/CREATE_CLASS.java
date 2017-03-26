package com.example.sky_phase.mobattend;

//Code for creating Class goes here




import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CREATE_CLASS extends AppCompatActivity {
    TextView addStudent;
    EditText getClass;
    EditText getClassID;
    MobattendDatabase db1 = new MobattendDatabase(this);
    String className;
    public  static String classId = null;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_create__class);
        addStudent = (TextView)findViewById(R.id.addstudentText);
        getClass = (EditText)findViewById(R.id.ClassNameEditBox);
        getClassID = (EditText)findViewById(R.id.ClassIdEditBox);



        // classId = getClassID.getText().toString();



        addStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(CREATE_CLASS.this,Myattendance.class);
                intent2.putExtra("classidnamefor2",getClass.getText().toString());


                if(getClass.length() == 0 || getClassID.length() == 0){
                    Toast.makeText(getApplicationContext(),"Specify Course name and Course Id",Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(CREATE_CLASS.this,ADDING_STUDENTS.class);
                    intent.putExtra("classidname",getClassID.getText().toString());



                    Intent intent3 = getIntent();
                    final String setname = intent3.getStringExtra("classidname");



                    startActivity(intent);
                    //MobattendDatabase db1 = new MobattendDatabase(getApplicationContext());

                    //  className = getClass.getText().toString();
                    // classId = getClassID.getText().toString();
                    db1.getWritableDatabase();
                    boolean isInseerted = db1.insertClass(getClassID.getText().toString(),getClass.getText().toString());
                    if(isInseerted== true){
                        Toast.makeText(CREATE_CLASS.this, "inserted", Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(CREATE_CLASS.this, "not inserted", Toast.LENGTH_LONG).show();
                    }


                }



            }
        });
    }

    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }
}
