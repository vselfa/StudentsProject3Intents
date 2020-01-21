package com.example.projectwithintents;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MyVocationalStudiesAdapter extends BaseAdapter {
    List<String> myVocationalCourses;
    // Constructor to get different lists
    MyVocationalStudiesAdapter (List<String> myCourses) {
        myVocationalCourses = myCourses;
    }
    @Override
    public int getCount() {
        return myVocationalCourses.size();
    }
    @Override
    public Object getItem(int i) {
        return myVocationalCourses.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // The view doesn't exist yet
        if (view == null) {
            Context context = viewGroup.getContext();
            // Creating a linear layout to show CheckBoxes and courses
            LinearLayout myLinearLayoutView = new LinearLayout(context);
            myLinearLayoutView.setOrientation(LinearLayout.HORIZONTAL);
            // Adding the CheckBox element
            CheckBox checkBox = new CheckBox(context);
            myLinearLayoutView.addView(checkBox);
            // The name of the course
            TextView nameTextView = new TextView(context);
            nameTextView.setText(myVocationalCourses.get(i));
            nameTextView.setPadding(0, 0, 10, 0);
            // Adding the name of the course
            myLinearLayoutView.addView(nameTextView);
            // Returning the created view
            return myLinearLayoutView;
        }
        // The view already exist
        return view;
    }
}
