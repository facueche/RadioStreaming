package com.iongeger.radiostreaming;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;

/**
 * Created by facu on 10/6/2016.
 */
public class RadioAsyncTask extends AsyncTask <Void, Integer, Void> {

    private String url;
    private Context context;
    private RadioPlayer radioPlayer;
    private MediaPlayer mediaPlayer;

    public RadioAsyncTask(String url, Context context){
        this.url = url;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        radioPlayer = new RadioPlayer(url, context);
        mediaPlayer = radioPlayer.getMediaPlayer();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    public RadioPlayer getRadioPlayer() {
        return radioPlayer;
    }
}
