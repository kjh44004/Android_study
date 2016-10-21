package com.example.user.apisearch;

import android.os.AsyncTask;
import android.speech.tts.Voice;

/**
 * Created by User on 2016-10-21.
 */

public class ApiAsyncTask<T> extends AsyncTask <Void, Void, T> {
    private final String url;
    private final Class<T> classofT;
    private final ApiTaskCallback<T> runnable;

    public ApiAsyncTask(String url, Class<T> classofT, ApiTaskCallback<T> runnable) {   /*주소가 있어야지*/
        this.url = url;                 /*this = 객체 자기 자신*/
        this.classofT = classofT;
        this.runnable = runnable;
    }

    @Override
    protected T doInBackground(Void... params) {
        return new ApiConnector().get(url, classofT);
    }

    @Override
    protected void onPostExecute(T t) {
        runnable.run(t);
        super.onPostExecute(t);
    }
}
