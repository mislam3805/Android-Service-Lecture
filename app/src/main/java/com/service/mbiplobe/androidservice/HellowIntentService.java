package com.service.mbiplobe.androidservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

/**
 * Created by mbiplobe on 6/6/2015.
 */
public class HellowIntentService extends IntentService
{

////    /**
//     * Creates an IntentService.  Invoked by your subclass's constructor.
//     *
//     * @param name Used to name the worker thread, important only for debugging.
//     */
    public HellowIntentService() {
        super("hellow Intent Service");
    }


    public class HellowHandler extends  Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(getApplicationContext(),"This is my IntentService",Toast.LENGTH_SHORT).show();
        }
    }
//    Handler handler=new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//
//            Toast.makeText(getApplicationContext(),"This is my IntentService",Toast.LENGTH_SHORT).show();
//        }
//    };

    @Override
    protected void onHandleIntent(Intent intent) {
        Runnable run=new Runnable() {
            @Override
            public void run() {
                long endingTime=System.currentTimeMillis()+1000;

                while (endingTime>System.currentTimeMillis()){
                    synchronized (this){
                        try{
                            wait(endingTime-System.currentTimeMillis());
                        }catch (Exception e){}
                    }
                }
            }
        };

        Thread thread=new Thread(run);
        thread.start();

        Toast.makeText(getApplicationContext(),"Hellow",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"Service is created",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(getApplicationContext(),"Service is started",Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"This Service will be destroyed",Toast.LENGTH_SHORT).show();
    }
}
