package com.example.projectwithintents;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyServicesActivity extends MainMenu implements View.OnClickListener {

    LinearLayout myServicesLayout;
    // Button objects
    private Button buttonStart, buttonStop;
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_services);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //getting buttons from xml
        buttonStart = findViewById(R.id.buttonStart);
        buttonStop =  findViewById(R.id.buttonStop);

        //attaching onclicklistener to buttons
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

        // The layout to change the color
        myServicesLayout = findViewById(R.id.layoutServices);
        myServicesLayout.setBackgroundColor(Color.BLUE);

        intent = new Intent("MyFirstBroadcast");
        bundle = new Bundle();
        bundle.putString("msg", "MyServicesActivity. Started broadcast service ..." + MainActivity.n++ + " times" );
        intent.putExtras(bundle);
        sendBroadcast(intent);

    }

    public void onClick(View view) {
        if (view == buttonStart) {
            // Starting service
            startService(new Intent(this, MyService.class));
            myServicesLayout.setBackgroundColor(Color.RED);
        } else if (view == buttonStop) {
            // Stopping service
            stopService(new Intent(this, MyService.class));
            myServicesLayout.setBackgroundColor(Color.BLUE);
        }

    }
}
