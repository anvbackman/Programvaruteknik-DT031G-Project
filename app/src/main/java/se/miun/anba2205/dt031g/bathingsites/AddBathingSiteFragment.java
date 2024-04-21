package se.miun.anba2205.dt031g.bathingsites;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A Fragment for adding a bathing site.
 * Got help from https://www.geeksforgeeks.org/android-creating-a-ratingbar/ for the rating bar
 * @author Andreas Backman
 */
public class AddBathingSiteFragment extends Fragment {

    private EditText name;
    private EditText description;
    private EditText address;
    private EditText longitude;
    private EditText latitude;
    private RatingBar grade;
    private EditText temperature;
    private EditText date;


    public AddBathingSiteFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_bathing_site, container, false); // Inflate the layout for this fragment

        // Get the EditTexts and RatingBar
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        address = view.findViewById(R.id.address);
        longitude = view.findViewById(R.id.longitude);
        latitude = view.findViewById(R.id.latitude);
        grade = view.findViewById(R.id.grade);
        temperature = view.findViewById(R.id.temperature);
        date = view.findViewById(R.id.date);

        // Sets the date to the current date
        date.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
        // Enable the options menu
        setHasOptionsMenu(true);
        return view;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.add_bathing_site_menu, menu); // Inflate the menu
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_bar_clear) { // If the clear button is pressed, clear all fields
            clearInput();
            return true;
        } else if (id == R.id.action_bar_save) { // If the save button is pressed, validate the entry
            validateEntry();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void clearInput() { // Clear all fields
        name.setText("");
        description.setText("");
        address.setText("");
        longitude.setText("");
        latitude.setText("");
        grade.setRating(0);
        temperature.setText("");
        date.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date()));
    }

    private void validateEntry() {
        // Used to show error on all fields that are not filled in
        // Without this it only showed on the first field with an error
        boolean error = false;

        if (name.getText().toString().isEmpty()) { // If the name field is empty, show an error
            name.setError("Please provide a name");
            error = true;
        }

        if (address.getText().toString().isEmpty()) { // If the address field is empty, show an error
            if (longitude.getText().toString().isEmpty() || latitude.getText().toString().isEmpty()) { // If the longitude or latitude field is empty, show an error
                address.setError("Please provide an address or both longitude and latitude");
                error = true;
            } else {
                address.setError(null);
            }
        } else {
            address.setError(null);
        }

        if (longitude.getText().toString().isEmpty() && address.getText().toString().isEmpty()) { // If the longitude field is empty, show an error
            longitude.setError("Please provide a longitude");
            error = true;
        } else {
            longitude.setError(null);
        }

        if (latitude.getText().toString().isEmpty() && address.getText().toString().isEmpty()) { // If the latitude field is empty, show an error
            latitude.setError("Please provide a latitude");
            error = true;
        } else {
            latitude.setError(null);
        }

        if (!error) {
            // If validation passes, show the entered information
            String info = "Name: " + name.getText().toString() +
                    "\nDescription: " + description.getText().toString() +
                    "\nAddress: " + address.getText().toString() +
                    "\nLongitude: " + longitude.getText().toString() +
                    "\nLatitude: " + latitude.getText().toString() +
                    "\nGrade: " + grade.getRating() +
                    "\nTemperature: " + temperature.getText().toString() +
                    "\nDate: " + date.getText().toString();

            new AlertDialog.Builder(getActivity()) // Create a dialog with the entered information
                    .setTitle("Entered Information")
                    .setMessage(info)
                    .setPositiveButton(android.R.string.ok, null)
                    .show();
        }
    }
}