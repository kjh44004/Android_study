package com.example.user.sqlitestudy;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private final static String DB_NAME = "st_file.db";
    private final static int DB_VERSION = 1;                //DB 버전
    String tag = "SQLLite";                                     //log에 사용할 tag
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = SQLiteHelper.getWritableDatabase(this, DB_NAME, DB_VERSION);


        insert(); // insert 문 - 삽입추가

        select(); // select 문 - 조회

        update(); // update 문 - 수정변경

        delete(); // delete 문 - 삭제 행제거

        select();
    }

    void delete() {
        db.execSQL("delete from mytable where id=2;");
        Log.d(tag, "delete 완료");
    }

    void update() {
        db.execSQL("update mytable set name='Park' where id=5;");
        Log.d(tag, "update 완료");
    }

    void select() {
        Cursor c = db.rawQuery("select * from mytable;", null);
        while (c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            Log.d(tag, "id:" + id + ",name:" + name);
        }
        c.close();
    }

    void insert() {
        db.execSQL("insert into mytable (name) values('Seo');");
        db.execSQL("insert into mytable (name) values('Choi');");
        db.execSQL("insert into mytable (name) values('Park');");
        db.execSQL("insert into mytable (name) values('Heo');");
        db.execSQL("insert into mytable (name) values('Kim');");
        Log.d(tag, "insert 성공~!");
    }
}
