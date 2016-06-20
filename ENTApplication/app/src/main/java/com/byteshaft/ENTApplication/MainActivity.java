package com.byteshaft.ENTApplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;


public class MainActivity extends ActionBarActivity implements Switch.OnCheckedChangeListener{

    private Helpers mHelpers = null;
    private Switch mPopupDialog = null;

    Button btnInit, btnRefresh;

    private ListView m_Listview = null;
    private ArrayAdapter<String> m_Adapter = null;

    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        btnInit = (Button) findViewById(R.id.btnInit);
        btnRefresh = (Button) findViewById(R.id.btnRefresh);
        mPopupDialog = (Switch) findViewById(R.id.switch1);
        mPopupDialog.setOnCheckedChangeListener(this);
        mHelpers = new Helpers(this);

        myDBHelper = new myDBHelper(this);

        m_Adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        m_Listview = (ListView)findViewById(R.id.listview);
        m_Listview.setAdapter(m_Adapter);

        sqlDB = myDBHelper.getReadableDatabase();
        Cursor cursor = sqlDB.rawQuery("SELECT * FROM emergencyTBL;", null);

        while (cursor.moveToNext()){
            m_Adapter.add(cursor.getString(0)+"|"+cursor.getString(1));
        }
        cursor.close();
        sqlDB.close();

        btnInit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sqlDB = myDBHelper.getWritableDatabase(); //DB를 쓰기용 데이터 베이스로 열기
                myDBHelper.onUpgrade(sqlDB, 1, 2);
                sqlDB.close();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mHelpers.isPopupEnabled()) {
            mPopupDialog.setChecked(true);
        } else {
            mPopupDialog.setChecked(false);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch1:
                if (isChecked) {
                    mHelpers.setPopupEnabled(true);
                } else {
                    mHelpers.setPopupEnabled(false);
                }
                break;
        }
    }
}
