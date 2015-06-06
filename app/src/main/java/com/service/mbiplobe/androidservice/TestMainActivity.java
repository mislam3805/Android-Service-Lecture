package com.service.mbiplobe.androidservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by mbiplobe on 6/6/2015.
 */
public class TestMainActivity extends Activity {
    TestBoundService testBound;
    boolean isBound=false;
    private EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        editText= (EditText) findViewById(R.id.editText);
        Intent intent=new Intent(TestMainActivity.this,TestBoundService.class);
        bindService(intent,myServiceConnection, Context.BIND_AUTO_CREATE);
    }

    public ServiceConnection myServiceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            TestBoundService.LocalService service1= (TestBoundService.LocalService) service;
            testBound=service1.getService();
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound=false;
        }
    };

    @Override
    protected void onStop() {
        super.onStop();
        if (isBound){
            unbindService(myServiceConnection);
            isBound=false;
        }
    }

    public void firstMethod(View view){
        String message=testBound.getFirstString();
        editText.setText(message);
    }

    public void secondMethod(View view){
        String message=testBound.getSecondString();
        editText.setText(message);
    }
}
