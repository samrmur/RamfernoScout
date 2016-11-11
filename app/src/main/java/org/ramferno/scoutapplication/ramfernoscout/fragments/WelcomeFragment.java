/**
 * NAME: Samer Alabi
 * CLASS: WelcomeFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class a fragment which simply creates the view of the first fragment displayed on the
 * app.
 */

//Import required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ramferno.scoutapplication.ramfernoscout.R;

//Start of WelcomeFragment
public class WelcomeFragment extends Fragment {
    public WelcomeFragment() {
        //Required empty public constructor
    } //End of WelcomeFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);

        //Return rootView
        return rootView;
    } //End of onCreateView
} //End of class