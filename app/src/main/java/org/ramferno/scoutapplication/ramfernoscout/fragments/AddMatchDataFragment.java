package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperMatch;
import org.ramferno.scoutapplication.ramfernoscout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddMatchDataFragment extends Fragment {
    //Android UI & Database objects
    Button cancelButtonMatch;
    Button addMatchButton;
    DatabaseHelperMatch myDB;
    EditText tMatchNumber, tBlueTeamOne, tBlueTeamTwo, tBlueTeamThree, tRedTeamOne, tRedTeamTwo, tRedTeamThree, tBlueScore, tRedScore;
    SQLiteDatabase sqLiteDatabase;

    public AddMatchDataFragment() {
        // Required empty public constructor
    } //End of AddMatchDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_match_data, container, false);

        //Starts database
        myDB = new DatabaseHelperMatch(getActivity());

        //Instantiate all editText objects
        tMatchNumber = (EditText) view.findViewById(R.id.editNumberMatch);
        tBlueTeamOne = (EditText) view.findViewById(R.id.editBlueOne);
        tBlueTeamTwo = (EditText) view.findViewById(R.id.editBlueTwo);
        tBlueTeamThree = (EditText) view.findViewById(R.id.editBlueThree);
        tRedTeamOne = (EditText) view.findViewById(R.id.editRedOne);
        tRedTeamTwo = (EditText) view.findViewById(R.id.editRedTwo);
        tRedTeamThree = (EditText) view.findViewById(R.id.editRedThree);
        tBlueScore = (EditText) view.findViewById(R.id.editBlueScore);
        tRedScore = (EditText) view.findViewById(R.id.editRedScore);

        //Adds data to MatchFragment
        addMatchButton = (Button) view.findViewById(R.id.buttonAddDataMatch);
        addMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Saves data to database
                addMatchInfo();

                //Returns to MatchFragment
                MatchFragment fragment = new MatchFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns to MatchFragment without adding any data
        cancelButtonMatch = (Button) view.findViewById(R.id.buttonCancelMatch);
        cancelButtonMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Returns to MatchFragment
                MatchFragment fragment = new MatchFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    public void addMatchInfo() {
        //Converts all editText values into strings
        String sMatchNumber = tMatchNumber.getText().toString();
        String sBlueTeamOne = tBlueTeamOne.getText().toString();
        String sBlueTeamTwo = tBlueTeamTwo.getText().toString();
        String sBlueTeamThree = tBlueTeamThree.getText().toString();
        String sRedTeamOne = tRedTeamOne.getText().toString();
        String sRedTeamTwo = tRedTeamTwo.getText().toString();
        String sRedTeamThree = tRedTeamThree.getText().toString();
        String sBlueScore = tBlueScore.getText().toString();
        String sRedScore = tRedScore.getText().toString();

        //Saves data to database
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sMatchNumber, sBlueTeamOne, sBlueTeamTwo, sBlueTeamThree, sRedTeamOne, sRedTeamTwo, sRedTeamThree, sBlueScore,
                sRedScore, sqLiteDatabase);

        //Creates message on screen that indicates the data has been saved
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();

        //Closes the database
        myDB.close();
    } //End of addScoutInfo
} //End of class