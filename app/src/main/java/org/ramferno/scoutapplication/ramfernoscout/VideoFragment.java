package org.ramferno.scoutapplication.ramfernoscout;

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

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {
    FloatingActionButton addVideoScout;
    ListView eListVideoInfo;
    SQLiteDatabase sqLiteDatabase;
    DatabaseHelperVideo databaseHelperVideo;
    Cursor cursor;
    ListVideoInfoAdapter listVideoInfoAdapter;

    public VideoFragment() {
        // Required empty public constructor
    } //End of VideoFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        eListVideoInfo = (ListView) view.findViewById(R.id.listVideoInfo);
        listVideoInfoAdapter = new ListVideoInfoAdapter(getActivity().getApplicationContext(), R.layout.row_layout_video);
        eListVideoInfo.setAdapter(listVideoInfoAdapter);
        databaseHelperVideo = new DatabaseHelperVideo(getActivity().getApplicationContext());
        sqLiteDatabase = databaseHelperVideo.getReadableDatabase();
        cursor = databaseHelperVideo.getInformation(sqLiteDatabase);

        //Checks if information is available in cursor
        if(cursor.moveToFirst()){
            do {
                //Declare all strings
                final String videoPath, team;

                //Get strings from cursor
                videoPath = cursor.getString(cursor.getColumnIndex(DatabaseContractVideo.NewDataInfo.COL_VIDEO_PATH));
                team =  cursor.getString(cursor.getColumnIndex(DatabaseContractVideo.NewDataInfo.COL_TEAM));

                //Get methods from DatabaseProvider
                DatabaseProviderVideo databaseProviderVideo = new DatabaseProviderVideo(videoPath, team);

                //Pass objects to add method
                listVideoInfoAdapter.add(databaseProviderVideo);
                listVideoInfoAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());
        } //End of if statement

        //Setups Floating Action Button
        addVideoScout = (FloatingActionButton) view.findViewById(R.id.fabVideo);
        addVideoScout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AddVideoDataFragment fragment = new AddVideoDataFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            } //End of onClick
        }); //End of setOnClickListener
        return view;
    } //End of onCreateView
} //End of class
