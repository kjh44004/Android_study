package com.example.user.apisearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        new ApiAsyncTask<ListModel>("http://14.49.231.5/b.json", ListModel.class, new ApiTaskCallback<ListModel>() {
            @Override
            public void run(ListModel result) {
                Toast.makeText(MainActivity.this, result.list[0], Toast.LENGTH_LONG).show();
            }
        }).execute();
    }


}

