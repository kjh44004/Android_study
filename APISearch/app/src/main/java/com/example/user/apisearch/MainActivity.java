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
        AsyncTask<Void, Void, ListModel> asyncTask = new AsyncTask<Void, Void, ListModel>() {
            @Override
            protected ListModel doInBackground(Void... params) {
                ApiConnector apiConnector = new ApiConnector();
                return apiConnector.get("http://14.49.231.5/a.json", ListModel.class);
            }
            
            @Override
            protected void onPostExecute(ListModel jsonString) {
                /*method1(jsonString);
                method2(jsonString);*/
            }

            /*private void method1(String jsonString){
                *//*build.gradle에 compile 'com.google.code.gson:gson:2.7'를 추가해야함*//*
                *//*json을 자바 객체마냥 사용할수 있게 변경*//*
                Gson gson = new Gson();
                Type type = new TypeToken<Map<String, String>>(){}.getType();
                Map<String, String> o1 = gson.fromJson(jsonString, type); *//*gsonFromJson*//*

                Toast.makeText(MainActivity.this, o1.get("a"), Toast.LENGTH_LONG).show();
            }
            private void method2(String jsonString){
                Gson gson = new Gson();
                model o1 = gson.fromJson(jsonString, model.class);

                Toast.makeText(MainActivity.this, o1.a, Toast.LENGTH_SHORT).show();
            }*/
        };



        asyncTask.execute();
    }


}

