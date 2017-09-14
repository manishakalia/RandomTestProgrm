package com.webviewapplication.main;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.Timer;
import java.util.TimerTask;

import static com.webviewapplication.main.MainActivity.RANDOMNUMNER;

/**
 * Created by Dell on 9/13/2017.
 */

public class MyService extends Service {

    Handler handler;
    Runnable runnable;
    int delay=1000;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        RANDOMNUMNER++;
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("RandomNumber",RANDOMNUMNER);
        edit.commit();

        final Timer myt = new Timer();
        myt.schedule(new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                try {
                    Intent intent= new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                } catch (Exception e) {
                    // TODO: handle exception
                }

                myt.cancel();
            }
        },1000);


       /* handler = new Handler();

        Runnable runnable = new Runnable(){

            @Override
            public void run() {
                // TODO Auto-generated method stub
                *//*YourMethod();*//*
                handler.postDelayed(this, 1000); // 1000 - Milliseconds
            }
        };


       *//* runnable = new Runnable() {
            @Override
            public void run() {
                //   handler
                *//**//*PackageManager pm = getApplicationContext().getPackageManager();
                Intent intent = pm.getLaunchIntentForPackage("com.webviewapplication.main");
                sendBroadcast(intent);*//**//*
               *//**//* handler.postDelayed(this,1000);*//**//*
            *//**//*    Toast.makeText(getApplicationContext(),"Restarting ",Toast.LENGTH_LONG).show();
                BroadcastReceive broadcastReceive = new BroadcastReceive();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.ACTION_RUN");
                registerReceiver(broadcastReceive,intentFilter);
                //run();
                //startActivity(intent);

               *//**//**//**//* Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);*//**//*
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(runnable,2000);
*/

    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {

      /*  handler.postDelayed(runnable, 1000);*/
       /* handler  = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

           *//*     *//**//*Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);*//**//*
                BroadcastReceive broadcastReceive = new BroadcastReceive();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.ACTION_RUN");
                registerReceiver(broadcastReceive,intentFilter);
                //  handler.postDelayed(this,delay);*//*
            }
        },delay);*/

        return START_STICKY;
    }

    @Override
    public void onStart(Intent intent, int startId) {

        super.onStart(intent, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
