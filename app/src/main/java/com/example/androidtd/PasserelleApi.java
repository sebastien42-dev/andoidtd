package com.example.androidtd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class PasserelleApi extends Service {
    public PasserelleApi() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}