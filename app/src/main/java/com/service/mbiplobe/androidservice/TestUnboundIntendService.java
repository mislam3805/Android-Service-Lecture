package com.service.mbiplobe.androidservice;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by mbiplobe on 6/5/2015.
 */
public class TestUnboundIntendService extends IntentService {
//    /**
//     * Creates an IntentService.  Invoked by your subclass's constructor.
//     *
//     * @param name Used to name the worker thread, important only for debugging.
//     */
    public TestUnboundIntendService() {
        super("Test IntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Toast.makeText(getApplicationContext(),"Message="+intent.getStringExtra("message1"),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(getApplicationContext(),"Service is Created",Toast.LENGTH_SHORT).show();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(getApplicationContext(),"Service is Started",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getApplicationContext(),"Service is destroyed",Toast.LENGTH_SHORT).show();
    }
}
