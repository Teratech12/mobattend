package com.example.sky_phase.mobattend;

//the Database for the reminder goes here

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jeneral on 1/20/2017.
 */

public class ReminderDatabase extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "ReminderDatabase.db";
    private  static  final int DATABASE_VERSION = 7;
    public static final String REMINDER_TABLE_NAME = "person";
    public  static  final String PERSON_COLUMN_ID = "id";
    public  static  final String REMINDER_NAME = "name";
    public  static  final String REMINDER_DESCRIPTION = "description";
    public  static  final String REMINDER_DATE = "mydate";





    public ReminderDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MY_TABLE = "CREATE TABLE " + REMINDER_TABLE_NAME + "("
                + PERSON_COLUMN_ID + " INTEGER PRIMARY KEY," + REMINDER_NAME +" TEXT," + REMINDER_DESCRIPTION + " TEXT," + REMINDER_DATE + " TEXT" +");";
        db.execSQL(CREATE_MY_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + REMINDER_TABLE_NAME);
        onCreate(db);

    }

    public boolean insertrReminder(String name, String description,  String date){
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
}
