package se.miun.anba2205.dt031g.bathingsites;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A Fragment that displays the bathing sites.
 * @author Andreas Backman
 */
public class BathingSitesFragment extends Fragment {

    public BathingSitesFragment() {
        // Required empty constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bathing_sites, container, false);
    }
}