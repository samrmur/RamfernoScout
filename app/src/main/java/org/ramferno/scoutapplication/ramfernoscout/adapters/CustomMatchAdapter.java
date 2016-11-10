/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemy on 5/15/2016 for ProgrammingWizards Channel and Camposha.com
 * CLASS: CustomMatchAdapter
 * LAST EDITED: November 7th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class will put all downloaded and parsed data from the database server into their
 * respective TextView objects.
 */

//Import packages and classes
package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.MatchProvider;

import java.util.ArrayList;

//Start of CustomMatchAdapter
public class CustomMatchAdapter extends BaseAdapter {
    //Declare and initialize objects
    Context c;
    private ArrayList<MatchProvider> matchProvider;
    private LayoutInflater inflater;

    public CustomMatchAdapter(Context c, ArrayList<MatchProvider> matchProvider) {
        this.c = c;
        this.matchProvider = matchProvider;

        //Initialize inflater
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    } //End of CustomScoutAdapter

    @Override
    public int getCount() {
        return matchProvider.size();
    } //End of getCount

    @Override
    public Object getItem(int position) {
        return matchProvider.get(position);
    } //End of getItem

    @Override
    public long getItemId(int position) {
        return matchProvider.get(position).getId();
    } //End of getItemId

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_layout_match,parent,false);
        } //End of if statement

        //Declare and initialize all TextViewObjects with their corresponding xml objects
        TextView matchNumberTxt = (TextView) convertView.findViewById(R.id.resultNumberMatch);
        TextView blueTeamOneTxt = (TextView) convertView.findViewById(R.id.resultBlueTeamOne);
        TextView blueTeamTwoTxt = (TextView) convertView.findViewById(R.id.resultBlueTeamTwo);
        TextView blueTeamThreeTxt = (TextView) convertView.findViewById(R.id.resultBlueTeamThree);
        TextView redTeamOneTxt = (TextView) convertView.findViewById(R.id.resultRedTeamOne);
        TextView redTeamTwoTxt = (TextView) convertView.findViewById(R.id.resultRedTeamTwo);
        TextView redTeamThreeTxt = (TextView) convertView.findViewById(R.id.resultRedTeamThree);
        TextView blueScoreTxt = (TextView) convertView.findViewById(R.id.resultBlueScore);
        TextView redScoreTxt = (TextView) convertView.findViewById(R.id.resultRedScore);

        //Get all values entered by user and set them as text for the TextView objects
        matchNumberTxt.setText(Integer.toString(matchProvider.get(position).getMatchNumber()));
        blueTeamOneTxt.setText(Integer.toString(matchProvider.get(position).getBlueTeamOne()));
        blueTeamTwoTxt.setText(Integer.toString(matchProvider.get(position).getBlueTeamTwo()));
        blueTeamThreeTxt.setText(Integer.toString(matchProvider.get(position).getBlueTeamThree()));
        redTeamOneTxt.setText(Integer.toString(matchProvider.get(position).getRedTeamOne()));
        redTeamTwoTxt.setText(Integer.toString(matchProvider.get(position).getRedTeamTwo()));
        redTeamThreeTxt.setText(Integer.toString(matchProvider.get(position).getRedTeamThree()));
        blueScoreTxt.setText(Integer.toString(matchProvider.get(position).getBlueScore()));
        redScoreTxt.setText(Integer.toString(matchProvider.get(position).getRedScore()));

        // Return view
        return convertView;
    } //End of getView
} //End of class
