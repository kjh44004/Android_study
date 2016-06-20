package com.byteshaft.ENTApplication;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OverlayDialog extends Activity implements Button.OnClickListener {

    myDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    MainActivity main;

    static OverlayDialog self = null;
    String incomingAddress;
    Button cancelButton;

    static void closeDialog() {
        if (isActivityRunning()) {
            closeActivity();
        }
    }

    static boolean isActivityRunning() {
        return self != null;
    }

    private static void closeActivity() {
        self.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overlay_dialog);

        self = this;
        TextView incomingMessageLabel = (TextView) findViewById(R.id.tv);
        TextView contactAddress = (TextView) findViewById(R.id.incomingNumber);
        cancelButton = (Button) findViewById(R.id.bCancel);
        cancelButton.setOnClickListener(this);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String message = extras.getString("message");
        String name = extras.getString("name");
        incomingAddress = extras.getString("number");

        incomingMessageLabel.setText(message);

        if (name == null) {
            contactAddress.setText(incomingAddress);

            SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
            int soundId = soundPool.load(this, R.raw.dingdong, 1);
            soundPool.play(soundId, 1, 1, 0, 0, 1);
        } else {
            contactAddress.setText(name);

            SoundPool soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
            int soundId = soundPool.load(this, R.raw.dingdong, 1);
            soundPool.play(soundId, 1, 1, 0, 0, 1);
        }
        myDBHelper = new myDBHelper(this);
        sqlDB = myDBHelper.getWritableDatabase(); //DB를 쓰기용 데이터 베이스로 열기
        sqlDB.execSQL("INSERT INTO emergencyTBL VALUES (datetime(), '"+message+"', '"+incomingAddress+"', '"+name+"');");
        sqlDB.close();
    }

    @Override
    protected void onStop() {
        super.onStop();
        self = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bCancel:
                finish();
                break;
        }
    }
}
