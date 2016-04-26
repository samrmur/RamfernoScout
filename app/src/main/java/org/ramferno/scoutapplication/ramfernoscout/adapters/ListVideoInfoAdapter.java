package org.ramferno.scoutapplication.ramfernoscout.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.ramferno.scoutapplication.ramfernoscout.R;
import org.ramferno.scoutapplication.ramfernoscout.contracts.DatabaseContractVideo;
import org.ramferno.scoutapplication.ramfernoscout.helpers.DatabaseHelperVideo;
import org.ramferno.scoutapplication.ramfernoscout.providers.DatabaseProviderVideo;

import java.util.ArrayList;
import java.util.List;

public class ListVideoInfoAdapter extends ArrayAdapter {
    //Declares and instantiates objects
    List list = new ArrayList();
    DatabaseHelperVideo databaseHelperVideo = new DatabaseHelperVideo(getContext());

    public ListVideoInfoAdapter (Context context, int resource) {
        super(context, resource);
    } //End of ListVideoInfoAdapter

    static class LayoutHandler {
        //Declares Android object
        TextView TEAM;

        //Declares variable
        String VIDEO_PATH;
    } //End of LayoutHandler

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);
    } //End of add

    @Override
    public int getCount() {
        return list.size();
    } //End of getCount

    @Override
    public Object getItem(int position) {
        return list.get(position);
    } //End of getItem

    //Deletes a row in the database
    public void deleteRow(String rowId){
        //Retrieves database in writable form
        SQLiteDatabase db = databaseHelperVideo.getWritableDatabase();

        //Deletes a row
        db.delete(DatabaseContractVideo.NewDataInfo.TABLE_NAME,
                DatabaseContractVideo.NewDataInfo.COL_TEAM + "=?",
                new String[] {String.valueOf(rowId)});
    } //End of deleteRow

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Declares objects
        View row = convertView;
        final LayoutHandler layoutHandler;

        //Checks to see if row is empty
        if (row == null){
            //Declares and instantiates LayoutInflater object
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //Inflates the row view with the row layout using the layout inflater
            row = layoutInflater.inflate(R.layout.row_layout_video, parent, false);

            //Instantiates layout handler
            layoutHandler = new LayoutHandler();

            //Inflates row with TextView data entered by the user
            layoutHandler.TEAM = (TextView) row.findViewById(R.id.resultTeamRecorded);

            //Sets layout handler tag on row so that row can remember the data inserted by the user
            row.setTag(layoutHandler);
        }
        else {
            //Gets tag from row and implements it into the layout handler if row has data
            layoutHandler = (LayoutHandler) row.getTag();
        } //End of if statement
        final DatabaseProviderVideo databaseProviderVideo = (DatabaseProviderVideo) this.getItem(position);

        //Sets the text of the layout handler strings through the database provider
        layoutHandler.TEAM.setText(databaseProviderVideo.getTeam());
        layoutHandler.VIDEO_PATH = databaseProviderVideo.getVideoPath();

        //Declares and instantiates play button
        Button playBtn = (Button) row.findViewById(R.id.buttonPlayVideo);

        //Creates event on button click
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declares object
                Uri uri;

                //Checks if there is a video file available
                if (layoutHandler.VIDEO_PATH == null) {
                    //Creates message on screen that tells the user that there is no available video to play
                    Toast.makeText(getContext(), "Video file not found", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Parses Video Path string to uri format
                    uri = Uri.parse(layoutHandler.VIDEO_PATH);

                    //Creates intent that will launch a video player
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    //Starts the video player with video in uri
                    v.getContext().startActivity(intent);
                } //End of if statement
            } //End of onClick
        }); //End of setOnClickListener

        //Declares and instantiates delete button
        Button deleteBtn = (Button) row.findViewById(R.id.buttonDeleteVideo);

        //Sets tag on delete button that will enable the button to delete the row in the database
        deleteBtn.setTag(databaseProviderVideo.getTeam());

        //Creates event on button click
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteRow((String) v.getTag());
                list.remove(position);
                notifyDataSetChanged();
            } //End of onClick
        }); //End of setOnClickListener

        //Returns row
        return row;
    } //End of getView
} //End of ListVideoInfoAdapter
