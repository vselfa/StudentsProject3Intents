package com.example.projectwithintents;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyIntentsActivity extends MainMenu {

    private ListView myListView;  // To control the list
    final String[] lstInfo = new String[] {"1DAM","2DAM"};
    ListView lstSelectedOptions;
    ArrayList<String> mySelectedSubjects;
    Intent intent; Bundle bundle;

    final String[] mySelectedSubjectsAdapter = new String[5];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intents);
        // Tool bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Lists and adapters
        myListView = findViewById (R.id.lstOptions);
        lstSelectedOptions = findViewById(R.id.lstSelectedOptions);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>
                        (this, android.R.layout.simple_list_item_1, lstInfo);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                String text = (String) (myListView.getItemAtPosition(position));
                // The Intent
                Intent intent = new Intent(MyIntentsActivity.this, MyVocationalStudiesActivity.class);
                // Sending the selected element
                Bundle b = new Bundle();
                b.putInt("Curs", position+1);
                intent.putExtras(b);
                startActivityForResult (intent,1);
            }
        });

        intent = new Intent("MyFirstBroadcast");
        bundle = new Bundle();
        bundle.putString("msg", "MyServicesActivity. Started broadcast service ..." + MainActivity.n++ + " times" );
        intent.putExtras(bundle);
        sendBroadcast(intent);

    }

    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent data)  {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2) {
            // Coming back from MyVocationalStudies
            // Getting the information received
            mySelectedSubjects = new ArrayList();
            mySelectedSubjects = data.getStringArrayListExtra("mySelectedSubjects");
            //showArrayList( mySelectedSubjects);

            ArrayAdapter<String> adapter = new ArrayAdapter<>
                            (this, android.R.layout.simple_list_item_1, mySelectedSubjects);
            lstSelectedOptions.setAdapter(adapter);
        }
    }

    public void showArrayList (ArrayList al) {
        for (int i = 0; i < al.size(); i++) {
            Log.d ("al", "Element " + i + "= " + al.get(i));
        }
    }
}