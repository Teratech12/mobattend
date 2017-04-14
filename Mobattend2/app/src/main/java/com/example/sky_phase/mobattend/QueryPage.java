package com.example.sky_phase.mobattend;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class QueryPage extends AppCompatActivity {

    ListView list;

    ArrayList<DataModelRetrieval> DataModelRetrievals;

    String date;
    private static CustomAdapterRetrieval adapter;

    Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_page);
        list = (ListView)findViewById(R.id.list);
        upload = (Button)findViewById(R.id.importFromExcel);

        adapter = new CustomAdapterRetrieval(DataModelRetrievals,getApplicationContext());

//        list.setAdapter(adapter);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
                fileintent.setType("gagt/sdf");
                try {
                    //startActivityForResult(fileintent, requestcode);
                }catch (ActivityNotFoundException e){
                    // a code to be displayed if notthing is found on the activity pick
                }
            }
        });
















    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;
        switch (requestCode) {
            case requestcode:
                String FilePath = data.getData().getPath();
                try {
                    if (resultCode == RESULT_OK) {
                        AssetManager am = this.getAssets();
                        InputStream inStream;
                        Workbook wb = null;
                        try {
                            inStream = new FileInputStream(FilePath);
                            wb = new HSSFWorkbook(inStream);
                            inStream.close();
                        } catch (IOException e) {
                            lbl.setText("First "+e.getMessage().toString());
                            e.printStackTrace();
                        }

                        XlsxCon dbAdapter = new XlsxCon(this);
                        Sheet sheet1 = wb.getSheetAt(0);

                        Sheet sheet2 = wb.getSheetAt(1);
                        if (sheet1 == null) {
                            return;
                        }
                        if (sheet2 == null) {
                            return;
                        }

                        dbAdapter.open();
                        dbAdapter.delete();
                        dbAdapter.close();
                        dbAdapter.open();
                        Excel2SQLiteHelper.insertExcelToSqlite(dbAdapter, sheet1);
                        Excel2SQLiteHelper.insertExcelToSqlite(dbAdapter, sheet2);
                        dbAdapter.close();

                    }
                } catch (Exception ex) {
                    lbl.setText(ex.getMessage().toString() + "Second");
                }

                ArrayList<HashMap<String, String>> myList = controller
                        .getProducts();
                if (myList.size() != 0) {
                    ListView lv = getListView();
                    ListAdapter adapter = new SimpleAdapter(Excel.this, myList,
                            R.layout.v, new String[]{Company, Product,
                            Price},
                            new int[]{R.id.txtproductcompany, R.id.txtproductname,
                                    R.id.txtproductprice});
                    setListAdapter(adapter);
                }
        }
    }*/
}
