/**
 * NAME: Samer Alabi
 * CLASS: InfoPagerAdapter
 * LAST EDITED: November 12th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will contains the array lists of the tab fragments and their titles for the tab
 * layout displayed in the team info fragment
 */

//Import required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

//Start of InfoPagerAdapter
public class InfoPagerAdapter extends FragmentStatePagerAdapter {
    //Declare and instantiate objects
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabTitles = new ArrayList<>();

    public void addFragments(Fragment fragments, String titles) {
        this.fragments.add(fragments);
        this.tabTitles.add(titles);
    } //End of addFragments

    public InfoPagerAdapter(FragmentManager fm) {
        super(fm);
    } //End of InfoPagerAdapter

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    } //End of getItem

    @Override
    public int getCount() {
        return fragments.size();
    } //Edn of getCount

    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    } //End of getPageTitle
} //End of class
