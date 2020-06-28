package com.example.studentmng;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import io.opencensus.common.ServerStatsFieldEnums;

public class DatabaseHelper extends SQLiteOpenHelper {
    /*public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME ="users_data";*/
    public static final String DATABASE_NAME="userss.db";
    public static final String TABLE_NAME="user_data";
    public static final String COL1 ="id";
    public static final String COL2 = " FIRSTNAME ";
    public static final String COL3 = "LASTNAME";
    public static final String COL4 ="FAVFOOD";
    public static final String COL5 = "NOTE";
    public static final String COL6 ="NOTECC";

    public  DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable= "CREATE TABLE "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "FIRSTNAME TEXT, LASTNAME TEXT, FAVFOOD TEXT, NOTE TEXT, NOTECC TEXT)";
        db.execSQL(createTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(String.format("DROP IF TABLE EXISTS  ", TABLE_NAME));
        onCreate(db);

    }
    public boolean addData(String fName, String lName , String fFood, String note){
        SQLiteDatabase db= this.getWritableDatabase();
       int Notef=(Integer.parseInt(lName)+Integer.parseInt(fFood)+Integer.parseInt(note));
        String val=String.valueOf(Notef);
        ContentValues contentValues= new ContentValues();
        contentValues.put(COL2 , fName);
        contentValues.put(COL3 , lName);
        contentValues.put(COL4 , fFood);
        contentValues.put(COL5 , note);
        contentValues.put(COL6,val);

        long result= db.insert(TABLE_NAME , null, contentValues);


        // if date as inserted incorrectly it will return -1
        if (result == -1){
            return false;

        }else {
            return  true;
        }


    }
  /*  public ArrayList<User> getAllUsers(){
        ArrayList<User> users= new ArrayList<>();
        String selectQuerry= "select * From "+TABLE_NAME;
        SQLiteDatabase DB= this.getReadableDatabase();
       Cursor cursor= DB.rawQuery(selectQuerry, null);
       if (cursor.moveToFirst()) {

           do {

               String name=cursor.getString(1);

           } while (cursor.moveToNext());
       }


        return  users;
    }*/



    // query for one weak repeats
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM "+ TABLE_NAME, null);
        return data;
    }

    /*public Cursor getItemProp(String name){
        SQLiteDatabase db= this.getReadableDatabase();
       String querry= " SELECT "+ COL1 +" FROM "+TABLE_NAME+" WHERE "+COL2+" = "+ name ;
       Cursor data = db.rawQuery(querry, null);
       return data;

    }*/


    // get user by id from database
    public User getUserbyId(int id){

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuerry= "SELECT * FROM "+TABLE_NAME +" WHERE ID = "+id;
        Cursor cursor=db.rawQuery(selectQuerry, null);
        User user= null;
        if (cursor.moveToNext()){
            int ID=cursor.getInt(cursor.getColumnIndex(COL1));
            int notecc=cursor.getInt(cursor.getColumnIndex(COL6));
            String name=cursor.getString(cursor.getColumnIndex(COL2));
            String test1=cursor.getString(cursor.getColumnIndex(COL3));
            String test2=cursor.getString(cursor.getColumnIndex(COL4));
            String presence=cursor.getString(cursor.getColumnIndex(COL5));

           // String ID=String.valueOf(id_user);

            user=new User(name,test1,test2,presence,String.valueOf(notecc));
            // IF IT DIDN'T WORK TRY TO PUT THE RESULT ALSO
        }


        return user;
    }

    public int getItemid(String name){

        SQLiteDatabase db= this.getWritableDatabase();
        String querry= " SELECT "+ COL1 +" FROM "+TABLE_NAME+" WHERE "+COL2+" = '" + name + " ' ";
        Cursor data = db.rawQuery(querry, null);
        int id=data.getInt(data.getColumnIndex(COL1));
        return id;
    }


}
