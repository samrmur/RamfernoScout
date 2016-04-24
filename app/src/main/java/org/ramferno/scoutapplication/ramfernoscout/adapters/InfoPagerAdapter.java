package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class InfoPagerAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> fragments = new ArrayList<>();
    ArrayList<String> tabTitles = new ArrayList<>();

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
