package com.example.myapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Tamil.db";
    private static final int DATABASE_VERSION = 1;
    SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users (id integer primary key autoincrement,name text,email text,username text,password text,llevel text)");
        db.execSQL("create table txt (id integer primary key autoincrement,name text,type text,question text,hint text)");
        db.execSQL("create table score (id integer primary key autoincrement,level1 integer default 0,level2 integer default 0, level3 integer default 0, total integer default 0)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists users");
        db.execSQL("drop table if exists txt");

    }

    public boolean insert(String name, String email, String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("username", username);
        contentValues.put("password", password);
        long ins = db.insert("users", null, contentValues);
        if (ins == -1) return false;
        else return true;
    }

    public boolean chkemail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where email=?", new String[]{email});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public boolean chkuname(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0) return false;
        else return true;
    }

    public boolean userpassword(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) return true;
        else return false;
    }

    public Cursor viewData() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from txt", null);

        return cursor;
    }

    public Cursor ViewData1() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 1 ", null);

        return cursor;
    }

    public Cursor ViewData2() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 2 ", null);

        return cursor;
    }

    public Cursor ViewData3() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 3 ", null);

        return cursor;
    }

    public Cursor ViewData4() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 4 ", null);

        return cursor;
    }

    public Cursor ViewData5() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 5 ", null);

        return cursor;
    }

    public Cursor ViewData11() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 14 ", null);

        return cursor;
    }

    public Cursor ViewData22() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 15 ", null);

        return cursor;
    }

    public Cursor ViewData33() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 16 ", null);

        return cursor;
    }

    public Cursor ViewData44() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 17 ", null);

        return cursor;
    }

    public Cursor ViewData55() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 18 ", null);

        return cursor;
    }

    public Cursor ViewData111() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 14 ", null);

        return cursor;
    }

    public Cursor ViewData222() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from txt where id = 16 ", null);

        return cursor;
    }

    public List<word> getAllQuestions() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='relation'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<word> getAllfruits() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='fruit'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<word> getAlldays() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='day'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<word> getAllmonths() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='month'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<word> getAllnum() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='numbers'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public List<word> getAllcolor() {
        List<word> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM txt where type='colour'", null);

        if (c.moveToFirst()) {
            do {
                word question = new word();
                question.setName(c.getString(1));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public Cursor getScore() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from txt", null);

        return cursor;
    }



    public Cursor getUserdetails(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[]{name});
        return cursor;
    }
    public ArrayList <word> getAllData(){
        ArrayList<word> arrayList=new ArrayList<>(  );
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select * from txt where type='sentence'",null );
        while (cursor.moveToNext()){
            String name=cursor.getString( 1 );
            String type=cursor.getString(2);
            String question=cursor.getString( 3 );
            String hint=cursor.getString(4);
            word word=new word( name,type,question,hint );
            arrayList.add( word );
        }
        return arrayList;
    }
    public boolean updateScore(int score, String id) {
        String scoreStr = String.valueOf(score);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("level1", scoreStr);
        // contentValues.put("id",id);
        long ins = db.update("score",contentValues,"id="+id,null);
        if (ins == -1) return false;
        else return true;

    }

    public boolean insertScore(int score,String id) {
        String scoreStr = String.valueOf(score);
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("level1", scoreStr);
        contentValues.put("id",id);
        long ins = db.insert("score", null, contentValues);
        if (ins == -1) return false;
        else return true;


    }



    public Cursor viewScore(String id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from score where id=?", new String[]{id});

        return cursor;
    }

    public Cursor viewHighScore() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from score", null);

        return cursor;

    }
    public Cursor getUser() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from users", null);

        return cursor;

    }




}