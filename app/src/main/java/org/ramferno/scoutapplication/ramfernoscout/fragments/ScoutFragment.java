/**
 * NAME: Samer Alabi
 * CLASS: ScoutFragment
 * LAST EDITED: November 15th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class contains a ListView that displays downloaded and parsed data from a database
 * server. The class contains two button instructions, one when pressed will download and parse
 * data and one when pressed that switches to a fragment where a user can enter data to be
 * added to a database server.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.ramferno.scoutapplication.ramfernoscout.downloaders.ScoutDownloader;
import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.AddressProvider;

//Start of ScoutFragment
public class ScoutFragment extends Fragment {
    //Declare Android UI objects
    FloatingActionButton addDataScout, refreshData;
    ListView eListScoutInfo;

    public ScoutFragment() {
        // Required empty public constructor
    } //End of ScoutFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Declare and initialize objects
        View view = inflater.inflate(R.layout.fragment_scout, container, false);  //View object
        eListScoutInfo = (ListView) view.findViewById(R.id.listScoutInfo);  //ListView object

        //Attempt to retrieve data on object creation
        getData();

        //Add instructions to the Refresh FAB that will download the data from the database server
        refreshData = (FloatingActionButton) view.findViewById(R.id.fabRefreshScout);
        refreshData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Attempt to retrieve data
                getData();
            } //End of onClick
        }); //End  of setOnClickListener

        //Change fragment to AddScoutDataFragment with animations
        addDataScout = (FloatingActionButton) view.findViewById(R.id.fabScout);
        addDataScout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddScoutDataFragment fragment = new AddScoutDataFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,
                        R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    //Retrieve data from database server and display on fragment's ListView
    public void getData() {
        //Declare and initialize variable
        String ipAddress;

        //Attempt to get IP Address from Provider
        try {
            ipAddress = AddressProvider.getInstance().getAddress();
        }
        catch (NullPointerException e) {
            ipAddress = "";
        } //End of try statement

        //Insert IP address into full URL address
        String urlAddress = "http://" + ipAddress + "/ramfernoscout/database/scoutretrieve.php";

        //Download data
        ScoutDownloader d = new ScoutDownloader(getActivity(),urlAddress,eListScoutInfo);
        d.execute();
    } //End of getData
} //End of class
