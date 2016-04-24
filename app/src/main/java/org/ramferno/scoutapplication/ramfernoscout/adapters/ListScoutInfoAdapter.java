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

    public void deleteRow(String rowId){
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete(DatabaseContract.NewDataInfo.TABLE_NAME,
                DatabaseContract.NewDataInfo.COL_NUMBER + "=?",
                new String[] {String.valueOf(rowId)});
    } //End of deleteRow

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final LayoutHandler layoutHandler;
        if (row == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
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
            row.setTag(layoutHandler);
        }
        else {
            layoutHandler = (LayoutHandler) row.getTag();
        } //End of if statement
        final DatabaseProvider databaseProvider = (DatabaseProvider) this.getItem(position);
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

        //Deletes ListView row
        Button deleteBtn = (Button) row.findViewById(R.id.buttonDelete);
        deleteBtn.setTag(databaseProvider.getTeamNumber());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRow((String) v.getTag());
                list.remove(position);
                notifyDataSetChanged();
            } //End of onClick
        }); //End of setOnClickListener

        return row;
    } //End of getView
} //End of class
