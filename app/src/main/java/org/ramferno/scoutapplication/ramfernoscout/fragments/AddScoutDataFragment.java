package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.database.sqlite.SQLiteDatabase;
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

import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelper;
import org.ramferno.scoutapplication.ramfernoscout.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddScoutDataFragment extends Fragment {
    //Declares Android UI & Database objects
    Button cancelButton;
    Button addDataButton;
    DatabaseHelper myDB;
    EditText tNumber, tTelePlay;
    CheckBox tPortcullis, tChevalFrise, tMoat, tRamparts, tDrawbridge, tSallyPort, tRockWall, tRockTerrain, tLowBar, tAutoHigh, tAutoLow,
            tTeleHigh, tTeleLow, tHang;
    SQLiteDatabase sqLiteDatabase;

    //Declares primary string variables
    String fPorticullis, fChevalFrise, fMoat, fRamparts, fDrawbridge, fSallyPort, fRockWall, fRockTerrain, fLowBar, fAutoHigh, fAutoLow,
            fTeleHigh, fTeleLow, fHang;

    public AddScoutDataFragment() {
        // Required empty public constructor
    } //End of AddScoutDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflates the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_add_scout_data, container, false);

        //Starts database
        myDB = new DatabaseHelper(getActivity());

        //Sets default value of primary strings
        fPorticullis = "No";
        fChevalFrise = "No";
        fMoat = "No";
        fRamparts = "No";
        fDrawbridge = "No";
        fSallyPort = "No";
        fRockWall = "No";
        fRockTerrain = "No";
        fLowBar= "No";
        fAutoHigh = "No";
        fAutoLow = "No";
        fTeleHigh = "No";
        fTeleLow = "No";
        fHang = "No";

        //Instantiate all editText objects
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

        //Checks checkbox for values then converts values into strings
        tPortcullis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)  {
                if(tPortcullis.isChecked()) {
                    fPorticullis = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tMoat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tMoat.isChecked()) {
                    fMoat = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tRamparts.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRamparts.isChecked()) {
                    fRamparts = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tDrawbridge.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tDrawbridge.isChecked()) {
                    fDrawbridge = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tSallyPort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tSallyPort.isChecked()) {
                    fSallyPort = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tRockWall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRockWall.isChecked()) {
                    fRockWall = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tRockTerrain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tRockTerrain.isChecked()) {
                    fRockTerrain = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tLowBar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tLowBar.isChecked()) {
                    fLowBar = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tAutoHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tAutoHigh.isChecked()) {
                    fAutoHigh = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tAutoLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tAutoLow.isChecked()) {
                    fAutoLow = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tTeleHigh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tTeleHigh.isChecked()) {
                    fTeleHigh = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tTeleLow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tTeleLow.isChecked()) {
                    fTeleLow = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Checks checkbox for values then converts values into strings
        tHang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(tHang.isChecked()) {
                    fHang = "Yes";
                } //End of if statement
            } //End of onClick
        }); //End of onClickListener

        //Instantiates add scout data button with corresponding xml object
        addDataButton = (Button) view.findViewById(R.id.buttonDataAdd);

        //Event created on button click that adds data to database and returns to ScoutFragment
        addDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Calls method on button click
                addScoutInfo();

                //Declares and instantiates ScoutFragment
                ScoutFragment fragment = new ScoutFragment();

                //Begins transaction between one fragment to another
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                //Gets custom created animations and uses them during transactions
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                //Replaces original fragment with new fragment
                fragmentTransaction.replace(R.id.fragment_container, fragment);

                //Commits the transaction
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns to ScoutFragment without adding any data
        cancelButton = (Button) view.findViewById(R.id.buttonCancel);

        //Event created on button click that cancels any data entered and returns to ScoutFragment
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Declares and instantiates ScoutFragment
                ScoutFragment fragment = new ScoutFragment();

                //Begins transaction between one fragment to another
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                //Gets custom created animations and uses them during transactions
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                //Replaces original fragment with new fragment
                fragmentTransaction.replace(R.id.fragment_container, fragment);

                //Commits the transaction
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    //Method that gets data from primary strings and stores them into data strings and saves the data in the data strings into the database
    public void addScoutInfo() {
        //Stores primary strings into data strings
        String sNumber = tNumber.getText().toString();;
        String sPortcullis = fPorticullis;
        String sChevalFrise = fChevalFrise;
        String sMoat = fMoat;
        String sRamparts = fRamparts;
        String sDrawbridge = fDrawbridge;
        String sSallyPort = fSallyPort;
        String sRockWall = fRockWall;
        String sRockTerrain = fRockTerrain;
        String sLowBar = fLowBar;
        String sAutoHigh = fAutoHigh;
        String sAutoLow = fAutoLow;
        String sTeleHigh = fTeleHigh;
        String sTeleLow = fTeleLow;
        String sTelePlay = tTelePlay.getText().toString();
        String sHang = fHang;

        //Saves data to database
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sNumber, sPortcullis, sChevalFrise, sMoat, sRamparts, sDrawbridge, sSallyPort, sRockWall,
                sRockTerrain, sLowBar, sAutoHigh, sAutoLow, sTeleHigh, sTeleLow, sTelePlay, sHang, sqLiteDatabase);

        //Creates message on screen that indicates the data has been saved
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();

        //Closes the database
        myDB.close();
    } //End of addScoutInfo
} //End of class