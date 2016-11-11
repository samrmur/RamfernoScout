/**
 * NAME: Samer Alabi
 * CLASS: VideoFragment
 * LAST EDITED: November 11th, 2016
 * ------------------------------------ DESCRIPTION OF CLASS ------------------------------------
 * This class displays SQLite database information in a ListView object.
 */

//Import all required packages and classes
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

import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractVideo;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperVideo;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProviderVideo;
import org.ramferno.scoutapplication.ramfernoscout.adapters.ListVideoInfoAdapter;
import org.ramferno.scoutapplication.ramfernoscout.R;

//
public class VideoFragment extends Fragment {
    //Declare Android UI & Database objects
    FloatingActionButton addVideoScout;
    ListView eListVideoInfo;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelperVideo databaseHelperVideo;
    Cursor cursor;
    ListVideoInfoAdapter listVideoInfoAdapter;

    public VideoFragment() {
        //Required empty public constructor
    } //End of VideoFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflate layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        //Declare and instantiate objects and classes
        eListVideoInfo = (ListView) view.findViewById(R.id.listVideoInfo);
        listVideoInfoAdapter = new ListVideoInfoAdapter(getActivity().getApplicationContext(),
                R.layout.row_layout_video);
        databaseHelperVideo = new DatabaseHelperVideo(getActivity().getApplicationContext());

        //Retrieve the information from the SQLite database
        eListVideoInfo.setAdapter(listVideoInfoAdapter);
        sqLiteDatabase = databaseHelperVideo.getReadableDatabase();
        cursor = databaseHelperVideo.getInformation(sqLiteDatabase);

        //Check if information is available in cursor
        if(cursor.moveToFirst()){
            do {
                //Declare all strings
                final String videoPath, team;

                //Get strings from cursor
                videoPath = cursor.getString(cursor.getColumnIndex
                        (DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH));
                team =  cursor.getString(cursor.getColumnIndex
                        (DatabaseContractVideo.NewDataInfo.COL_TEAM));

                //Get methods from DatabaseProviderVideo
                DatabaseProviderVideo databaseProviderVideo = new
                        DatabaseProviderVideo(videoPath, team);

                //Pass objects to add method
                listVideoInfoAdapter.add(databaseProviderVideo);
                listVideoInfoAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        } //End of if statement

        //Change fragment to VideoFragment with animations
        addVideoScout = (FloatingActionButton) view.findViewById(R.id.fabVideo);
        addVideoScout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddVideoDataFragment fragment = new AddVideoDataFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right,
                        R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener

        //Return view
        return view;
    } //End of onCreateView
} //End of class