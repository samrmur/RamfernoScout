package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.adapters.TabThreeListAdapter;
import org.ramferno.scoutapplication.ramfernoscout.providers.TeamInfoTabThreeProvider;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamInfoTabThreeFragment extends Fragment {
    public TeamInfoTabThreeFragment() {
        // Required empty public constructor
    } //End of TeamInfoTabThreeFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team_info_tab_three, container, false);

        ArrayList<TeamInfoTabThreeProvider> tabThreeResults = GetTabThreeResults();
        final ListView tabThreeListView = (ListView) view.findViewById(R.id.listArchiveTournies);
        tabThreeListView.setAdapter(new TabThreeListAdapter(getContext(), tabThreeResults));

        return view;
    } //End of onCreateVIew

    //Programmatically adds data to ListView without user assistance
    private ArrayList<TeamInfoTabThreeProvider> GetTabThreeResults(){
        ArrayList<TeamInfoTabThreeProvider> results = new ArrayList<TeamInfoTabThreeProvider>();

        //Adds first row of data
        TeamInfoTabThreeProvider info1 = new TeamInfoTabThreeProvider();
        info1.setTournamentName("Windsor Essex Great Lakes Regional");
        info1.setYear("2016");
        info1.setRank("52nd");
        info1.setRecord("1-8-0");
        results.add(info1);

        //Adds second row of data
        TeamInfoTabThreeProvider info2 = new TeamInfoTabThreeProvider();
        info2.setTournamentName("Windsor Essex Great Lakes Regional");
        info2.setYear("2015");
        info2.setRank("38th");
        info2.setRecord("4-6-0");
        results.add(info2);

        //Adds third row of data
        TeamInfoTabThreeProvider info3 = new TeamInfoTabThreeProvider();
        info3.setTournamentName("Waterloo Regional");
        info3.setYear("2014");
        info3.setRank("23rd");
        info3.setRecord("4-11-0");
        results.add(info3);

        //Adds forth row of data
        TeamInfoTabThreeProvider info4 = new TeamInfoTabThreeProvider();
        info4.setTournamentName("Newton Division");
        info4.setYear("2013");
        info4.setRank("70th");
        info4.setRecord("3-5-0");
        results.add(info4);

        //Adds fifth row of data
        TeamInfoTabThreeProvider info5 = new TeamInfoTabThreeProvider();
        info5.setTournamentName("Greater Toronto West Regional");
        info5.setYear("2013");
        info5.setRank("9th");
        info5.setRecord("8-5-0");
        results.add(info5);

        //Adds sixth row of data
        TeamInfoTabThreeProvider info6 = new TeamInfoTabThreeProvider();
        info6.setTournamentName("Waterloo Regional");
        info6.setYear("2013");
        info6.setRank("21st");
        info6.setRecord("9-10-0");
        results.add(info6);

        //Adds seventh row of data
        TeamInfoTabThreeProvider info7 = new TeamInfoTabThreeProvider();
        info7.setTournamentName("Waterloo Regional");
        info7.setYear("2012");
        info7.setRank("5th");
        info7.setRecord("7-4-0");
        results.add(info7);

        //Adds eighth row of data
        TeamInfoTabThreeProvider info8 = new TeamInfoTabThreeProvider();
        info8.setTournamentName("Archimedes Division");
        info8.setYear("2011");
        info8.setRank("82nd");
        info8.setRecord("3-7-0");
        results.add(info8);

        //Adds ninth row of data
        TeamInfoTabThreeProvider info9 = new TeamInfoTabThreeProvider();
        info9.setTournamentName("Waterloo Regional");
        info9.setYear("2011");
        info9.setRank("25th");
        info9.setRecord("9-8-0 ");
        results.add(info9);

        return results;
    } //End of GetTabThreeResults
} //End of class
