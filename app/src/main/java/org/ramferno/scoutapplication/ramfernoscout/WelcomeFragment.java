package org.ramferno.scoutapplication.ramfernoscout;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
        // Required empty public constructor
    } //End of WelcomeFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        // Inflate the layout for this fragment
        return rootView;
    } //End of onCreateView
} //End of class
