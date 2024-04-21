package se.miun.anba2205.dt031g.bathingsites;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;

/**
 * A custom view for displaying the amount of bathing sites.
 * @Author Andreas Backman
 */
public class BathingSitesView extends ConstraintLayout {

    private ImageView image;
    private TextView textView;


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
    }

    public void setAmountOfBathingSites(int amount) {
        String text = getContext().getString(R.string.bathing_sites, amount); // Get the string from the resources
        textView.setText(text); // Set the text
    }
}
