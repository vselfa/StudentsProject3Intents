package com.example.projectwithintents;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends MainMenu {

    Intent intent;
    Bundle bundle;
    static int n = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Registering the receiver
        IntentFilter filter = new IntentFilter("MyFirstBroadcast");
        MyBroadcastReceiver receiver = new MyBroadcastReceiver();
        registerReceiver(receiver, filter);

        intent = new Intent("MyFirstBroadcast");
        bundle = new Bundle();
        bundle.putString("msg", "MainActivity. Started broadcast service ..." + n++ + " times" );
        intent.putExtras(bundle);
        sendBroadcast(intent);

    }




}
