package org.ramferno.scoutapplication.ramfernoscout;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    FloatingActionButton addDataMatch;
    ListView eListMatchInfo;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelperMatch databaseHelperMatch;
    Cursor cursor;
    ListMatchInfoAdapter listMatchInfoAdapter;


    public MatchFragment() {
        // Required empty public constructor
    } //End of MatchFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, null, false);
        eListMatchInfo = (ListView) view.findViewById(R.id.listMatchInfo);
        listMatchInfoAdapter = new ListMatchInfoAdapter(getActivity().getApplicationContext(), R.layout.row_layout_match);
        eListMatchInfo.setAdapter(listMatchInfoAdapter);
        databaseHelperMatch = new DatabaseHelperMatch(getActivity().getApplicationContext());
        sqLiteDatabase = databaseHelperMatch.getReadableDatabase();
        cursor = databaseHelperMatch.getInformation(sqLiteDatabase);

        //Checks if information is available in cursor
        if(cursor.moveToFirst()){
            do {
                //Declare all strings
                final String matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne, redTeamTwo, redTeamThree, blueScore, redScore;

                //Get strings from cursor
                matchNumber = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_MATCH_NUMBER));
                blueTeamOne =  cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_ONE));
                blueTeamTwo = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_TWO));
                blueTeamThree = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_BLUE_TEAM_THREE));
                redTeamOne = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_ONE));
                redTeamTwo = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_TWO));
                redTeamThree = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_RED_TEAM_THREE));
                blueScore = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_BLUE_SCORE));
                redScore = cursor.getString(cursor.getColumnIndex(DatabaseContractMatch.NewDataInfo.COL_RED_SCORE));

                //Get methods from DatabaseProvider
                DatabaseProviderMatch databaseProviderMatch = new DatabaseProviderMatch(matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne,
                        redTeamTwo, redTeamThree, blueScore, redScore);

                //Pass objects to add method
                listMatchInfoAdapter.add(databaseProviderMatch);
                listMatchInfoAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        } //End of if statement

        //Setups Floating Action Button
        addDataMatch = (FloatingActionButton) view.findViewById(R.id.fabMatch);
        addDataMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddMatchDataFragment fragment = new AddMatchDataFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener
        return view;
    } //End of onCreateView
} //End of class
