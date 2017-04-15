package com.example.sky_phase.mobattend;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public  static  final String FK_CLASS_ID_COLUMN = "fk_class_id";


    //CREATING CLASS TABLE
    public static final String CLASS_TABLE_NAME = "class";
    public  static  final String CLASS_ID_COLUMN = "class_id";
    public  static  final String CLASS_NAME_COLUMN = "class_name";

    //CREATING STUDENT_EVENT TABLE
    public static final String STUDENT_EVENT_TABLE_NAME = "student_event";
    public  static  final String STUDENT_EVENT_ID_COLUMN = "student_event_id";
    public  static  final String FK_STUDENT_ID_COLUMN = "fk_student_id";
    public  static  final String FK_ATTENDANCE_ID_COLUMN = "fk_attendance_id";
    public  static  final String FK_EVENT_ID_COLUMN = "fk_event_id";

    //CREATING THE EVENT TABLE
    public static final String EVENT_TABLE_NAME = "event";
    public  static  final String EVENT_ID_COLUMN = "event_id";
    public  static  final String EVENT_NAME_COLUMN = "event_name";


    //CREATING THE ATTENDANCE TABLE
    public static final String ATTENDANCE_TABLE_NAME = "attendance";
    public  static  final String ATTENDANCE_ID_COLUMN = "attendance_id";
    public  static  final String ATTENDANCE_TIME_COLUMN = "attendance_time";


    //tag
    private final String TAG = MobattendDatabase.class.getSimpleName().toString();


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
                + STUDENT_ID_COLUMN + " VARCHAR NOT NULL," + STUDENT_NAME_COLUMN +" TEXT,"
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

    public boolean insertStudentEvent(String student_event_id, String student_id, String attendance_id, String event_id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(STUDENT_EVENT_ID_COLUMN, student_event_id);
        contentValues.put(FK_STUDENT_ID_COLUMN, student_id);
        contentValues.put(FK_ATTENDANCE_ID_COLUMN, attendance_id);
        contentValues.put(FK_EVENT_ID_COLUMN, event_id);
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


    public Cursor
    getListContents2(String clkid ){
        //String be = "zggx";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sky = db.rawQuery("SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE "+FK_CLASS_ID_COLUMN+ "='"+clkid + "'", null);
        return sky;
    }


    public int getCount(String clkid ){
        //String be = "zggx";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sky = db.rawQuery("SELECT * FROM " + STUDENT_TABLE_NAME + " WHERE "+FK_CLASS_ID_COLUMN+ "='"+clkid + "'", null);
          int count = sky.getCount();
        return count;
    }


    public Cursor getRandomInfo( ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_TABLE_NAME + " ORDER BY RANDOM() LIMIT 1",null);

        return cursor;


    }

    public Integer DeleteFromStudentEventTable(String student_id, String attendance_id, String event_id){

        SQLiteDatabase db = this.getWritableDatabase();
        return   db.delete(STUDENT_EVENT_TABLE_NAME, FK_STUDENT_ID_COLUMN + "=? AND " + FK_ATTENDANCE_ID_COLUMN + "=? AND " +
                        FK_EVENT_ID_COLUMN + "=?",
                new String[] {student_id, attendance_id, event_id});


    }
    public Cursor displayDate( ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + ATTENDANCE_TABLE_NAME  ,null);

        return cursor;


    }


    public Cursor QueryForDateSearch(String date) {

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + STUDENT_EVENT_TABLE_NAME + " s" + " JOIN " + ATTENDANCE_TABLE_NAME
                + " a " + " ON s." + FK_ATTENDANCE_ID_COLUMN + " =p." + ATTENDANCE_ID_COLUMN + " WHERE a." + ATTENDANCE_TIME_COLUMN + " LIKE '%" +
                date + "%'" , null);

        return cursor;

    }

    public Cursor checkingRoll(String ClassId, String AttendanceDate){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT s.student_name, s.student_id " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId+"' AND a.attendance_time ='"+AttendanceDate+"'"  ,null);
        return cursor;

    }

    public Cursor checkingRollbyName(String ClassId1, String studentName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT distinct e.event_name, a.attendance_time " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId1+"' AND s.student_name ='"+studentName+"'"  ,null);
        return cursor;

    }

    public Cursor displayDate1(String ClassId2 ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT distinct a.attendance_time " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"'"   ,null);

        return cursor;


    }

    public int getAttendanceCount(String ClassId2 ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT distinct e.event_id, e.event_name " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"'"   ,null);
            int count = cursor.getCount();

        return count;


    }

    public Cursor getAllStudentsofClass (String ClassId2 ){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT distinct s.student_id, s.student_name " +
                "FROM student AS s " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"' " +
                "ORDER BY s.student_name"   ,null);

        return cursor;


    }

    public int getNumbOfTimesOfStd (String ClassId2, String StudentId){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT distinct a.attendance_time, e.event_name " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"' AND s.student_id ='"+StudentId+"'"   ,null);
        int count = cursor.getCount();

        return count;


    }

    public boolean DelClassAndAllRelated (String ClassId2){

        SQLiteDatabase db = this.getWritableDatabase();

        String query1 = "DELETE FROM event " +
                "WHERE event_id IN (SELECT distinct e.event_id " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id  " +
                "WHERE c.class_id = '"+ClassId2+"');";
        String query2 = "DELETE FROM attendance " +
                "WHERE attendance_id IN (SELECT distinct a.attendance_id " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id  " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"');";
        String query3 = "DELETE FROM  student_event " +
                "WHERE fk_student_id  IN (SELECT student_id FROM student WHERE fk_class_id = '"+ClassId2+"');";
        String query4 = "DELETE FROM  student " +
                "WHERE fk_class_id  IN (SELECT class_id FROM class WHERE class_id = '"+ClassId2+"');";
        String query5 = "DELETE FROM  class " +
                "WHERE class_id = '"+ClassId2+"';";

        try{
            db.beginTransaction();

            Log.d(TAG, query1);
            Log.d(TAG, query2);
            Log.d(TAG, query3);
            Log.d(TAG, query4);
            Log.d(TAG, query5);
            db.execSQL(query1);
            db.execSQL(query2);
            db.execSQL(query3);
            db.execSQL(query4);
            db.execSQL(query5);

            return true;

        }catch (Exception e){
            e.getMessage();
            return false;
        }finally {
            db.endTransaction();
        db.close();
        }

    }

    public boolean DeletingClassAll (String ClassId2){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT distinct e.event_id " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id " +
                "JOIN event AS e ON e.event_id = v.fk_event_id " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id  " +
                "WHERE c.class_id = '"+ClassId2+"'" ,null);
        String ans1 = cursor.toString();
        Cursor cursor2 = db.rawQuery("SELECT distinct a.attendance_id " +
                "FROM student AS s " +
                "JOIN student_event AS v ON s.student_id = v.fk_student_id  " +
                "JOIN attendance AS a ON a.attendance_id = v.fk_attendance_id " +
                "JOIN class AS c ON c.class_id = s.fk_class_id " +
                "WHERE c.class_id = '"+ClassId2+"'" ,null);
        String ans2 = cursor2.toString();
        Cursor cursor3 = db.rawQuery("SELECT student_id FROM student " +
                "WHERE fk_class_id = '"+ClassId2+"'" ,null);
        String ans3 = cursor3.toString();
        Cursor cursor4 = db.rawQuery("SELECT class_id FROM class " +
                "WHERE class_id = '"+ClassId2+"'" ,null);
        String ans4 = cursor4.toString();
//        try{
//            db.beginTransaction();

        db.delete("event", "event_id =?", new String[] {ans1});
        db.delete("attendance", "attendance_id =? ", new String[] {ans2});
        db.delete("student_event", "fk_student_id =? ", new String[] {ans3});
        db.delete("student", "fk_class_id =? ", new String[] {ClassId2});
        db.delete("class", "class_id =? ", new String[] {ClassId2});



            return true;

//        }catch (Exception e){
//            e.getMessage();
//            return false;
//        }finally {
//            db.endTransaction();
//            db.close();
//        }



    }



}
