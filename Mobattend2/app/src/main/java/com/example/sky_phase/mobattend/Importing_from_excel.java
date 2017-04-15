package com.example.sky_phase.mobattend;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Importing_from_excel extends AppCompatActivity {
    Button addFromExcel;
    EditText getClass;
    EditText getClassID;
    EditText path;
    Button importfromexcel;
    public static final int requestcode = 780;

    String FilePath;
     static String me;
    static String getID;
    File path2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_importing_from_excel);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           addFromExcel = (Button) findViewById(R.id.addstudentText);
        getClass = (EditText)findViewById(R.id.ClassNameEditBox);
        getClassID = (EditText)findViewById(R.id.ClassIdEditBox);
         path = (EditText) findViewById(R.id.editpath);
        importfromexcel = (Button)findViewById(R.id.importButton);

        addFromExcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);

                fileintent.setType("*/*");

                try {

                    startActivityForResult(fileintent, requestcode);

                } catch (Exception e) {

                    Log.e("tag","NO activity can handle file picking");

                }
            }
        });

        importfromexcel.setOnClickListener(new View.OnClickListener() {
            MobattendDatabase db = new MobattendDatabase(getApplicationContext());
            @Override
            public void onClick(View v) {

                if(getClassID.length()==0 || getClass.length()==0 || path.length()==0){
                    Toast.makeText(Importing_from_excel.this, "provide class name, class id and  choose an excel file" , Toast.LENGTH_SHORT).show();
                }
                else {
                    getID = getClassID.getText().toString();

                    boolean isInseerted = db.insertClass(getClassID.getText().toString(), getClass.getText().toString());
                    if (isInseerted == true) {
                        Toast.makeText(Importing_from_excel.this, "class added", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(Importing_from_excel.this, "class not added", Toast.LENGTH_SHORT).show();
                    }

                    path2 = new File(getApplicationContext().getFilesDir() + "/document/primary:myexcel2.csv");
                    path2.mkdirs(); //create folders where write files
                    final File file = new File(path2, "BlockForTest.txt");
                    String path = "/document/primary:myexcel2.csv";
                    File dir = new File(Environment.getExternalStorageDirectory(), "/document/primary:myexcel2.csv");
                    String myt = String.valueOf(dir);
                    dir.mkdir();

                    try {
                        db.loadCSV(path2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(Importing_from_excel.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data == null)

            return;

        switch (requestCode) {

            case requestcode:

               FilePath = data.getData().getPath();
              //  data.setType("*/*");
                File dir = new File(data.getData().getLastPathSegment());
                 me = String.valueOf(FilePath);


                try {

                    if (resultCode == RESULT_OK) {

                        AssetManager am = this.getAssets();

                        InputStream inStream;

                        Workbook wb = null;
                        path.setText(me);



















                    }

                } catch (Exception ex) {

                    Log.e("tag","error");

                }





        }

    }

    public  boolean onSupportNavigateUp(){
        finish();

        return true;
    }
}
