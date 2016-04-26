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
import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContract;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelper;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProvider;

import java.util.ArrayList;
import java.util.List;

public class ListScoutInfoAdapter extends ArrayAdapter {
    //Declares and instantiates objects
    List list = new ArrayList();
    DatabaseHelper databaseHelper = new DatabaseHelper(getContext());

    public ListScoutInfoAdapter (Context context, int resource) {
        super(context, resource);
    } //End of ListDataScoutInfoAdapter

    static class LayoutHandler {
        //Declares all TextView objects
        TextView TEAM_NUMBER, PORTCULLIS, CHEVAL_FRISE, MOAT, RAMPARTS, DRAWBRIDGE, SALLY_PORT, ROCK_WALL, ROCK_TERRAIN, LOW_BAR, AUTO_HIGH, AUTO_LOW,
                TELE_HIGH, TELE_LOW, TELE_PLAY, HANG;
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
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        //Deletes a row
        db.delete(DatabaseContract.NewDataInfo.TABLE_NAME,
                DatabaseContract.NewDataInfo.COL_NUMBER + "=?",
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
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);

            //Instantiates layout handler
            layoutHandler = new LayoutHandler();

            //Inflates row with TextView data entered by the user
            layoutHandler.TEAM_NUMBER = (TextView) row.findViewById(R.id.resultTeamNumber);
            layoutHandler.PORTCULLIS = (TextView) row.findViewById(R.id.resultPortcullis);
            layoutHandler.CHEVAL_FRISE = (TextView) row.findViewById(R.id.resultChevalFrise);
            layoutHandler.MOAT = (TextView) row.findViewById(R.id.resultMoat);
            layoutHandler.RAMPARTS = (TextView) row.findViewById(R.id.resultRamparts);
            layoutHandler.DRAWBRIDGE = (TextView) row.findViewById(R.id.resultDrawbridge);
            layoutHandler.SALLY_PORT = (TextView) row.findViewById(R.id.resultSallyPort);
            layoutHandler.ROCK_WALL = (TextView) row.findViewById(R.id.resultRockWall);
            layoutHandler.ROCK_TERRAIN = (TextView) row.findViewById(R.id.resultRockTerrain);
            layoutHandler.LOW_BAR = (TextView) row.findViewById(R.id.resultLowBar);
            layoutHandler.AUTO_HIGH = (TextView) row.findViewById(R.id.resultHighGoalAuto);
            layoutHandler.AUTO_LOW = (TextView) row.findViewById(R.id.resultLowGoalAuto);
            layoutHandler.TELE_HIGH = (TextView) row.findViewById(R.id.resultHighGoal);
            layoutHandler.TELE_LOW = (TextView) row.findViewById(R.id.resultLowGoal);
            layoutHandler.TELE_PLAY = (TextView) row.findViewById(R.id.resultOffDef);
            layoutHandler.HANG = (TextView) row.findViewById(R.id.resultHang);

            //Sets layout handler tag on row so that row can remember the data inserted by the user
            row.setTag(layoutHandler);
        }
        else {
            //Gets tag from row and implements it into the layout handler if row has data
            layoutHandler = (LayoutHandler) row.getTag();
        } //End of if statement
        final DatabaseProvider databaseProvider = (DatabaseProvider) this.getItem(position);

        //Sets the text of the layout handler strings through the database provider
        layoutHandler.TEAM_NUMBER.setText(databaseProvider.getTeamNumber());
        layoutHandler.PORTCULLIS.setText(databaseProvider.getPortcullis());
        layoutHandler.CHEVAL_FRISE.setText(databaseProvider.getChevalFrise());
        layoutHandler.MOAT.setText(databaseProvider.getMoat());
        layoutHandler.RAMPARTS.setText(databaseProvider.getRamparts());
        layoutHandler.DRAWBRIDGE.setText(databaseProvider.getDrawbridge());
        layoutHandler.SALLY_PORT.setText(databaseProvider.getSallyPort());
        layoutHandler.ROCK_WALL.setText(databaseProvider.getRockWall());
        layoutHandler.ROCK_TERRAIN.setText(databaseProvider.getRockTerrain());
        layoutHandler.LOW_BAR.setText(databaseProvider.getLowBar());
        layoutHandler.AUTO_HIGH.setText(databaseProvider.getAutoHigh());
        layoutHandler.AUTO_LOW.setText(databaseProvider.getAutoLow());
        layoutHandler.TELE_HIGH.setText(databaseProvider.getTeleHigh());
        layoutHandler.TELE_LOW.setText(databaseProvider.getTeleLow());
        layoutHandler.TELE_PLAY.setText(databaseProvider.getTelePlay());
        layoutHandler.HANG.setText(databaseProvider.getHang());

        //Declares and instantiates delete button
        Button deleteBtn = (Button) row.findViewById(R.id.buttonDelete);

        //Adds TeamNumber tag to the button to enable the row to be deleted
        deleteBtn.setTag(databaseProvider.getTeamNumber());

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
} //End of class
