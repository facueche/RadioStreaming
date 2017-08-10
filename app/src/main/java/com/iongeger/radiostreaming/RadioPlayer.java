package com.iongeger.radiostreaming;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;


public class RadioPlayer /*implements MediaPlayer.OnErrorListener*/{

    private Context context;
    private static MediaPlayer mediaPlayer;

    public RadioPlayer(String url, Context context) {
        // TODO Auto-generated constructor stub
        this.context = context;
        playRadioStream ( url );
    }

    private void playRadioStream ( String url )
    {
        // Playing
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try{
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare(); // might take long! (for buffering, etc)
            mediaPlayer.start();
        }catch (Exception e){
            Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
        }

    }

    public void setStream(String url){
        stopPlaying();
        playRadioStream(url);
    }

    public void stopPlaying(){
        if(mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

/*    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(context,"Error",Toast.LENGTH_LONG).show();
        return false;
    }*/
}