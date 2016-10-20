package com.example.user.apisearch;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import static com.example.user.apisearch.R.id.textview;

public class MainActivity extends AppCompatActivity {

    public TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);
        AsyncTask<Void, Void, String> asyncTask = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                return getUrlContents("http://14.49.231.5/a.json");
            }

            @Override
            protected void onPostExecute(String jsonString) {
                method1(jsonString);
                method2(jsonString);
            }

            private void method1(String jsonString){
                /*build.gradle에 compile 'com.google.code.gson:gson:2.7'를 추가해야함*/
                /*json을 자바 객체마냥 사용할수 있게 변경*/
                Gson gson = new Gson();
                Type type = new TypeToken<Map<String, String>>(){}.getType();
                Map<String, String> o1 = gson.fromJson(jsonString, type); /*gsonFromJson*/

                Toast.makeText(MainActivity.this, o1.get("a"), Toast.LENGTH_LONG).show();
            }
            private void method2(String jsonString){
                Gson gson = new Gson();
                model o1 = gson.fromJson(jsonString, model.class);

                Toast.makeText(MainActivity.this, o1.a, Toast.LENGTH_SHORT).show();
            }
        };



        asyncTask.execute();
    }

    private static String getUrlContents(String theUrl) {
        StringBuilder content = new StringBuilder();

        // many of these calls can throw exceptions, so i've just
        // wrapped them all in one try/catch statement.
        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}

