package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractMatch;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperMatch;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProviderMatch;

import java.util.ArrayList;
import java.util.List;

public class ListMatchInfoAdapter extends ArrayAdapter {
    //Declares Objects
    List list = new ArrayList();
    DatabaseHelperMatch databaseHelperMatch = new DatabaseHelperMatch(getContext());

    public ListMatchInfoAdapter (Context context, int resource) {
        super(context, resource);
    } //End of ListDataScoutInfoAdapter

    static class LayoutHandler {
        //Declares all TextView objects
        TextView MATCH_NUMBER, BLUE_TEAM_ONE, BLUE_TEAM_TWO, BLUE_TEAM_THREE, RED_TEAM_ONE, RED_TEAM_TWO, RED_TEAM_THREE, BLUE_SCORE, RED_SCORE;
    } //End of LayoutHandler

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    } //End of add

    @Override
    public int getCount() {
        return list.size();
    } //End of getCount

    @Override
    public Object getItem(int position) {
        return list.get(position);
    } //End of getItem

    //Deletes a row of data in the database
    public void deleteRow(String rowId){
        //Retrieves the database in writable form
        SQLiteDatabase db = databaseHelperMatch.getWritableDatabase();

        //Deletes a row
        db.delete(DatabaseContractMatch.NewDataInfo.TABLE_NAME,
                DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER + "=?",
                new String[] {String.valueOf(rowId)});
    } //End of deleteRow

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Declares Android objects
        View row = convertView;
        final LayoutHandler layoutHandler;

        //Checks to see if row is empty
        if (row == null){
            //Declares and instantiates LayoutInflater object
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Inflates the row view with the row layout using the layout inflater
            row = layoutInflater.inflate(R.layout.row_layout_match, parent, false);

            //Instantiates layout handler
            layoutHandler = new LayoutHandler();

            //Inflates row with TextView data entered by the user
            layoutHandler.MATCH_NUMBER = (TextView) row.findViewById(R.id.resultNumberMatch);
            layoutHandler.BLUE_TEAM_ONE = (TextView) row.findViewById(R.id.resultBlueTeamOne);
            layoutHandler.BLUE_TEAM_TWO = (TextView) row.findViewById(R.id.resultBlueTeamTwo);
            layoutHandler.BLUE_TEAM_THREE = (TextView) row.findViewById(R.id.resultBlueTeamThree);
            layoutHandler.RED_TEAM_ONE = (TextView) row.findViewById(R.id.resultRedTeamOne);
            layoutHandler.RED_TEAM_TWO = (TextView) row.findViewById(R.id.resultRedTeamTwo);
            layoutHandler.RED_TEAM_THREE = (TextView) row.findViewById(R.id.resultRedTeamThree);
            layoutHandler.BLUE_SCORE = (TextView) row.findViewById(R.id.resultBlueScore);
            layoutHandler.RED_SCORE = (TextView) row.findViewById(R.id.resultRedScore);

            //Sets layout handler tag on row so that row can remember the data inserted by the user
            row.setTag(layoutHandler);
        }
        else {
            //Gets tag from row and implements it into the layout handler if row has data
            layoutHandler = (LayoutHandler) row.getTag();
        } //End of if statement
        final DatabaseProviderMatch databaseProviderMatch = (DatabaseProviderMatch) this.getItem(position);
        layoutHandler.MATCH_NUMBER.setText(databaseProviderMatch.getMatchNumber());
        layoutHandler.BLUE_TEAM_ONE.setText(databaseProviderMatch.getBlueTeamOne());
        layoutHandler.BLUE_TEAM_TWO.setText(databaseProviderMatch.getBlueTeamTwo());
        layoutHandler.BLUE_TEAM_THREE.setText(databaseProviderMatch.getBlueTeamThree());
        layoutHandler.RED_TEAM_ONE.setText(databaseProviderMatch.getRedTeamOne());
        layoutHandler.RED_TEAM_TWO.setText(databaseProviderMatch.getRedTeamTwo());
        layoutHandler.RED_TEAM_THREE.setText(databaseProviderMatch.getRedTeamThree());
        layoutHandler.BLUE_SCORE.setText(databaseProviderMatch.getBlueScore());
        layoutHandler.RED_SCORE.setText(databaseProviderMatch.getRedScore());

        //Declares and instantiates delete button
        Button deleteBtn = (Button) row.findViewById(R.id.buttonDeleteMatch);

        //Adds TeamNumber tag to the button to enable the row to be deleted
        deleteBtn.setTag(databaseProviderMatch.getMatchNumber());

        //Creates event on button click
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRow((String) v.getTag());
                list.remove(position);
                notifyDataSetChanged();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns row
        return row;
    } //End of getView
} //End of ListMatchInfoAdapter
