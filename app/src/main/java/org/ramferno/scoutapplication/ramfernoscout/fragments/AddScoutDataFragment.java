/**
 * NAME: Samer Alabi
 * CLASS: AddScoutDataFragment
 * LAST EDITED: November 4th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class is a fragment which contains CheckBox and EditText objects that a user will input
 * or change the input that will be stored in a database then later displayed in a ListView
 */

//Declare package and import classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.providers.AddressProvider;
import org.ramferno.scoutapplication.ramfernoscout.senders.ScoutSender;

//Start of AddScoutDataFragment class
public class AddScoutDataFragment extends Fragment {
    //Declare Android UI & Database objects
    Button cancelButton;
    Button addDataButton;
    EditText tNumber, tTelePlay;
    CheckBox tPortcullis, tChevalFrise, tMoat, tRamparts, tDrawbridge, tSallyPort, tRockWall,
            tRockTerrain, tLowBar, tAutoHigh, tAutoLow, tTeleHigh, tTeleLow, tHang;

    //Declare primary string variables
    String fPortcullis, fChevalFrise, fMoat, fRamparts, fDrawbridge, fSallyPort, fRockWall,
            fRockTerrain, fLowBar, fAutoHigh, fAutoLow, fTeleHigh, fTeleLow, fHang;

    public AddScoutDataFragment() {
        //Required empty public constructor
    } //End of AddScoutDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_add_scout_data, container, false);

        //Sets default value of primary strings
        fPortcullis = "No";
        fChevalFrise = "No";
        fMoat = "No";
        fRamparts = "No";
        fDrawbridge = "No";
        fSallyPort = "No";
        fRockWall = "No";
        fRockTerrain = "No";
        fLowBar = "No";
        fAutoHigh = "No";
        fAutoLow = "No";
        fTeleHigh = "No";
        fTeleLow = "No";
        fHang = "No";

        //Instantiate and link all objects to their corresponding xml objects
        tNumber = (EditText) view.findViewById(R.id.editNumber);
        tPortcullis = (CheckBox) view.findViewById(R.id.editPortcullis);
        tChevalFrise = (CheckBox) view.findViewById(R.id.editChevalFrise);
        tMoat = (CheckBox) view.findViewById(R.id.editMoat);
        tRamparts = (CheckBox) view.findViewById(R.id.editRamparts);
        tDrawbridge = (CheckBox) view.findViewById(R.id.editDrawbridge);
        tSallyPort = (CheckBox) view.findViewById(R.id.editSallyPort);
        tRockWall = (CheckBox) view.findViewById(R.id.editRockWall);
        tRockTerrain = (CheckBox) view.findViewById(R.id.editRockTerrain);
        tLowBar = (CheckBox) view.findViewById(R.id.editLowBar);
        tAutoHigh = (CheckBox) view.findViewById(R.id.editHighGoal);
        tAutoLow = (CheckBox) view.findViewById(R.id.editLowGoal);
        tTeleHigh = (CheckBox) view.findViewById(R.id.editHighGoalOp);
        tTeleLow = (CheckBox) view.findViewById(R.id.editLowGoalOp);
        tTelePlay = (EditText) view.findViewById(R.id.editOffenseDefense);
        tHang = (CheckBox) view.findViewById(R.id.editHang);

        //Checks checkboxes and change string if checked
        tPortcullis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)  {
                if(tPortcullis.isChecked()) {
                    fPortcullis = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tMoat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tMoat.isChecked()) {
                    fMoat = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tRamparts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRamparts.isChecked()) {
                    fRamparts = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tDrawbridge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tDrawbridge.isChecked()) {
                    fDrawbridge = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tSallyPort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tSallyPort.isChecked()) {
                    fSallyPort = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tRockWall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRockWall.isChecked()) {
                    fRockWall = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tRockTerrain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRockTerrain.isChecked()) {
                    fRockTerrain = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tLowBar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tLowBar.isChecked()) {
                    fLowBar = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tAutoHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tAutoHigh.isChecked()) {
                    fAutoHigh = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tAutoLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tAutoLow.isChecked()) {
                    fAutoLow = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tTeleHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tTeleHigh.isChecked()) {
                    fTeleHigh = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tTeleLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tTeleLow.isChecked()) {
                    fTeleLow = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener
        tHang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tHang.isChecked()) {
                    fHang = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Send data to database server on button click
        addDataButton = (Button) view.findViewById(R.id.buttonDataAdd);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Check if all required slots have been filled in
                try {
                    //Declare and initialize variable
                    String ipAddress;

                    //Attempt to get IP Address from Provider
                    try {
                        ipAddress = AddressProvider.getInstance().getAddress();
                    } catch (NullPointerException e) {
                        ipAddress = "";
                    } //End of try statement

                    //Insert IP address into full URl address
                    String urlAddress = "http://" + ipAddress +
                            "/ramfernoscout/database/scoutadd.php";

                    //Start ASync Task
                    ScoutSender s = new ScoutSender(getActivity(), urlAddress, tNumber,
                            fPortcullis, fChevalFrise, fMoat, fRamparts, fDrawbridge, fSallyPort,
                            fRockWall, fRockTerrain, fLowBar, fAutoHigh, fAutoLow, fTeleHigh,
                            fTeleLow, tTelePlay, fHang);
                    s.execute();

                    //Change fragment to ScoutFragment with animations
                    ScoutFragment fragment = new ScoutFragment();
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

        //Return to ScoutFragment with animations without adding any data on button click
        cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScoutFragment fragment = new ScoutFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,
                        R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Return view
        return view;
    } //End of onCreateView
} //End of class