package com.example.projectwithintents;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MyVocationalStudies2Activity extends MainMenu {

    // Do the same as MyVocationalStudiesActivity but using a BaseAdapter class
    private String[] DAM1r = {"LMSGI", "PRG", "BD", "SO", "FOL"};
    private String[] DAM2n = {"PMDM", "SGBD", "DI", "EIE", "SP" };

    private List<String> DAM1rList;
    ListView listView;
    BaseAdapter myVocationalStudiesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_vocational_studies2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DAM1rList = new ArrayList();

        DAM1rList.add("LMSGI");
        DAM1rList.add("PRG");
        DAM1rList.add("BD");

        listView =  findViewById(R.id.myListView);
        myVocationalStudiesAdapter = new MyVocationalStudiesAdapter(DAM1rList);
        listView.setAdapter(myVocationalStudiesAdapter);
    }

    public void showSelectedElements(View view) {



    }
}
