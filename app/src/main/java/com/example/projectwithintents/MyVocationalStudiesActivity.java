package com.example.projectwithintents;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyVocationalStudiesActivity extends MainMenu {

    private String[] DAM1r = {"LMSGI", "PRG", "BD", "SO", "FOL"};
    private String[] DAM2n = {"PMDM", "SGBD", "DI", "EIE", "SP" };
    private CheckBox [] subjects;

    private Integer myCourse;
    private  int mySubject;
    private static  ArrayList<String> mySelectedSubjects;

    private int RESULT_OK = 2; // The number that you decide

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vocational_studies);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mySelectedSubjects = new ArrayList<>();

        subjects = new CheckBox[5];
        subjects[0] = findViewById(R.id.checkBox1);
        subjects[1] = findViewById(R.id.checkBox2);
        subjects[2] = findViewById(R.id.checkBox3);
        subjects[3] = findViewById(R.id.checkBox4);
        subjects[4] = findViewById(R.id.checkBox5);

            // Getting information from MyIntentsActivity
        Bundle b = this.getIntent().getExtras();
        myCourse = b.getInt("Curs");
        // Selecting subjects from the course
        if (myCourse.equals(1)) { // 1rDAM
            for (int i=0; i < DAM1r.length; i++) {
                subjects[i].setText(DAM1r[i]);
            }
        }
        else { // 2nDAM
            for (int i=0; i < DAM1r.length; i++) {
                subjects[i].setText(DAM2n[i]);
            }
        }
    }

    public void displayToast (String text, Context myContext) {
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(myContext, text, duration);
        toast.show();
    }

    public void comeBack(View view) {
        // Adding the selected subjects
        for (int i=0; i < DAM1r.length; i++) {
            if (subjects[i].isChecked()) {
                mySelectedSubjects.add(subjects[i].getText().toString());
            }
        }
        showArrayList (mySelectedSubjects);
        // Creating the Intent
        Intent intent = new Intent(this, MyIntentsActivity.class);
        // Adding the information needed
        Bundle b = new Bundle();
        b.putSerializable("mySelectedSubjects", mySelectedSubjects);
        // Putting it into the Intent
        intent.putExtras(b);
        Log.d ("data", String.valueOf(intent.getData()));
        // To come back directly to IntentsActivity
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Starting the new activity
        setResult(RESULT_OK, intent);
        // 6.- Closing the activity: not needed yet
        finish();
    }

     public void showArrayList (ArrayList al) {
        for (int i = 0; i < al.size(); i++) {
            Log.d ("al", "Element " + i + "= " + al.get(i));
        }
    }


}
