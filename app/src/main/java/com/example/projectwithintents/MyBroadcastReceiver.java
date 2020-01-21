package com.example.projectwithintents;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Log.d ("Send", "Received a broadcast");
        Bundle bundle = intent.getExtras();
        String msg = bundle.getString("msg");
        displayToast(msg, context);
    }

    public void displayToast (String text, Context context) {
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
