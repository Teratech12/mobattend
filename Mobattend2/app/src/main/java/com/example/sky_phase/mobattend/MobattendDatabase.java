package com.example.sky_phase.mobattend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by SKY-PHASE on 3/5/2017.
 */
public class MobattendDatabase extends SQLiteOpenHelper {
    public static final  String DATABASE_NAME = "mobattend.db";
    private  static  final int DATABASE_VERSION = 7;

    //CREATING STUDENT TABLE
    public static final String STUDENT_TABLE_NAME = "student";
    public  static  final String STUDENT_ID_COLUMN = "student_id";
    public  static  final String STUDENT_NAME_COLUMN = "student_name";
    public  static  final String DELETED_COLUMN = "deleted";
    public  static  final String FK_CLASS_ID_COLUMN = "class_id";


    //CREATING CLASS TABLE
    public static final String CLASS_TABLE_NAME = "class";
    public  static  final String CLASS_ID_COLUMN = "class_id";
    public  static  final String CLASS_NAME_COLUMN = "class_name";

    //CREATING STUDENT_EVENT TABLE
    public static final String STUDENT_EVENT_TABLE_NAME = "student_event";
    public  static  final String STUDENT_EVENT_ID_COLUMN = "student_event_id";
    public  static  final String FK_STUDENT_ID_COLUMN = "student_id";
    public  static  final String FK_ATTENDANCE_ID_COLUMN = "attendance_id";
    public  static  final String FK_EVENT_ID_COLUMN = "event_id";

    //CREATING THE EVENT TABLE
    public static final String EVENT_TABLE_NAME = "event";
    public  static  final String EVENT_ID_COLUMN = "event_id";
    public  static  final String EVENT_NAME_COLUMN = "event_name";


    //CREATING THE ATTENDANCE TABLE
    public static final String ATTENDANCE_TABLE_NAME = "attendance";
    public  static  final String ATTENDANCE_ID_COLUMN = "attendance_id";
    public  static  final String ATTENDANCE_TIME_COLUMN = "attendance_name";




    public MobattendDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CLASS_TABLE = "CREATE TABLE " + CLASS_TABLE_NAME + "("
                + CLASS_ID_COLUMN + " VARCHAR PRIMARY KEY NOT NULL," + CLASS_NAME_COLUMN +" TEXT"  +");";
        //Student Table has one foreign Key
        // from Class_id
        //deleted should be boolean and by default 0
        String CREATE_STUDENT_TABLE = "CREATE TABLE " + STUDENT_TABLE_NAME + "("
                + STUDENT_ID_COLUMN + " VARCHAR PRIMARY KEY NOT NULL," + STUDENT_NAME_COLUMN +" TEXT,"
                + DELETED_COLUMN +" BOOLEAN NOT NULL DEFAULT 0," + FK_CLASS_ID_COLUMN +" VARCHAR,"
                + "FOREIGN KEY ("+FK_CLASS_ID_COLUMN+") REFERENCES " +CLASS_TABLE_NAME + " ("+CLASS_ID_COLUMN+")"  +");";

        //Attendance Table has no Foreign Key
        //DateTime: TIMESTAMP DEFAULT CURRENT_TIMESTAMP
        String CREATE_ATTENDANCE_TABLE = "CREATE TABLE " + ATTENDANCE_TABLE_NAME + "("
                + ATTENDANCE_ID_COLUMN +" VARCHAR PRIMARY KEY NOT NULL," + ATTENDANCE_TIME_COLUMN +" TIMESTAMP DEFAULT CURRENT_TIMESTAMP"  +");";

        // Event Table has no Foreign Key
        String CREATE_EVENT_TABLE = "CREATE TABLE " + EVENT_TABLE_NAME + "("
                + EVENT_ID_COLUMN + " VARCHAR PRIMARY KEY NOT NULL," + EVENT_NAME_COLUMN +" TEXT"  +");";

        //Student Event Table is Having three Foreign Keys
        // From Student_id
        // From Event_id
        // From Attendance_id
        String CREATE_STUDENT_EVENT_TABLE = "CREATE TABLE " + STUDENT_EVENT_TABLE_NAME + "("
                + STUDENT_EVENT_ID_COLUMN + " VARCHAR PRIMARY KEY NOT NULL," + FK_STUDENT_ID_COLUMN +" VARCHAR,"
                + FK_ATTENDANCE_ID_COLUMN +" INTEGER," + FK_EVENT_ID_COLUMN +" VARCHAR,"
                + "FOREIGN KEY ("+FK_STUDENT_ID_COLUMN+") REFERENCES " +STUDENT_TABLE_NAME + " ("+STUDENT_ID_COLUMN+")" +");"
                + "FOREIGN KEY ("+FK_ATTENDANCE_ID_COLUMN+") REFERENCES " +ATTENDANCE_TABLE_NAME + " ("+ATTENDANCE_ID_COLUMN+")" +");"
                + "FOREIGN KEY ("+FK_EVENT_ID_COLUMN+") REFERENCES " +EVENT_TABLE_NAME + " ("+EVENT_ID_COLUMN+")"+");";

        //ALLOWING FOREIGN KEYS
        db.execSQL("PRAGMA foreign_keys = ON");
        //CREATING THE TABLES
        db.execSQL(CREATE_CLASS_TABLE);
        db.execSQL(CREATE_STUDENT_TABLE);
        db.execSQL(CREATE_STUDENT_EVENT_TABLE);
        db.execSQL(CREATE_EVENT_TABLE);
        db.execSQL(CREATE_ATTENDANCE_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CLASS_TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + STUDENT_EVENT_TABLE_NAME );
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + EVENT_TABLE_NAME);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + ATTENDANCE_TABLE_NAME);
        onCreate(db);


    }

    public boolean insertPerson(String S_EVENT_ID, String ID, int ATTEDANCE_ID, String EVEN_ID){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_EVENT_ID_COLUMN, S_EVENT_ID);
        contentValues.put(FK_STUDENT_ID_COLUMN, ID);
        contentValues.put(FK_ATTENDANCE_ID_COLUMN, ATTEDANCE_ID);
        contentValues.put(FK_EVENT_ID_COLUMN, EVEN_ID);
        long result = db.insert(STUDENT_EVENT_TABLE_NAME, null,  contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }



    }

    public boolean insertStudent(String Student_Name, String Student_Id, String Class){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_NAME_COLUMN, Student_Name);
        contentValues.put(STUDENT_ID_COLUMN, Student_Id);
        contentValues.put(FK_CLASS_ID_COLUMN , Class);

        long result = db.insert(STUDENT_TABLE_NAME, null,  contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }



    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    public boolean insertAttendanceDate(String Attendance_id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ATTENDANCE_ID_COLUMN, Attendance_id);
        //contentValues.put(ATTENDANCE_TIME_COLUMN,getDateTime());
        long result = db.insert(ATTENDANCE_TABLE_NAME, null,  contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }
    }


    public boolean insertClass(String Class_Id, String Class_Name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CLASS_ID_COLUMN, Class_Id);
        contentValues.put(CLASS_NAME_COLUMN, Class_Name);
        //contentValues.put(CLASS_ID_COLUMN, Class_Id);

        long result = db.insert(CLASS_TABLE_NAME, null,  contentValues);
        if(result==-1)
        {
            return  false;
        }
        else {
            return true;
        }

    }

    public boolean insertEvent(String Event_id, String Event_name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(EVENT_ID_COLUMN, Event_id);
        contentValues.put(EVENT_NAME_COLUMN, Event_name);

        long result = db.insert(EVENT_TABLE_NAME, null, contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getListContents(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sky = db.rawQuery("SELECT * FROM " + CLASS_TABLE_NAME, null);
        return sky;
    }


    public Cursor getListContents2(String clkid ){
        //String be = "zggx";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sky = db.rawQuery("SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE "+FK_CLASS_ID_COLUMN+ "='"+clkid + "'", null);
        return sky;
    }


    public Cursor getRandomInfo( ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE_NAME + " ORDER BY RANDOM() LIMIT 1",null);

        return cursor;


    }


}
