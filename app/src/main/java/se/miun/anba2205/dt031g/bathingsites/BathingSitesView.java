package se.miun.anba2205.dt031g.bathingsites;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * A custom view for displaying the amount of bathing sites.
 * @Author Andreas Backman
 */
public class BathingSitesView extends ConstraintLayout implements View.OnClickListener {

    private ImageView image;
    private TextView textView;
    private int counter = 0;
    private SharedPreferences sharedPreferences;


    public BathingSitesView(Context context) {
        super(context);
        init();
    }

    public BathingSitesView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BathingSitesView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.bathing_sites_view, this); // Inflate the layout
        image = findViewById(R.id.bathingSitesImageView); // Get the ImageView
        textView = findViewById(R.id.bathingSitesTextView); // Get the TextView
        setOnClickListener(this);

        sharedPreferences = getContext().getSharedPreferences("BathingSitesPrefs", Context.MODE_PRIVATE);
        counter = sharedPreferences.getInt("counter", 0); // Get the counter value from the SharedPreferences
        setAmountOfBathingSites(counter); // Update the TextView with the counter value
    }

    public void setAmountOfBathingSites(int amount) {
        String text = getContext().getString(R.string.bathing_sites, amount); // Get the string from the resources
        textView.setText(text); // Set the text
    }

    @Override
    public void onClick(View v) {
        counter++;
        SharedPreferences.Editor editor = sharedPreferences.edit(); // Get the editor
        editor.putInt("counter", counter); // Put the counter value in the SharedPreferences
        editor.apply();

        setAmountOfBathingSites(counter); // Update the TextView with the counter value
    }
}
