package com.example.projectwithintents;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenu extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Home) {
            Intent intent = new Intent (this, MainActivity.class);
            startActivity(intent);
        }
        if (id == R.id.Services) {
            Intent intent = new Intent (this, MyServicesActivity.class);
            startActivity(intent);
        }
        if (id == R.id.Intents) {
            Intent intent = new Intent (this, MyIntentsActivity.class);
            startActivity(intent);
        }
        // Checking the BaseAdapter
        if (id == R.id.Intents2) {
            Intent intent = new Intent (this, MyVocationalStudies2Activity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
