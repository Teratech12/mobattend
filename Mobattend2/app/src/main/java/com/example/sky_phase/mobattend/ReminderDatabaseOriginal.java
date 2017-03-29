package com.example.sky_phase.mobattend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SKY-PHASE on 1/20/2017.
 */

public class ReminderDatabaseOriginal extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "Remind.db";
    private  static  final int DATABASE_VERSION = 4;
    public static final String REMINDER_TABLE_NAME = "person";
    public  static  final String PERSON_COLUMN_ID = "id";
    public  static  final String REMINDER_NAME = "name";
    public  static  final String REMINDER_DESCRIPTION = "description";
    public  static  final String REMINDER_DATE = "mydate";





    public ReminderDatabaseOriginal(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MY_TABLE = "CREATE TABLE " + REMINDER_TABLE_NAME + "("
                + PERSON_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + REMINDER_NAME +" TEXT," + REMINDER_DESCRIPTION + " TEXT," + REMINDER_DATE + " TEXT" +");";
        db.execSQL(CREATE_MY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REMINDER_TABLE_NAME);
        onCreate(db);

    }

    public boolean insertReminder(String name, String description,  String date){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(REMINDER_NAME, name);
        contentValues.put(REMINDER_DESCRIPTION, description);
        contentValues.put(REMINDER_DATE, date);

        long result = db.insert(REMINDER_TABLE_NAME, null,  contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }



    }

    public Cursor getReminder(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor datareminder = db.rawQuery("SELECT * FROM " + REMINDER_TABLE_NAME, null);
        return datareminder;
    }

    public  Integer deleteData(String id){

        SQLiteDatabase db = this.getWritableDatabase();
      return   db.delete(REMINDER_TABLE_NAME, "id = ?", new String[] {id} );

    }
}
