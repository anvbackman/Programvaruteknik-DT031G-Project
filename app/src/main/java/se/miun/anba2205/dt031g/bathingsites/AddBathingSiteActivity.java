package se.miun.anba2205.dt031g.bathingsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import java.util.Objects;

/**
 * Activity for adding a bathing site.
 * @Author Andreas Backman
 */
public class AddBathingSiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bathing_site);

        // Change of the color of the action bar
        ResourcesCompat.getColor(getResources(), R.color.action_bar, null);
        Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(ResourcesCompat.getColor(getResources(), R.color.action_bar, null)));

        if (findViewById(R.id.bathing_sites_fragment_container) != null) {
            // In landscape mode
            getSupportFragmentManager().beginTransaction() // Add BathingSitesFragment and AddBathingSiteFragment to the activity
                    .replace(R.id.bathing_sites_fragment_container, new BathingSitesFragment())
                    .replace(R.id.add_bathing_site_fragment_container, new AddBathingSiteFragment())
                    .commit();
        } else {
            // In portrait mode
            getSupportFragmentManager().beginTransaction() // Add AddBathingSiteFragment to the activity
                    .replace(R.id.add_bathing_site_fragment_container, new AddBathingSiteFragment())
                    .commit();
        }
    }
}