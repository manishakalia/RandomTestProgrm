package com.webviewapplication.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Dell on 9/13/2017.
 */

public class BroadcastReceive extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service = new Intent(context,MainActivity.class);
      //  service.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(service);
    }
}
