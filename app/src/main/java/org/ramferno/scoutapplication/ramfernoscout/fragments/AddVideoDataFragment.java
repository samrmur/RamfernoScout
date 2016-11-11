/**
 * NAME: Samer Alabi
 * CLASS: AddVideoDataFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class is a fragment which contains instructions for two buttons, one that will record a
 * video and one the will cancel the entire operation and simply return to the original fragment
 * it transferred from. If a video is recorded, it's file path is saved to a database so that
 * the video can be accessed later.
 */

//Import all required packages and classes
package org.ramferno.scoutapplication.ramfernoscout.fragments;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperVideo;
import org.ramferno.scoutapplication.ramfernoscout.R;

//Start of AddVideoDataFragment
public class AddVideoDataFragment extends Fragment {
    //Declare and initialize video variable
    private int REQUEST_CODE = 0;

    //Declare Android UI & database objects
    Button btnRecordVideo, btnSaveVideo, btnCancelVideo;
    DatabaseHelperVideo myDB;
    EditText tTeam;
    String sVideoPath;
    SQLiteDatabase sqLiteDatabase;

    public AddVideoDataFragment() {
        //Required empty public constructor
    } //End of AddVideoDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_add_video_data, container, false);

        //Start database
        myDB = new DatabaseHelperVideo(getActivity());

        //Instantiate editText object
        tTeam = (EditText) view.findViewById(R.id.editTeamRecorded);

        //Switch to camera recording feature on phone
        btnRecordVideo = (Button) view.findViewById(R.id.buttonRecordVideo);
        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callVideoAppIntent = new Intent();
                callVideoAppIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(callVideoAppIntent, REQUEST_CODE);
            } //End of onClick
        }); //End of setOnClickListener

        //Save video path and return to VideoFragment with animations
        btnSaveVideo = (Button) view.findViewById(R.id.buttonSaveVideo);
        btnSaveVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Call method to save video path to database
                addVideoInfo();

                //Return to VideoFragment
                VideoFragment fragment = new VideoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left,
                        R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Return to VideoFragment with animations without adding any data
        btnCancelVideo = (Button) view.findViewById(R.id.buttonCancelVideo);
        btnCancelVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoFragment fragment = new VideoFragment();
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

    //Add video path data to the SQLite database
    public void addVideoInfo() {
        //Convert editText value to string and store in a string variable
        String sTeam = tTeam.getText().toString();

        //Save data to database
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sVideoPath, sTeam, sqLiteDatabase);

        //Create message on screen that indicates to the user that the data has been saved
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();

        //Close the database
        myDB.close();
    } //End of addScoutInfo

    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            //Get data from Uri object
            Uri videoUri = data.getData();

            //Convert Uri to string value then stores it in a string
            sVideoPath = videoUri.toString();
        } //End of if statement
    } //End of onActivityResult
} //End of class