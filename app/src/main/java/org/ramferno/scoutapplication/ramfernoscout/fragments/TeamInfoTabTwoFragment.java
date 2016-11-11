/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoTabTwoFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class contains adds rows of data to a ListView programmatically without the help of a
 * user, then it displays that data.
 */

//Import required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.adapters.TabTwoListAdapter;
import org.ramferno.scoutapplication.ramfernoscout.providers.TeamInfoTabTwoProvider;

import java.util.ArrayList;

//Start of TeamInfoTabTwoFragment
public class TeamInfoTabTwoFragment extends Fragment {
    public TeamInfoTabTwoFragment() {
        // Required empty public constructor
    } //End of TeamInfoTabOneFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_team_info_tab_two, container, false);

        //Get ListView rows from GetTabTwoResults and add them to an ArrayList connect to the
        //TeamInfoTabTwoProvider class
        ArrayList<TeamInfoTabTwoProvider> tabTwoResults = GetTabTwoResults();

        //Declare ListView and connect it to corresponding xml object
        final ListView tabTwoListView = (ListView) view.findViewById(R.id.listArchivesAchievements);

        //Set the adapter for the ListView and implement data from the tabTwoResults ArrayList
        //into the adapter
        tabTwoListView.setAdapter(new TabTwoListAdapter(getContext(), tabTwoResults));

        //Return view
        return view;
    } //End of onCreateView

    //Programmatically add data to ListView without user assistance
    private ArrayList<TeamInfoTabTwoProvider> GetTabTwoResults() {
        //Declare and instantiate object
        ArrayList<TeamInfoTabTwoProvider> results = new ArrayList<TeamInfoTabTwoProvider>();

        //Add first row of data
        TeamInfoTabTwoProvider info1 = new TeamInfoTabTwoProvider();
        info1.setAchievementName("Gracious Professionalism Award");
        info1.setTournament("Windsor Essex GL Regional");
        info1.setYear("2015");
        results.add(info1);

        //Add second row of data
        TeamInfoTabTwoProvider info2 = new TeamInfoTabTwoProvider();
        info2.setAchievementName("Judges Award");
        info2.setTournament("Waterloo Regional");
        info2.setYear("2014");
        results.add(info2);

        //Add third row of data
        TeamInfoTabTwoProvider info3 = new TeamInfoTabTwoProvider();
        info3.setAchievementName("Regional Finalists");
        info3.setTournament("Waterloo Regional");
        info3.setYear("2013");
        results.add(info3);

        //Add fourth row of data
        TeamInfoTabTwoProvider info4 = new TeamInfoTabTwoProvider();
        info4.setAchievementName("Rookie All Star Award");
        info4.setTournament("Waterloo Regional");
        info4.setYear("2011");
        results.add(info4);

        //Add fifth row of data
        TeamInfoTabTwoProvider info5 = new TeamInfoTabTwoProvider();
        info5.setAchievementName("Regional Champions");
        info5.setTournament("Waterloo Regional");
        info5.setYear("2011");
        results.add(info5);

        //Return results
        return results;
    } //End of GetTabTwoResults
} //End of class
