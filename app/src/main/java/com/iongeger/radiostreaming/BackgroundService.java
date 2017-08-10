package com.iongeger.radiostreaming;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class BackgroundService extends Service {
    public BackgroundService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent i = new Intent(this,MainActivity.class);
        startService(i);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }
}
