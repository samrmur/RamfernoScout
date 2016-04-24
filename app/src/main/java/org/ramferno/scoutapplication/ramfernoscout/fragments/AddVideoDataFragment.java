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
    private int REQUEST_CODE = 0;
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
        View view = inflater.inflate(R.layout.fragment_add_video_data, container, false);

        //Starts database
        myDB = new DatabaseHelperVideo(getActivity());

        //Instantiate all editText objects
        tTeam = (EditText) view.findViewById(R.id.editTeamRecorded);

        //Records Video
        btnRecordVideo = (Button) view.findViewById(R.id.buttonRecordVideo);
        btnRecordVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callVideoAppIntent = new Intent();
                callVideoAppIntent.setAction(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(callVideoAppIntent, REQUEST_CODE);
            } //End of onClick
        }); //End of setOnClickListener

        //Saves Video path and data
        btnSaveVideo = (Button) view.findViewById(R.id.buttonSaveVideo);
        btnSaveVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saves data to database
                addVideoInfo();

                //Returns to VideoFragment
                VideoFragment fragment = new VideoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Cancels all data and recordings
        btnCancelVideo = (Button) view.findViewById(R.id.buttonCancelVideo);
        btnCancelVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Returns to VideoFragment
                VideoFragment fragment = new VideoFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        return view;
    } //End of onCreateView

    public void addVideoInfo() {
        //Converts editText values into strings
        String sTeam = tTeam.getText().toString();

        //Saves data
        sqLiteDatabase = myDB.getWritableDatabase();
        myDB.addInformation(sVideoPath, sTeam, sqLiteDatabase);
        Toast.makeText(getContext(), "Data Saved", Toast.LENGTH_LONG).show();
        myDB.close();
    } //End of addScoutInfo

    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri videoUri = data.getData();
            sVideoPath = videoUri.toString();
        } //End of if statement
    } //End of onActivityResult
} //End of class
