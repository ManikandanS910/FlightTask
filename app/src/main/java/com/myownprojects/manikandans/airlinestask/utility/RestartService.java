package com.myownprojects.manikandans.airlinestask.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by manikandans on 13/01/19.
 */

public class RestartService extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i("Broadcast Listened", "Service tried to stop");
        Toast.makeText(context, "Service restarted", Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(new Intent(context, TimerService.class));
        } else {
            context.startService(new Intent(context, TimerService.class));
        }

    }
}
