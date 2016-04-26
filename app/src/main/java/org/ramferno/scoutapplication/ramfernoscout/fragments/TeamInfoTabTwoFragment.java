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

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamInfoTabTwoFragment extends Fragment {
    public TeamInfoTabTwoFragment() {
        // Required empty public constructor
    } //End of TeamInfoTabOneFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflates the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_team_info_tab_two, container, false);

        //Gets ListView rows from GetTabTwoResults and adds them to an ArrayList connect to the TeamInfoTabTwoProvider class
        ArrayList<TeamInfoTabTwoProvider> tabTwoResults = GetTabTwoResults();

        //Instantiates ListView and declares xml object for ListView
        final ListView tabTwoListView = (ListView) view.findViewById(R.id.listArchivesAchievements);

        //Sets the adapter for the ListView and implements data from the tabTwoResults ArrayList into the adapter
        tabTwoListView.setAdapter(new TabTwoListAdapter(getContext(), tabTwoResults));

        //Returns view
        return view;
    } //End of onCreateView

    //Programmatically adds data to ListView without user assistance
    private ArrayList<TeamInfoTabTwoProvider> GetTabTwoResults() {
        //Declares and instantiates object
        ArrayList<TeamInfoTabTwoProvider> results = new ArrayList<TeamInfoTabTwoProvider>();

        //Adds first row of data
        TeamInfoTabTwoProvider info1 = new TeamInfoTabTwoProvider();
        info1.setAchievementName("Gracious Professionalism Award");
        info1.setTournament("Windsor Essex GL Regional");
        info1.setYear("2015");
        results.add(info1);

        //Adds second row of data
        TeamInfoTabTwoProvider info2 = new TeamInfoTabTwoProvider();
        info2.setAchievementName("Judges Award");
        info2.setTournament("Waterloo Regional");
        info2.setYear("2014");
        results.add(info2);

        //Adds third row of data
        TeamInfoTabTwoProvider info3 = new TeamInfoTabTwoProvider();
        info3.setAchievementName("Regional Finalists");
        info3.setTournament("Waterloo Regional");
        info3.setYear("2013");
        results.add(info3);

        //Adds fourth row of data
        TeamInfoTabTwoProvider info4 = new TeamInfoTabTwoProvider();
        info4.setAchievementName("Rookie All Star Award");
        info4.setTournament("Waterloo Regional");
        info4.setYear("2011");
        results.add(info4);

        //Adds fifth row of data
        TeamInfoTabTwoProvider info5 = new TeamInfoTabTwoProvider();
        info5.setAchievementName("Regional Champions");
        info5.setTournament("Waterloo Regional");
        info5.setYear("2011");
        results.add(info5);

        //Returns results
        return results;
    } //End of GetTabTwoResults
} //End of class
