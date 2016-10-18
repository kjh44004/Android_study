package com.example.user.sqlitestudy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 2016-10-18.
 */
public class SQLiteHelper {
    public static SQLiteDatabase getWritableDatabase(Context context, String dbName, int currentDBVersion) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context, dbName, null, currentDBVersion);
        return helper.getWritableDatabase();
    }

    public static SQLiteDatabase getReadableDatabase(Context context, String dbName, int currentDBVersion) {
        MySQLiteOpenHelper helper = new MySQLiteOpenHelper(context, dbName, null, currentDBVersion);
        return helper.getReadableDatabase();
    }
}
