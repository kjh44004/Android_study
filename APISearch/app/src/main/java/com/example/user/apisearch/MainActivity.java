package com.example.user.apisearch;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        new ApiAsyncTask<ListModel>("http://14.49.231.5/a.json", ListModel.class, new ApiTaskCallback() {
            @Override
            public void run(Object result) {

            }
        }).execute();
    }


}

