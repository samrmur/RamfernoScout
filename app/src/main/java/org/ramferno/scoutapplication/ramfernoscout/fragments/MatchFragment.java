/**
 * NAME: Samer Alabi
 * CLASS: MatchFragment
 * LAST EDITED: November 11th, 2016
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

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.downloaders.MatchDownloader;
import org.ramferno.scoutapplication.ramfernoscout.providers.AddressProvider;

//Start of MatchFragment
public class MatchFragment extends Fragment {
    //Declare Android UI objects
    FloatingActionButton addDataMatch, refreshData;
    ListView eListMatchInfo;

    public MatchFragment() {
        // Required empty public constructor
    } //End of MatchFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Declare and initialize objects
        View view = inflater.inflate(R.layout.fragment_match, container, false);  //View object
        eListMatchInfo = (ListView) view.findViewById(R.id.listMatchInfo);  //ListView object

        //Add instructions to the Refresh FAB that will download the data from the database server
        refreshData = (FloatingActionButton) view.findViewById(R.id.fabRefreshMatch);
        refreshData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                String urlAddress = "http://" + ipAddress +
                        "/ramfernoscout/database/matchretrieve.php";

                //Download data
                MatchDownloader d = new MatchDownloader(getActivity(),urlAddress,eListMatchInfo);
                d.execute();
            } //End of onClick
        }); //End  of setOnClickListener

        //Change fragment to AddMatchDataFragment with animations
        addDataMatch = (FloatingActionButton) view.findViewById(R.id.fabMatch);
        addDataMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddMatchDataFragment fragment = new AddMatchDataFragment();
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
} //End of class