package org.ramferno.scoutapplication.ramfernoscout;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class AddScoutDataFragment extends Fragment {
    //Android UI & Database objects
    Button cancelButton;
    Button addDataButton;
    DatabaseHelper myDB;
    EditText tNumber, tPortcullis, tChevalFrise, tMoat, tRamparts, tDrawbridge, tSallyPort, tRockWall, tRockTerrain, tLowBar, tAutoHigh, tAutoLow,
            tTeleHigh, tTeleLow, tTelePlay, tHang;
    SQLiteDatabase sqLiteDatabase;

    public AddScoutDataFragment() {
        // Required empty public constructor
    } //End of AddScoutDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_scout_data, container, false);

        //Starts database
        myDB = new DatabaseHelper(getActivity());

        //Instantiate all editText objects
        tNumber = (EditText) view.findViewById(R.id.editNumber);
        tPortcullis = (EditText) view.findViewById(R.id.editPortcullis);
        tChevalFrise = (EditText) view.findViewById(R.id.editChevalFrise);
        tMoat = (EditText) view.findViewById(R.id.editMoat);
        tRamparts = (EditText) view.findViewById(R.id.editRamparts);
        tDrawbridge = (EditText) view.findViewById(R.id.editDrawbridge);
        tSallyPort = (EditText) view.findViewById(R.id.editSallyPort);
        tRockWall = (EditText) view.findViewById(R.id.editRockWall);
        tRockTerrain = (EditText) view.findViewById(R.id.editRockTerrain);
        tLowBar = (EditText) view.findViewById(R.id.editLowBar);
        tAutoHigh = (EditText) view.findViewById(R.id.editHighGoal);
        tAutoLow = (EditText) view.findViewById(R.id.editLowGoal);
        tTeleHigh = (EditText) view.findViewById(R.id.editHighGoalOp);
        tTeleLow = (EditText) view.findViewById(R.id.editLowGoalOp);
        tTelePlay = (EditText) view.findViewById(R.id.editOffenseDefense);
        tHang = (EditText) view.findViewById(R.id.editHang);

        //Adds data to ScoutFragment
        addDataButton = (Button) view.findViewById(R.id.buttonDataAdd);
        addDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Saves data to database
                addScoutInfo();

                //Returns to ScoutFragment
                ScoutFragment fragment = new ScoutFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns to ScoutFragment without adding any data
        cancelButton = (Button) view.findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Returns to ScoutFragment
                ScoutFragment fragment = new ScoutFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    public void addScoutInfo() {
        //Converts all editText values into strings
        String sNumber = tNumber.getText().toString();
        String sPortcullis = tPortcullis.getText().toString();
        String sChevalFrise = tChevalFrise.getText().toString();
        String sMoat = tMoat.getText().toString();
        String sRamparts = tRamparts.getText().toString();
        String sDrawbridge = tDrawbridge.getText().toString();
        String sSallyPort = tSallyPort.getText().toString();
        String sRockWall = tRockWall.getText().toString();
        String sRockTerrain = tRockTerrain.getText().toString();
        String sLowBar = tLowBar.getText().toString();
        String sAutoHigh = tAutoHigh.getText().toString();
        String sAutoLow = tAutoHigh.getText().toString();
        String sTeleHigh = tAutoHigh.getText().toString();
        String sTeleLow = tAutoHigh.getText().toString();
        String sTelePlay = tAutoHigh.getText().toString();
        String sHang = tAutoHigh.getText().toString();

        //Saves data
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sNumber, sPortcullis, sChevalFrise, sMoat, sRamparts, sDrawbridge, sSallyPort, sRockWall,
                sRockTerrain, sLowBar, sAutoHigh, sAutoLow, sTeleHigh, sTeleLow, sTelePlay, sHang, sqLiteDatabase);
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
        myDB.close();
    } //End of addScoutInfo
} //End of class