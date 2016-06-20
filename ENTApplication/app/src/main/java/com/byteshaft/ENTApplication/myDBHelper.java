package com.byteshaft.ENTApplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MIYEON on 2016-06-20.
 */
public class myDBHelper extends SQLiteOpenHelper {

    public myDBHelper(Context context) {
        super(context, "emergencyDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE emergencyTBL(starttime datetime, message char(20), number char(20), name char(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS emergencyTBL");
        onCreate(db);
    }
}