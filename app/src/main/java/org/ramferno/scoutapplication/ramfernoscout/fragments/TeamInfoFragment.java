/**
 * NAME: Samer Alabi
 * CLASS: TeamInfoFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class contains a TabLayout object which contains three tabs, one with buttons that links
 * to team-related web pages and two tabs with ListView objects that display the team's history
 * of competitions and awards won.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.ramferno.scoutapplication.ramfernoscout.adapters.InfoPagerAdapter;
import org.ramferno.scoutapplication.ramfernoscout.R;

//Start of TeamInfoFragment
public class TeamInfoFragment extends Fragment {
    //Declare Android UI objects
    TabLayout tabLayout;
    ViewPager viewPager;
    InfoPagerAdapter infoPagerAdapter;

    public TeamInfoFragment() {
        // Required empty public constructor
    } //End of TeamInfoFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_info, container, false);

        //Initialize variables
        tabLayout = (TabLayout) view.findViewById(R.id.infoTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.infoPager);

        //Add tabs to viewPager
        infoPagerAdapter = new InfoPagerAdapter(getFragmentManager());
        infoPagerAdapter.addFragments(new TeamInfoTabOneFragment(), "Team Info");
        infoPagerAdapter.addFragments(new TeamInfoTabTwoFragment(), "Achievements");
        infoPagerAdapter.addFragments(new TeamInfoTabThreeFragment(), "Past Tournaments");

        //Set adapter for viewPager
        viewPager.setAdapter(infoPagerAdapter);

        //Setup Tab Layout with View Pager
        tabLayout.setupWithViewPager(viewPager);

        //Returns view
        return view;
    } //End of onCreateView
} //End of class
