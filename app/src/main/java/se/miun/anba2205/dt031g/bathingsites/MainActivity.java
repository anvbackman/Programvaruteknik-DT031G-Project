package se.miun.anba2205.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;

/**
 * The main activity of the app.
 * @Author Andreas Backman
 */
public class MainActivity extends AppCompatActivity {

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
}