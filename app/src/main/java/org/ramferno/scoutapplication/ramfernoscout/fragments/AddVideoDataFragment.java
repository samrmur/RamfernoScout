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

/**
 * A simple {@link Fragment} subclass.
 */
public class AddVideoDataFragment extends Fragment {
    //Video variables
    private int REQUEST_CODE = 0;

    //Android UI, database objects
    Button btnRecordVideo, btnSaveVideo, btnCancelVideo;
    DatabaseHelperVideo myDB;
    EditText tTeam;
    String sVideoPath;
    SQLiteDatabase sqLiteDatabase;

    public AddVideoDataFragment() {
        // Required empty public constructor
    } //End of AddVideoDataFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflates the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_add_video_data, container, false);

        //Starts database
        myDB = new DatabaseHelperVideo(getActivity());

        //Instantiate editText object
        tTeam = (EditText) view.findViewById(R.id.editTeamRecorded);

        //Instantiates record button with xml object
        btnRecordVideo = (Button) view.findViewById(R.id.buttonRecordVideo);

        //Creates event on button click
        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declares and instantiates Intent object
                Intent callVideoAppIntent = new Intent();

                //Sets Video Capture action for intent
                callVideoAppIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);

                //Starts default video capture program on device
                startActivityForResult(callVideoAppIntent, REQUEST_CODE);
            } //End of onClick
        }); //End of setOnClickListener

        //Instantiates save button with corresponding xml object
        btnSaveVideo = (Button) view.findViewById(R.id.buttonSaveVideo);

        //Creates event on button click
        btnSaveVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calls method on button click
                addVideoInfo();

                //Declares and instantiates VideoFragment
                VideoFragment fragment = new VideoFragment();

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

        //Instantiates cancel button with corresponding xml object
        btnCancelVideo = (Button) view.findViewById(R.id.buttonCancelVideo);

        //Creates event on button click
        btnCancelVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declares and instantiates VideoFragment
                VideoFragment fragment = new VideoFragment();

                //Begins transaction between one fragment to another
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                //Gets custom created animations and uses them during transactions
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);

                //Begins transaction between one fragment to another
                fragmentTransaction.replace(R.id.fragment_container, fragment);

                //Commits the transaction
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns view
        return view;
    } //End of onCreateView

    public void addVideoInfo() {
        //Converts editText values into strings
        String sTeam = tTeam.getText().toString();

        //Saves data to database
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sVideoPath, sTeam, sqLiteDatabase);

        //Creates message on screen that indicates the data has been saved
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();

        //Closes the database
        myDB.close();
    } //End of addScoutInfo

    //Creates event for what happens after a video is taken or not
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            //Gets data from Uri object
            Uri videoUri = data.getData();

            //Converts Uri to string value then stores it in a string
            sVideoPath = videoUri.toString();
        } //End of if statement
    } //End of onActivityResult
} //End of class