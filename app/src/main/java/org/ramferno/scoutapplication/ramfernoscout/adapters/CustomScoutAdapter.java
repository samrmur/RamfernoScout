/**
 * NAME: Samer Alabi
 * ORIGINAL CREATOR: Oclemy on 5/15/2016 for ProgrammingWizards Channel and Camposha.com
 * CLASS: CustomScoutAdapter
 * LAST EDITED: November 5th, 2016
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
import org.ramferno.scoutapplication.ramfernoscout.providers.ScoutProvider;

import java.util.ArrayList;

//Start of CustomScoutAdapter
public class CustomScoutAdapter extends BaseAdapter {
    //Declare and initialize objects
    Context c;
    private ArrayList<ScoutProvider> scoutProvider;
    private LayoutInflater inflater;

    public CustomScoutAdapter(Context c, ArrayList<ScoutProvider> scoutProvider) {
        this.c = c;
        this.scoutProvider = scoutProvider;

        //Initialize inflater
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    } //End of CustomScoutAdapter

    @Override
    public int getCount() {
        return scoutProvider.size();
    } //End of getCount

    @Override
    public Object getItem(int position) {
        return scoutProvider.get(position);
    } //End of getItem

    @Override
    public long getItemId(int position) {
        return scoutProvider.get(position).getId();
    } //End of getItemId

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.row_layout,parent,false);
        } //End of if statement

        //Declare and initialize all TextViewObjects with their corresponding xml objects
        TextView teamNumberTxt = (TextView) convertView.findViewById(R.id.resultTeamNumber);
        TextView portcullisTxt = (TextView) convertView.findViewById(R.id.resultPortcullis);
        TextView chevalFriseTxt = (TextView) convertView.findViewById(R.id.resultChevalFrise);
        TextView moatTxt = (TextView) convertView.findViewById(R.id.resultMoat);
        TextView rampartsTxt = (TextView) convertView.findViewById(R.id.resultRamparts);
        TextView drawbridgeTxt = (TextView) convertView.findViewById(R.id.resultDrawbridge);
        TextView sallyPortTxt = (TextView) convertView.findViewById(R.id.resultSallyPort);
        TextView rockWallTxt = (TextView) convertView.findViewById(R.id.resultRockWall);
        TextView rockTerrainTxt = (TextView) convertView.findViewById(R.id.resultRockTerrain);
        TextView lowBarTxt = (TextView) convertView.findViewById(R.id.resultLowBar);
        TextView autoHighTxt = (TextView) convertView.findViewById(R.id.resultHighGoalAuto);
        TextView autoLowTxt = (TextView) convertView.findViewById(R.id.resultLowGoalAuto);
        TextView teleHighTxt = (TextView) convertView.findViewById(R.id.resultHighGoal);
        TextView teleLowTxt = (TextView) convertView.findViewById(R.id.resultLowGoal);
        TextView telePlayTxt = (TextView) convertView.findViewById(R.id.resultOffDef);
        TextView hangTxt = (TextView) convertView.findViewById(R.id.resultHang);

        //Get all values entered by user and set them as text for the TextView objects
        teamNumberTxt.setText(Integer.toString(scoutProvider.get(position).getTeamNumber()));
        portcullisTxt.setText(scoutProvider.get(position).getPortcullis());
        chevalFriseTxt.setText(scoutProvider.get(position).getChevalFrise());
        moatTxt.setText(scoutProvider.get(position).getMoat());
        rampartsTxt.setText(scoutProvider.get(position).getRamparts());
        drawbridgeTxt.setText(scoutProvider.get(position).getDrawbridge());
        sallyPortTxt.setText(scoutProvider.get(position).getSallyPort());
        rockWallTxt.setText(scoutProvider.get(position).getRockWall());
        rockTerrainTxt.setText(scoutProvider.get(position).getRockTerrain());
        lowBarTxt.setText(scoutProvider.get(position).getLowBar());
        autoHighTxt.setText(scoutProvider.get(position).getAutoHigh());
        autoLowTxt.setText(scoutProvider.get(position).getAutoLow());
        teleHighTxt.setText(scoutProvider.get(position).getTeleHigh());
        teleLowTxt.setText(scoutProvider.get(position).getTeleLow());
        telePlayTxt.setText(scoutProvider.get(position).getTelePlay());
        hangTxt.setText(scoutProvider.get(position).getHang());

        // Return view
        return convertView;
    } //End of getView
} //End of class