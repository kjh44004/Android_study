package com.example.user.apisearch;

import android.os.AsyncTask;
import android.speech.tts.Voice;

/**
 * Created by User on 2016-10-21.
 */

public class ApiAsyncTask<T> extends AsyncTask<Void, Void, T>  {
    private final String url;
    private final Class<T> classOfT;
    private final ApiTaskCallback<T> runnable;

    public ApiAsyncTask(String url, Class<T> classOfT, ApiTaskCallback runnable) {
        this.url = url;
        this.classOfT = classOfT;
        this.runnable = runnable;
    }

    @Override
    protected T doInBackground(Void... params) {
        return new ApiConnector().get(url, classOfT);
    }

    @Override
    protected void onPostExecute(T t) {
        runnable.run(t);
        super.onPostExecute(t);
    }
}
