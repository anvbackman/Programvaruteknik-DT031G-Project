package se.miun.anba2205.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;

/**
 * The main activity of the app.
 * @Author Andreas Backman
 */
public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Change of the color of the action bar
        ResourcesCompat.getColor(getResources(), R.color.action_bar, null);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.action_bar, null)));

        if (savedInstanceState == null) { // Add BathingSitesFragment to the activity
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new BathingSitesFragment())
                    .commit();
        }



        FloatingActionButton fab = findViewById(R.id.add_bathing_site_button); // Get the FloatingActionButton
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBathingSiteActivity.class); // Start AddBathingSiteActivity
                startActivity(intent);
            }
        });


//        BathingSitesFragment bathingSitesFragment = (BathingSitesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
//        if (bathingSitesFragment != null) {
//            BathingSitesView bathingSitesView = bathingSitesFragment.getBathingSitesView(); // Get the ImageView for the bathing sites image
//
//            bathingSitesView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    System.out.println("BathingSitesView clicked");
//                    int amount = updateBathingSiteCount(); // Update the amount of bathing sites// Get the BathingSitesView
//                    bathingSitesView.setAmountOfBathingSites(amount); // Set the amount of bathing sites
//                }
//            });
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu); // Inflate the menu
        return true;
    }

    // Decides where to navigate when menu item is used. Right now just a placeholder
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private int updateBathingSiteCount() {
        SharedPreferences prefs = getSharedPreferences("BathingSitesPrefs", MODE_PRIVATE); // Get the SharedPreferences
        int count = prefs.getInt("amount", 0); // Get the amount of bathing sites
        prefs.edit().putInt("amount", count + 1).apply(); // Increase the amount of bathing sites
        return count + 1;
    }
}