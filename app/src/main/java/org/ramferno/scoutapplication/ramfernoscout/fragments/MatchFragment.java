package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractMatch;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperMatch;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProviderMatch;
import org.ramferno.scoutapplication.ramfernoscout.adapters.ListMatchInfoAdapter;
import org.ramferno.scoutapplication.ramfernoscout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    //Android UI & Database objects
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
        //Inflates layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match, container, false);

        //Instantiates ListView object with the xml ListView object
        eListMatchInfo = (ListView) view.findViewById(R.id.listMatchInfo);

        //Instantiates ArrayAdapter with Application Context and inflates with row layout
        listMatchInfoAdapter = new ListMatchInfoAdapter(getActivity().getApplicationContext(), R.layout.row_layout_match);

        //Sets adapter for the ListView
        eListMatchInfo.setAdapter(listMatchInfoAdapter);

        //Instantiates Database Helper with Application Context
        databaseHelperMatch = new DatabaseHelperMatch(getActivity().getApplicationContext());

        //Gets readable database through Database Helper
        sqLiteDatabase = databaseHelperMatch.getReadableDatabase();

        //Gets information from Database Helper and adds it to cursor
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

        //Instantiates  Floating Action Button with corresponding xml object
        addDataMatch = (FloatingActionButton) view.findViewById(R.id.fabMatch);

        //Creates event on button click
        addDataMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Declares and instantiates fragment
                AddMatchDataFragment fragment = new AddMatchDataFragment();

                //Begins transaction between one fragment to another
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                //Gets custom created animations and uses them during transactions
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);

                //Replaces original fragment with new fragment
                fragmentTransaction.replace(R.id.fragment_container, fragment);

                //Commits the transaction
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView
} //End of class
