package com.service.mbiplobe.androidservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by mbiplobe on 6/6/2015.
 */
public class TestBoundService extends Service {
    private final IBinder mbinder=new LocalService();
    @Override
    public IBinder onBind(Intent intent) {
        return mbinder;
    }

    public class LocalService extends Binder{
        TestBoundService getService(){
            return  TestBoundService.this;
        }
    }

    public String getFirstString()
    {
        return "Hellow I am Shakib al hasan";
    }

    public String getSecondString()
    {
        return "Hellow I am Hafez";
    }
}
