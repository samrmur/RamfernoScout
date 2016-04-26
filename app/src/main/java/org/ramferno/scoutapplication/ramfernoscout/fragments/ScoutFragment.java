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

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContract;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelper;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProvider;
import org.ramferno.scoutapplication.ramfernoscout.adapters.ListScoutInfoAdapter;
import org.ramferno.scoutapplication.ramfernoscout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoutFragment extends Fragment {
    //Declares Android UI & Database objects
    FloatingActionButton addDataScout;
    ListView eListScoutInfo;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Cursor cursor;
    ListScoutInfoAdapter listScoutInfoAdapter;

    public ScoutFragment() {
        // Required empty public constructor
    } //End of ScoutFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflates layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scout, null, false);

        //Instantiates ListView object with the xml ListView object
        eListScoutInfo = (ListView) view.findViewById(R.id.listScoutInfo);

        //Instantiates ArrayAdapter with Application Context and inflates with row layout
        listScoutInfoAdapter = new ListScoutInfoAdapter(getActivity().getApplicationContext(), R.layout.row_layout);

        //Sets adapter for the ListView
        eListScoutInfo.setAdapter(listScoutInfoAdapter);

        //Instantiates Database Helper with Application Context
        databaseHelper = new DatabaseHelper(getActivity().getApplicationContext());

        //Gets readable database through Database Helper
        sqLiteDatabase = databaseHelper.getReadableDatabase();

        //Gets information from Database Helper and adds it to cursor
        cursor = databaseHelper.getInformation(sqLiteDatabase);

        //Checks if information is available in cursor
        if(cursor.moveToFirst()){
            do {
                //Declare all strings
                final String teamNumber, portcullis, chevalFrise, moat, ramparts, drawbridge, sallyPort, rockWall, rockTerrain, lowBar,
                        autoHigh, autoLow, teleHigh, teleLow, telePlay, hang;

                //Get strings from cursor
                teamNumber = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_NUMBER));
                portcullis =  cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_PORTCULLIS));
                chevalFrise = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_CHEVAL_FRISE));
                moat = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_MOAT));
                ramparts = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_RAMPARTS));
                drawbridge = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_DRAWBRIDGE));
                sallyPort = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_SALLY_PORT));
                rockWall = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_ROCK_WALL));
                rockTerrain = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_ROCK_TERRAIN));
                lowBar = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_LOW_BAR));
                autoHigh = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_AUTO_HIGH));
                autoLow = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_AUTO_LOW));
                teleHigh = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_TELE_HIGH));
                teleLow = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_TELE_LOW));
                telePlay = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_TELE_PLAY));
                hang = cursor.getString(cursor.getColumnIndex(DatabaseContract.NewDataInfo.COL_HANG));

                //Get methods from DatabaseProvider
                DatabaseProvider databaseProvider = new DatabaseProvider(teamNumber, portcullis, chevalFrise, moat, ramparts,
                        drawbridge, sallyPort, rockWall, rockTerrain, lowBar, autoHigh, autoLow, teleHigh, teleLow, telePlay, hang);

                //Pass objects to add method
                listScoutInfoAdapter.add(databaseProvider);

                //Notifies adapter that data has been changed and updates the Data Set
                listScoutInfoAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        } //End of if statement

        //Instantiates Floating Action Button with corresponding xml object
        addDataScout = (FloatingActionButton) view.findViewById(R.id.fab);

        //Creates event on button click
        addDataScout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Declares and instantiates fragment
                AddScoutDataFragment fragment = new AddScoutDataFragment();

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
