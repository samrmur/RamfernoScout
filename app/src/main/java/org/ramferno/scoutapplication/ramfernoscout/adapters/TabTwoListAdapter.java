/**
 * NAME: Samer Alabi
 * CLASS: TabTwoListAdapter
 * LAST EDITED: November 12th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will set the text for TextViews that are in ListView. The data inserted has been
 * entered programmatically.
 */

//Import required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.TeamInfoTabTwoProvider;

import java.util.ArrayList;

//Start of TabTwoListAdapter
public class TabTwoListAdapter extends BaseAdapter {
    //Declares objects
    private static ArrayList<TeamInfoTabTwoProvider> tabTwoArrayList;
    private LayoutInflater mInflater;

    public TabTwoListAdapter(Context context, ArrayList<TeamInfoTabTwoProvider> results) {
        //Instantiates objects
        tabTwoArrayList = results;
        mInflater = LayoutInflater.from(context);
    } //End of TabThreeListAdapter

    public int getCount() {
        return tabTwoArrayList.size();
    } //End of getItem

    public Object getItem(int position) {
        return tabTwoArrayList.get(position);
    } //End of getItem

    public long getItemId(int position) {
        return position;
    } //End of getItemId

    public View getView(int position, View convertView, ViewGroup parent) {
        //Declares ViewHolder object
        ViewHolder holder;

        //Checks if convertView is empty or not
        if (convertView == null) {
            //Inflates convertView with corresponding row layout
            convertView = mInflater.inflate(R.layout.row_layout_tab_two, parent);

            //Instantiates ViewHolder object
            holder = new ViewHolder();

            //Instantiates TextView objects from ViewHolder with corresponding xml objects
            holder.txtAchievementName = (TextView) convertView.findViewById
                    (R.id.textAchievementName);
            holder.txtTournament = (TextView) convertView.findViewById(R.id.textAchievementTourny);
            holder.txtYear = (TextView) convertView.findViewById(R.id.textAchievementYear);

            //Sets tag for convertView to remember
            convertView.setTag(holder);
        } else {
            //Gets the tag for the VIewHolder object that convertView has remembered
            holder = (ViewHolder) convertView.getTag();
        } //End of if statement
        //Sets text values for TextView objects by getting values from ArrayList in
        //TabInfoThreeProvider
        holder.txtAchievementName.setText(tabTwoArrayList.get(position).getAchievementName());
        holder.txtTournament.setText(tabTwoArrayList.get(position).getTournament());
        holder.txtYear.setText(tabTwoArrayList.get(position).getYear());

        //Returns convertView
        return convertView;
    } //End of getView

    private static class ViewHolder {
        //Declares TextView objects
        TextView txtAchievementName;
        TextView txtTournament;
        TextView txtYear;
    } //End of ViewHolder
} //End of class
