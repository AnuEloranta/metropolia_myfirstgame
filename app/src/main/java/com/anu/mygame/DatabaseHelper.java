package com.anu.mygame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashMap;

/**
 * Created by Anu on 8.5.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "leaderboard";
    public static final String TABLE_NAME = "leader_table";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_SCORE = "score";




    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(25), SCORE INTEGER)");
        Log.d("own_error", "database created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        Log.d("own_error", "database dropped");
        onCreate(db);
    }


    public boolean insertData(String name, int score){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues con = new ContentValues();
        con.put(KEY_NAME, name);
        con.put(KEY_SCORE, score);
        long result = db.insert(TABLE_NAME, null, con);
        if (result== -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData(){


        SQLiteDatabase db = this.getWritableDatabase();
        final String orderBy = KEY_SCORE + " DESC";
        final String limit="10";
        final String[] columns = {KEY_NAME, KEY_SCORE};
        Cursor res = db.query(TABLE_NAME, columns, null, null, null, null, orderBy, limit);
        return res;
    }
}
