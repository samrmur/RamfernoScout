package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ramferno.scoutapplication.ramfernoscout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
        // Required empty public constructor
    } //End of WelcomeFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflates the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        //Returns rootView
        return rootView;
    } //End of onCreateView
} //End of class