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

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamInfoFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    InfoPagerAdapter infoPagerAdapter;

    public TeamInfoFragment() {
        // Required empty public constructor
    } //End of TeamInfoFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team_info, container, false);

        //Initializes variables
        tabLayout = (TabLayout) view.findViewById(R.id.infoTabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.infoPager);

        //Adds tabs to viewPager
        infoPagerAdapter = new InfoPagerAdapter(getFragmentManager());
        infoPagerAdapter.addFragments(new TeamInfoTabOneFragment(), "Team Info");
        infoPagerAdapter.addFragments(new TeamInfoTabTwoFragment(), "Achievements");
        infoPagerAdapter.addFragments(new TeamInfoTabThreeFragment(), "Past Tournaments");

        //Sets adapter for viewPager then sets the same view pager for tabLayout
        viewPager.setAdapter(infoPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    } //End of onCreateView
} //End of class
