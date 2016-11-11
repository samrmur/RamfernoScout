/**
 * NAME: Samer Alabi
 * CLASS: AddMatchDataFragment
 * LAST EDITED: November 6th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class is a fragment which contains EditText objects that a user will input
 * or change the input that will be stored in a database then later displayed in a ListView
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.AddressProvider;
import org.ramferno.scoutapplication.ramfernoscout.senders.MatchSender;

//Start of AddMatchDataFragment
public class AddMatchDataFragment extends Fragment {
    //Declares Android UI & Database objects
    Button cancelButtonMatch;
    Button addMatchButton;
    EditText matchNumber, blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne,
            redTeamTwo, redTeamThree, blueScore, redScore;


    public AddMatchDataFragment() {
        // Required empty public constructor
    } //End of AddMatchDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflates the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_add_match_data, container, false);

        //Instantiates all editText objects
        matchNumber = (EditText) view.findViewById(R.id.editNumberMatch);
        blueTeamOne = (EditText) view.findViewById(R.id.editBlueOne);
        blueTeamTwo = (EditText) view.findViewById(R.id.editBlueTwo);
        blueTeamThree = (EditText) view.findViewById(R.id.editBlueThree);
        redTeamOne = (EditText) view.findViewById(R.id.editRedOne);
        redTeamTwo = (EditText) view.findViewById(R.id.editRedTwo);
        redTeamThree = (EditText) view.findViewById(R.id.editRedThree);
        blueScore = (EditText) view.findViewById(R.id.editBlueScore);
        redScore = (EditText) view.findViewById(R.id.editRedScore);

        //Send data to database server on button click
        addMatchButton = (Button) view.findViewById(R.id.buttonAddDataMatch);
        addMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Check if all required slots have been filled in
                try {
                    //Declare and initialize variable
                    String ipAddress;

                    //Attempt to get IP Address from Provider
                    try {
                        ipAddress = AddressProvider.getInstance().getAddress();
                    }
                    catch (NullPointerException e) {
                        ipAddress = "";
                    } //End of try statement

                    //Insert IP address into full URl address
                    String urlAddress = "http://" + ipAddress +
                            "/ramfernoscout/database/matchadd.php";

                    //Start ASync Task
                    MatchSender s = new MatchSender(getActivity(), urlAddress, matchNumber,
                            blueTeamOne, blueTeamTwo, blueTeamThree, redTeamOne,
                            redTeamTwo, redTeamThree,
                            blueScore, redScore);
                    s.execute();

                    //Change fragment to MatchFragment with animations
                    MatchFragment fragment = new MatchFragment();
                    FragmentTransaction fragmentTransaction = getFragmentManager()
                            .beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,
                            R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                catch (NumberFormatException e) {
                    Toast.makeText(getActivity(),"ERROR: Please fill all empty data slots!",
                            Toast.LENGTH_SHORT).show();
                } //End of try statement
            } //End of onClick
        }); //End of setOnClickListener

        //Return to MatchFragment with animations without adding any data on button click
        cancelButtonMatch = (Button) view.findViewById(R.id.buttonCancelMatch);
        cancelButtonMatch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MatchFragment fragment = new MatchFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,
                        R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView
} //End of class