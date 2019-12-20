package com.example.myprojectui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "LawNOrder1.db";
    Context context1;
    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
        context1 = context;
      //  Toast.makeText(context,"constructor is called",Toast.LENGTH_LONG);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + "user_info" + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, PASSPORT_NO TEXT UNIQUE NOT NULL, FIRSTNAME TEXT, LASTNAME TEXT, DOB DATE, MOBILE_NO TEXT, EMAIL TEXT, ADRS TEXT, LOGIN_NAME TEXT UNIQUE NOT NULL, PASSWORD TEXT NOT NULL)");
      //  Toast.makeText(context1,"constructor is called",Toast.LENGTH_LONG);
        db.execSQL("create table " + "complaint_details" + " (Complaint_ID INTEGER PRIMARY KEY AUTOINCREMENT, RESPONDENT_NAME TEXT, FILED_DATE DATE, TYPE_OF_CMPLNT TEXT, " +
                "BRIEF_LINE TEXT, INCIDENT_SUM TEXT, DofIncident TEXT, LocationOfIncident TEXT, USER_ID INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertIntoUserInfo(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("user_info",null,contentValues);
    }

    public Cursor getAllData(String table_name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+table_name, null);
        return res;
    }

    public Cursor authenticateUser(String user, String pwd) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from user_info where LOGIN_NAME = '"+user+"' and PASSWORD = '"+pwd +"'", null);
        return res;
    }


    public Cursor getUserDetails(int ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from user_info where ID = "+ID, null);
        return res;
    }

    public void insertComplaint(ContentValues complaintDetails) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("complaint_details",null,complaintDetails);
    }

    public Cursor getComplaintDetails(int complaint_id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from complaint_details where Complaint_ID = "+complaint_id, null);
        return res;
    }

    public Cursor getComplaintsByUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from complaint_details where USER_ID = "+id, null);
        return res;
    }

    public void updateUserInfo(ContentValues userInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("user_info",userInfo," ID = "+CommonUtility.id,null);
    }
}
